package com.hiczp.pat.gplt

/**
 * L1-010 比较大小 （10 分）
 * 本题要求将输入的任意3个整数从小到大输出。
 *
 * 这是一个排序问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    readLine()!!.split(' ')
        .map { it.toLong() }
        .sorted()
        .joinToString(separator = "->")
        .let {
            println(it)
        }
}
