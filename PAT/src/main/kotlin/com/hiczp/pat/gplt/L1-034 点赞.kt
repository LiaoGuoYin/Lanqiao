package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * L1-034 点赞 （20 分）
 * 微博上有个“点赞”功能，你可以为你喜欢的博文点个赞表示支持。每篇博文都有一些刻画其特性的标签，而你点赞的博文的类型，也间接刻画了你的特性。
 * 本题就要求你写个程序，通过统计一个人点赞的纪录，分析这个人的特性。
 *
 * 简单的统计问题. 但是时间限制只有 200ms.
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val count = IntArray(1001)
    //输入
    repeat(bufferedReader.readLine().toInt()) {
        //为了加快速度, 这里指定 StringTokenizer 只匹配空格
        val stringTokenizer = StringTokenizer(bufferedReader.readLine(), " ")
        repeat(stringTokenizer.nextToken().toInt()) {
            val f = stringTokenizer.nextToken().toInt()
            count[f]++
        }
    }

    //找出数量最多的编号
    var maxNo = 0
    var maxCount = 0
    count.forEachIndexed { index, it ->
        //如果有并列, 输出编号大的
        if (it >= maxCount) {
            maxNo = index
            maxCount = it
        }
    }

    //输出
    println("$maxNo $maxCount")
}
