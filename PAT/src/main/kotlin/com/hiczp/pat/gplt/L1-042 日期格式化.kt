package com.hiczp.pat.gplt

/**
 * L1-042 日期格式化 （5 分）
 * 世界上不同国家有不同的写日期的习惯。
 * 比如美国人习惯写成“月-日-年”，而中国人习惯写成“年-月-日”。
 * 下面请你写个程序，自动把读入的美国格式的日期改写成中国习惯的日期。
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val (mm, dd, yyyy) = readLine()!!.split('-')
    println("$yyyy-$mm-$dd")
}
