package com.hiczp.pat.gplt

import java.util.*
import kotlin.math.pow

/**
 * L1-050 倒数第N个字符串 （15 分）
 * 给定一个完全由小写英文字母组成的字符串等差递增序列，该序列中的每个字符串的长度固定为 L，从 L 个 a 开始，以 1 为步长递增。例如当 L 为 3 时，序列为 { aaa, aab, aac, ..., aaz, aba, abb, ..., abz, ..., zzz }。
 * 这个序列的倒数第27个字符串就是 zyz。对于任意给定的 L，本题要求你给出对应序列倒数第 N 个字符串。
 *
 * 实际上这是一个 26 进制数
 * 题目求的是 26^L-N
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val l = scanner.nextInt()
    val n = scanner.nextInt()

    val result = StringBuilder().apply {
        var remain = 26.toDouble().pow(l).toInt() - n
        do {
            append('a' + remain % 26)
            remain /= 26
        } while (remain != 0)
    }.reversed().padStart(l, 'a')
    println(result)
}
