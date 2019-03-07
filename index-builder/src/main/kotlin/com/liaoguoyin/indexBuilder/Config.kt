package com.liaoguoyin.indexBuilder

import java.io.File

val readme = File("README.md")

const val autoGenerateTag = "<!-- auto generate -->"

@Suppress("NonAsciiCharacters", "EnumEntryName")
enum class Site {
    PAT,
    蓝桥
}

enum class Language {
    JAVA,
    KOTLIN
}

@Suppress("SpellCheckingInspection")
val directoryMapping = mapOf(
    Site.PAT to mapOf(
        "团体程序设计天梯赛-练习集" to mapOf(
            Language.JAVA to "java/com/liaoguoyin/pat/团体程序设计天梯赛/",
            Language.KOTLIN to "kotlin/com/hiczp/pat/gplt"
        )
    ),
    Site.蓝桥 to mapOf(
        "入门训练" to mapOf(
            Language.JAVA to "java/com/liaoguoyin/蓝桥/入门训练/"
        ),
        "基础训练" to mapOf(
            Language.JAVA to "java/com/liaoguoyin/蓝桥/基础训练/"
        ),
        "算法练习" to mapOf(
            Language.JAVA to "java/com/liaoguoyin/蓝桥/算法练习/"
        )
    )
)
