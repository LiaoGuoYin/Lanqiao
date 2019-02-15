package com.hiczp.pat.gplt

/**
 * L1-035 情人节 （15 分）
 * 以上是朋友圈中一奇葩贴：“2月14情人节了，我决定造福大家。
 * 第2个赞和第14个赞的，我介绍你俩认识…………咱三吃饭…你俩请…”。
 * 现给出此贴下点赞的朋友名单，请你找出那两位要请客的倒霉蛋。
 *
 * 简单的输入问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //序号
    var index = 0
    //A 和 B
    var a: String? = null
    var b: String? = null
    //输入
    while (true) {
        val input = readLine()!!
        if (input == ".") break

        index++

        when (index) {
            2 -> a = input
            14 -> b = input
        }
    }
    //输出
    @Suppress("SpellCheckingInspection")
    when {
        a != null && b != null -> "$a and $b are inviting you to dinner..."
        a != null && b == null -> "$a is the only one for you..."
        else -> "Momo... No one is for you ..."
    }.run(::println)
}
