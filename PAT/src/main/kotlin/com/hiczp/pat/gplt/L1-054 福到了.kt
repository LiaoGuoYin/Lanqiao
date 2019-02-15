package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * L1-054 福到了 （15 分）
 * “福”字倒着贴，寓意“福到”。不论到底算不算民俗，本题且请你编写程序，把各种汉字倒过来输出。
 * 这里要处理的每个汉字是由一个 N × N 的网格组成的，网格中的元素或者为字符 @ 或者为空格。而倒过来的汉字所用的字符由裁判指定。
 *
 * 简单的倒序输出
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //输入
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val (char, n) = StringTokenizer(bufferedReader.readLine(), " ").let {
        it.nextToken()[0] to it.nextToken().toInt()
    }
    val input = Array<String>(n) {
        bufferedReader.readLine()
    }

    //判断是否倒过去是一样的
    var same = true
    //如果是偶数则判断到 n/2-1 如果是奇数则判断到 n/2
    for (i in 0..if (n % 2 == 0) n / 2 - 1 else n / 2) {
        if (input[i] != input[n - 1 - i].reversed()) {
            same = false
            break
        }
    }
    if (same) {
        val message = "bu yong dao le"
        println(message)
    }

    //输出
    for (i in n - 1 downTo 0) {
        for (j in n - 1 downTo 0) {
            val value = input[i][j]
            print(if (value != ' ') char else value)
        }
        println()
    }
}
