package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * L1-023 输出GPLT （20 分）
 * 给定一个长度不超过10000的、仅由英文字母构成的字符串。
 * 请将字符重新调整顺序，按GPLTGPLT....这样的顺序输出，并忽略其它字符。
 * 当然，四种字符（不区分大小写）的个数不一定是一样多的，若某种字符已经输出完，则余下的字符仍按GPLT的顺序打印，直到所有字符都被输出。
 *
 * 注意, 这个题目的时间限制只有 150ms. 所以 Java 应该是过不了的
 */
@Suppress("UnusedMainParameter", "SpellCheckingInspection")
fun main(args: Array<String>) {
    //常量
    val gplt = "GPLT"

    //读取输入
    val input = BufferedReader(InputStreamReader(System.`in`)).readText()

    //统计输入中的 G P L T 四个字母的个数
    //保存数量的数组
    val count = IntArray(4)
    //mapping
    //硬编码索引以提升速度
    val map = mapOf(
        'g' to 0, 'G' to 0,
        'p' to 1, 'P' to 1,
        'l' to 2, 'L' to 2,
        't' to 3, 'T' to 3
    )
    input.forEach {
        val index = map[it]
        if (index != null) {
            count[index]++
        }
    }

    //输出
    while (true) {
        //找出当前轮中数量最少的字母. 这个数量意味着接下来多少次输出相同的内容
        var min = 0
        count.forEach {
            if (it != 0 && (min == 0 || it < min)) {
                min = it
            }
        }
        //如果最小值为 0, 则说明全部都是 0
        if (min == 0) break

        //本轮输出的内容
        val stringBuilder = StringBuilder()
        //数组中所有值减去 min
        count.forEachIndexed { i, it ->
            if (it != 0) {
                count[i] -= min
                //如果当前位不为 0, 说明需要被输出
                stringBuilder.append(gplt[i])
            }
        }
        val string = stringBuilder.toString()

        //输出
        repeat(min) {
            print(string)
        }
    }
}
