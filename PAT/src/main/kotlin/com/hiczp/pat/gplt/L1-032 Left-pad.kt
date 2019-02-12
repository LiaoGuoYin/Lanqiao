package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-032 Left-pad （20 分）
 * 根据新浪微博上的消息，有一位开发者不满NPM（Node Package Manager）的做法，收回了自己的开源代码，其中包括一个叫left-pad的模块，就是这个模块把javascript里面的React/Babel干瘫痪了。
 * 这是个什么样的模块？就是在字符串前填充一些东西到一定的长度。
 * 例如用*去填充字符串GPLT，使之长度为10，调用left-pad的结果就应该是******GPLT。
 * Node社区曾经对left-pad紧急发布了一个替代，被严重吐槽。下面就请你来实现一下这个模块。
 *
 * 从这道题的示例二可以看出, 实际上题目的意思是: 输出 n 位的字符串, 如果原始字符串不够则用给定的字符来凑(如果 n 小于原始字符串长度则截断原始字符串, 从最右边开始计算)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //输入
    val stringTokenizer = StringTokenizer(readLine())
    val n = stringTokenizer.nextToken().toInt()
    val padChar = stringTokenizer.nextToken()[0]
    val string = readLine()!!

    //输出
    //所有的情况细分其实有三种
    when {
        //n 比原始字符串长度大
        n > string.length -> string.padStart(n, padChar)
        //n 等于原始字符串长度
        n == string.length -> string
        //n 小于原始字符串长度
        else -> string.takeLast(n)
    }.run(::println)
}
