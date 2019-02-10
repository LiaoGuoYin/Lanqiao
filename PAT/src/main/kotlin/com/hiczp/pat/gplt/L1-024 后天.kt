package com.hiczp.pat.gplt

/**
 * L1-024 后天 （5 分）
 * 如果今天是星期三，后天就是星期五；如果今天是星期六，后天就是星期一。
 * 我们用数字1到7对应星期一到星期日。
 * 给定某一天，请你输出那天的“后天”是星期几。
 *
 * 简单的判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val result = (n + 2) % 7
    println(if (result == 0) 7 else result)
}
