package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-055 谁是赢家 （10 分）
 * 某电视台的娱乐节目有个表演评审环节，每次安排两位艺人表演，他们的胜负由观众投票和 3 名评委投票两部分共同决定。
 * 规则为：如果一位艺人的观众票数高，且得到至少 1 名评委的认可，该艺人就胜出；或艺人的观众票数低，但得到全部评委的认可，也可以胜出。
 * 节目保证投票的观众人数为奇数，所以不存在平票的情况。本题就请你用程序判断谁是赢家。
 *
 * 简单的判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    //观众投票
    val pa = scanner.nextInt()
    val pb = scanner.nextInt()
    //评委投票
    var va = 0
    var vb = 0
    repeat(3) {
        when (scanner.nextInt()) {
            0 -> va++
            else -> vb++
        }
    }

    //判断胜负
    if (pa > pb && va >= 1 || pa < pb && va == 3) {
        Triple('a', pa, va)
    } else {
        Triple('b', pb, vb)
    }.let { (winner, p1, p2) ->
        println("The winner is $winner: $p1 + $p2")
    }
}
