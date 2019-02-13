package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-041 寻找250 （10 分）
 * 对方不想和你说话，并向你扔了一串数…… 而你必须从这一串数字中找到“250”这个高大上的感人数字。
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var index = 0
    while (scanner.hasNext()) {
        index++
        if (scanner.next().toInt() == 250) {
            println(index)
            break
        }
    }
}
