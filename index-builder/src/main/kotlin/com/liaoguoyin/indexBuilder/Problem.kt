package com.liaoguoyin.indexBuilder

import java.io.File
import java.nio.file.Paths

@Suppress("MemberVisibilityCanBePrivate")
class Problem(
    val site: Site,
    val problemSet: String,
    val id: String,
    val title: String
) {
    constructor(site: Site, problemSet: String, idAndTitle: String) : this(
        site,
        problemSet,
        idAndTitle.substringBefore(' '),
        idAndTitle.substringAfter(' ')
    )

    val solution: Map<Language, File?>
        get() = directoryMapping[site]?.get(problemSet)?.mapValues { (language, parentPath) ->
            val problemDirectory = Paths.get("$site/src/main/").resolve(parentPath).toFile()
            //如果原本应该存放代码的目录不存在则直接返回
            if (!problemDirectory.exists()) return@mapValues null
            //对不同的语言采取不同的策略
            when (language) {
                Language.KOTLIN -> problemDirectory.resolve("$id $title.kt")
                Language.JAVA -> {
                    //java 的代码放在以题目 id 为名字的文件夹里(不包含 -)
                    val directory = problemDirectory.resolve(id.replace("-", ""))
                    if (!directory.exists()) {
                        null
                    } else {
                        //预定的 java 代码位置
                        val file = directory.resolve("Main.java")
                        //如果预定的 java 代码不存在, 那么目标目录可能有多种解法
                        when {
                            file.exists() -> file
                            directory.listFiles().isNotEmpty() -> directory
                            else -> null
                        }
                    }
                }
            }?.takeIf { it.exists() }
        }?.toSortedMap() ?: throw IllegalStateException("No such problem set: $site $problemSet")
}
