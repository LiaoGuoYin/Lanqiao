package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * L1-044 稳赢 （15 分）
 * 大家应该都会玩“锤子剪刀布”的游戏：两人同时给出手势，胜负规则如图所示：
 * 现要求你编写一个稳赢不输的程序，根据对方的出招，给出对应的赢招。但是！为了不让对方输得太惨，你需要每隔K次就让一个平局。
 *
 * 简单的计数问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    //输入 k
    val k = bufferedReader.readLine().toInt()
    //计数器, 已平局次数
    var counter = 0
    while (true) {
        val input = bufferedReader.readLine()
        if (input == "End") break

        //本回合需要平局
        if (counter == k) {
            counter = 0
            println(input)
            continue
        }

        @Suppress("SpellCheckingInspection")
        when (input) {
            "ChuiZi" -> "Bu"
            "JianDao" -> "ChuiZi"
            else -> "JianDao"
        }.run(::println)

        //计数器自增
        counter++
    }
}
