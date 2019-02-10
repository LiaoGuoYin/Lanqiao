package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-022 奇偶分家 （10 分）
 * 给定N个正整数，请统计奇数和偶数各有多少个？
 *
 * 简单的计数问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    var odd = 0
    var even = 0

    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        if (scanner.nextInt() % 2 == 0) {
            even++
        } else {
            odd++
        }
    }

    println("$odd $even")
}
