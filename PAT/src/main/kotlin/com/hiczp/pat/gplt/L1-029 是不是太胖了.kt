package com.hiczp.pat.gplt

/**
 * L1-029 是不是太胖了 （5 分）
 * 据说一个人的标准体重应该是其身高（单位：厘米）减去100、再乘以0.9所得到的公斤数。
 * 已知市斤是公斤的两倍。现给定某人身高，请你计算其标准体重应该是多少？（顺便也悄悄给自己算一下吧……）
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    println(
        "%.1f".format(
            readLine()!!.toInt() * 1.8 - 180
        )
    )
}
