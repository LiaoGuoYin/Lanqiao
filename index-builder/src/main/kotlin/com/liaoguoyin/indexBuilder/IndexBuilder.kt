package com.liaoguoyin.indexBuilder

import java.nio.file.Paths

fun main() {
    //获取 autoGenerate 标签前的内容
    val linesBeforeAutoGenerateTag = readme.readLines().toMutableList().apply {
        indexOfFirst {
            it.startsWith(autoGenerateTag)
        }.also {
            if (it != -1 && size > it + 1) subList(it + 1, size).clear()
        }
    }

    readme.bufferedWriter().use { writer ->
        //写入前半部分内容
        linesBeforeAutoGenerateTag.forEach {
            writer.writeLine(it)
        }

        //开始写入索引
        Site.values().associate {
            it to index(it)
        }.forEach { site, problemSets ->
            if (problemSets.isEmpty()) return@forEach
            problemSets.forEach { problemSetName, problems ->
                writer.writeLine("$site $problemSetName")
                writer.newLine()
                writer.writeLine("| ID | Title | Solution |")
                writer.writeLine("| :--- | :---------- | :----: |")
                problems.forEach { problem ->
                    writer.write("| ${problem.id} | ${problem.title} | ")
                    problem.solution.forEach { language, file ->
                        if (file != null) {
                            //此处仅转义空格, 应该没有什么问题
                            writer.write(
                                "[${language.toString().toLowerCase().capitalize()}]" +
                                        "(${file.path.replace(" ", "%20")}) "
                            )
                        }
                    }
                    writer.writeLine("|")
                }
                writer.newLine()
            }
        }

        writer.flush()
    }
}

private fun index(site: Site) =
    Paths.get("$site/src/main/meta/").toFile().listFiles().associate { metaFile ->
        metaFile.name to metaFile.readLines().map { Problem(site, metaFile.name, it) }
    }
