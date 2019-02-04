package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-007 念数字 （10 分）
 * 输入一个整数，输出每个数字对应的拼音。当整数为负数时，先输出fu字。十个数字对应的拼音如下：
 * 0: ling
 * 1: yi
 * 2: er
 * 3: san
 * 4: si
 * 5: wu
 * 6: liu
 * 7: qi
 * 8: ba
 * 9: jiu
 *
 * 这是一个简单的映射问题, 使用一个编码表来解决
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //创建映射表
    val table = arrayOf(
        "ling",
        "yi",
        "er",
        "san",
        "si",
        "wu",
        "liu",
        "qi",
        "ba",
        "jiu"
    )

    Scanner(System.`in`).nextLine()
        .map {
            when (it) {
                '-' -> "fu" //处理复数的情况
                else -> table[Character.getNumericValue(it)]
            }
        }
        .joinToString(separator = " ")
        .let(::println)
}
