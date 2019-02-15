package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-047 装睡 （10 分）
 * 你永远叫不醒一个装睡的人 —— 但是通过分析一个人的呼吸频率和脉搏，你可以发现谁在装睡！医生告诉我们，正常人睡眠时的呼吸频率是每分钟15-20次，脉搏是每分钟50-70次。
 * 下面给定一系列人的呼吸频率与脉搏，请你找出他们中间有可能在装睡的人，即至少一项指标不在正常范围内的人。
 *
 * 简单的判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        val name = scanner.next()
        val breathRate = scanner.nextInt()
        val pulse = scanner.nextInt()
        if (breathRate !in 15..20 || pulse !in 50..70) {
            println(name)
        }
    }
}
