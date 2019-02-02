package com.hiczp.pat.gplt

/**
 * L1-008 求整数段和 （10 分）
 * 给定两个整数A和B，输出从A到B的所有整数以及这些数的和。
 *
 * 这是一个控制台输出控制问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //读取 a 和 b
    val (a, b) = readLine()!!.split(' ').map { it.toInt() }

    //输出
    for (current in a..b) {
        print("%5d".format(current))
        if ((current - a + 1) % 5 == 0 || current == b) println()
    }

    //总和
    //不要在上面的循环里一项一项加, 使用等差数列求和公式一步完成
    println("Sum = ${(a + b) * (b - a + 1) / 2}")
}
