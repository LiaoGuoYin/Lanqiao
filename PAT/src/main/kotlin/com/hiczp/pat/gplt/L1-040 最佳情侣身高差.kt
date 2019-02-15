package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-040 最佳情侣身高差 （10 分）
 * 专家通过多组情侣研究数据发现，最佳的情侣身高差遵循着一个公式：（女方的身高）×1.09 =（男方的身高）。
 * 如果符合，你俩的身高差不管是牵手、拥抱、接吻，都是最和谐的差度。
 * 下面就请你写个程序，为任意一位用户计算他/她的情侣的最佳身高。
 *
 * 简单的判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    repeat(scanner.nextInt()) {
        val gender = scanner.next()
        val height = scanner.nextDouble()
        if (gender == "F") {
            height * 1.09
        } else {
            height / 1.09
        }.run {
            println("%.2f".format(this))
        }
    }
}
