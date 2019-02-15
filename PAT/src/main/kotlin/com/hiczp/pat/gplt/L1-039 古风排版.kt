package com.hiczp.pat.gplt

import kotlin.math.ceil

/**
 * L1-039 古风排版 （20 分）
 * 中国的古人写文字，是从右向左竖向排版的。本题就请你编写程序，把一段文字按古风排版。
 *
 * 这是一个求偏移量问题
 *
 * 8+0 4+0 0+0
 * 8+1 4+1 0+1
 * 8+2 4+2 0+2
 * 8+3 4+3 0+3
 *
 * 序号从 1 开始
 * 每一个位置的偏移量为 (总列数 - 当前列的序号) * n + (当前行的序号 - 1)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //输入
    val n = readLine()!!.toInt()
    val string = readLine()!!

    //总共有多少列
    val column = ceil(string.length.toDouble() / n).toInt()

    //每个位置的总偏移量可以表示为 列产生的偏移+行产生的偏移
    //列产生的初始偏移
    val originColumnOffset = (column - 1) * n
    //行产生的初始偏移
    val originRowOffset = 0

    //输出
    for (currentRowOffset in originRowOffset until n) {
        for (currentColumnOffset in originColumnOffset downTo 0 step n) {
            val totalOffset = currentColumnOffset + currentRowOffset
            if (totalOffset >= string.length) {
                print(' ')
            } else {
                print(string[totalOffset])
            }
        }
        println()
    }
}
