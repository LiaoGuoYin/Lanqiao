package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-051 打折 （5 分）
 * 去商场淘打折商品时，计算打折以后的价钱是件颇费脑子的事情。
 * 例如原价 ￥988，标明打 7 折，则折扣价应该是 ￥988 x 70% = ￥691.60。本题就请你写个程序替客户计算折扣价。
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("%.2f".format(scanner.nextDouble() * scanner.nextDouble() / 10))
}
