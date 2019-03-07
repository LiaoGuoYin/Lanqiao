package com.liaoguoyin.indexBuilder

import java.nio.file.Paths

fun main() {
    val linesBeforeAutoGenerateTag = readme.readLines().toMutableList().apply {
        indexOfFirst {
            it.startsWith(autoGenerateTag)
        }.also {
            if (it != -1 && size > it + 1) subList(it + 1, size).clear()
        }
    }

    readme.bufferedWriter().use { writer ->
        linesBeforeAutoGenerateTag.forEach {
            writer.writeLine(it)
        }

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

fun index(site: Site) =
    Paths.get("$site/src/main/meta/").toFile().listFiles().associate { metaFile ->
        metaFile.name to metaFile.readLines().map { Problem(site, metaFile.name, it) }
    }
