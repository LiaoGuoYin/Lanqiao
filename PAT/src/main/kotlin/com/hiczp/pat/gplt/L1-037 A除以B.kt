package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-037 A除以B （10 分）
 * 真的是简单题哈 —— 给定两个绝对值不超过100的整数A和B，要求你按照“A/B=商”的格式输出结果。
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    //输入
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    //计算结果
    val result = if (b == 0) {
        "Error"
    } else {
        "%.2f".format(a.toDouble() / b)
    }

    //输出
    println("$a/${if (b >= 0) "$b" else "($b)"}=$result")
}
