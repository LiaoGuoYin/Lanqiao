package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-031 到底是不是太胖了 （10 分）
 * 据说一个人的标准体重应该是其身高（单位：厘米）减去100、再乘以0.9所得到的公斤数。
 * 真实体重与标准体重误差在10%以内都是完美身材（即 | 真实体重 − 标准体重 | < 标准体重×10%）。
 * 已知市斤是公斤的两倍。现给定一群人的身高和实际体重，请你告诉他们是否太胖或太瘦了。
 *
 * 这道题居然出现了浮点数精度问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        val height = scanner.nextBigDecimal()
        val weight = scanner.nextBigDecimal() / 2.toBigDecimal()
        val standardWeight = height * 0.9.toBigDecimal() - 90.toBigDecimal()
        @Suppress("SpellCheckingInspection")
        when {
            weight <= standardWeight * 0.9.toBigDecimal() -> "You are tai shou le!"
            weight < standardWeight * 1.1.toBigDecimal() -> "You are wan mei!"
            else -> "You are tai pang le!"
        }.run(::println)
    }
}
