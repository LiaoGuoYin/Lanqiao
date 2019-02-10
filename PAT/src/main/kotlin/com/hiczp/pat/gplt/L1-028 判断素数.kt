package com.hiczp.pat.gplt

import java.util.*
import kotlin.math.sqrt

/**
 * L1-028 判断素数 （10 分）
 * 本题的目标很简单，就是判断一个给定的正整数是否素数。
 *
 * 素数一定为 6n+1 或者 6n-1 (这叫什么定理我也忘了)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        val input = scanner.nextInt()
        println(if (input.isPrimeNumber()) "Yes" else "No")
    }
}

private fun Int.isPrimeNumber() =
    when {
        this <= 3 -> this > 1
        this % 6 != 1 && this % 6 != 5 -> false
        else -> run {
            for (i in 5..sqrt(this.toDouble()).toInt() step 6) {
                if (this % i == 0 || this % (i + 2) == 0) {
                    return@run false
                }
            }
            true
        }
    }
