package com.hiczp.pat.gplt

import java.math.BigInteger

/**
 * L1-025 正整数A+B （15 分）
 * 题的目标很简单，就是求两个正整数A和B的和，其中A和B都在区间[1,1000]。
 * 稍微有点麻烦的是，输入并不保证是两个正整数。
 *
 * 这是一个类型转换和判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val input = readLine()!!
    //第一个空格的位置
    val indexOfFirstSpace = input.indexOf(' ')
    //截断字符串
    val a = input.substring(0, indexOfFirstSpace).toBigIntegerOrNull()
    val b = input.substring(indexOfFirstSpace + 1, input.length).toBigIntegerOrNull()

    //验证合法性
    val aValid = a.validate()
    val bValid = b.validate()

    //构造输出
    val outputA = if (aValid) a.toString() else "?"
    val outputB = if (bValid) b.toString() else "?"
    val outputSum = if (aValid && bValid) (a!! + b!!).toString() else "?"

    println("$outputA + $outputB = $outputSum")
}

private fun BigInteger?.validate() =
    this != null && signum() == 1 && this >= 1.toBigInteger() && this <= 1000.toBigInteger()
