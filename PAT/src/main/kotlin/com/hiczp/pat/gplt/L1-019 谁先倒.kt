package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-019 谁先倒 （15 分）
 * 划拳是古老中国酒文化的一个有趣的组成部分。
 * 酒桌上两人划拳的方法为：每人口中喊出一个数字，同时用手比划出一个数字。
 * 如果谁比划出的数字正好等于两人喊出的数字之和，谁就输了，输家罚一杯酒。
 * 两人同赢或两人同输则继续下一轮，直到唯一的赢家出现。
 * 下面给出甲、乙两人的酒量（最多能喝多少杯不倒）和划拳记录，请你判断两个人谁先倒。
 *
 * 这是一个简单的数据判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    //两个人的酒量
    val person1Limit = scanner.nextInt()
    val person2Limit = scanner.nextInt()

    //已喝的酒的数量
    var person1Drunk = 0
    var person2Drunk = 0

    repeat(scanner.nextInt()) {
        //一轮划拳
        val person1Said = scanner.nextInt()
        val person1Do = scanner.nextInt()
        val person2Said = scanner.nextInt()
        val person2Do = scanner.nextInt()

        //如果两人划出的一样, 那就肯定都不输
        if (person1Do == person2Do) return@repeat

        //两人报出的数字的总和
        val total = person1Said + person2Said
        //判断输赢
        if (person1Do == total) {
            person1Drunk++
        } else if (person2Do == total) {
            person2Drunk++
        }

        //判断是否有人倒下
        when {
            person1Drunk > person1Limit -> "A" to person2Drunk
            person2Drunk > person2Limit -> "B" to person1Drunk
            else -> null
        }?.let { (person, count) ->
            println(person)
            println(count)
            return
        }
    }
}
