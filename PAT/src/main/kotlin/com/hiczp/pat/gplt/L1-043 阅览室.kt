package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.roundToInt

/**
 * L1-043 阅览室 （20 分）
 * 天梯图书阅览室请你编写一个简单的图书借阅统计程序。
 * 当读者借书时，管理员输入书号并按下S键，程序开始计时；当读者还书时，管理员输入书号并按下E键，程序结束计时。
 * 书号为不超过1000的正整数。当管理员将0作为书号输入时，表示一天工作结束，你的程序应输出当天的读者借书次数和平均阅读时间。
 * 注意：由于线路偶尔会有故障，可能出现不完整的纪录，即只有S没有E，或者只有E没有S的纪录，系统应能自动忽略这种无效纪录。
 * 另外，题目保证书号是书的唯一标识，同一本书在任何时间区间内只可能被一位读者借阅。
 *
 * 简单的统计问题.
 * 这道题的 "忽略无效数据" 的意思是, "借出后没有还的记录" 以及 "有还但是没有借的记录" 这两种情况不算在借出次数和阅读时长中.
 * 根据题目给出的例子, 本题不考虑第一天借了之后第二天还的情况. 每天都是独立计算的.
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    //总天数
    val days = bufferedReader.readLine().toInt()
    //当前已解析的天
    var currentDay = 0

    //当天已借出的书 编号-借出时间
    val lentBook = HashMap<Int, String>()
    //当天读者借书次数
    var lendCount = 0
    //当天总阅读时长
    var readingTime = 0

    //输出借书次数和平均阅读时间
    val printResult = {
        val averageReadingTime = if (lendCount == 0) {
            0.0
        } else {
            readingTime.toDouble() / lendCount
        }
        //注意这道题最后的输出要四舍五入
        println("$lendCount ${averageReadingTime.roundToInt()}")
    }

    while (currentDay < days) {
        //读取当前这一条记录
        val stringTokenizer = StringTokenizer(bufferedReader.readLine(), " ")
        val bookNumber = stringTokenizer.nextToken().toInt()
        val operation = stringTokenizer.nextToken()
        val hourAndMinute = stringTokenizer.nextToken()

        //如果书号为 0 说明这一天的解析结束了
        if (bookNumber == 0) {
            printResult()
            //重置数据
            lendCount = 0
            readingTime = 0
            lentBook.clear()
            //当前天数加一
            currentDay++
            continue
        }

        if (operation == "S") {   //借书
            //如果这本书已被借出, 则覆盖掉他的借出时间
            lentBook[bookNumber] = hourAndMinute
        } else {    //还书
            val lentTime = lentBook[bookNumber]
            //如果这本书存在借出记录, 则进行处理
            if (lentTime != null) {
                lendCount++
                readingTime += timeDifference(lentTime, hourAndMinute)
                lentBook.remove(bookNumber)
            }
        }
    }
}

private fun splitTime(time: String) =
    time.split(':').map { it.toInt() }

//计算时间差, 返回值为分钟
private fun timeDifference(startTime: String, endTime: String): Int {
    val (startHour, startMinute) = splitTime(startTime)
    val (endHour, endMinute) = splitTime(endTime)
    return (endHour * 60 + endMinute) - (startHour * 60 + startMinute)
}
