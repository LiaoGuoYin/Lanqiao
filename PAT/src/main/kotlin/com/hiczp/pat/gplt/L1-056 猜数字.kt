package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * L1-056 猜数字 （20 分）
 * 一群人坐在一起，每人猜一个 100 以内的数，谁的数字最接近大家平均数的一半就赢。本题就要求你找出其中的赢家。
 *
 * 使用 TreeMap 来快速定位
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    //保存已读取的用户 所猜的数字-名字
    val treeMap = TreeMap<Int, String>()
    //读取 n
    val n = bufferedReader.readLine().toInt()
    //读取输入的时候直接计算数字总和以加快速度
    var total = 0
    repeat(n) {
        val stringTokenizer = StringTokenizer(bufferedReader.readLine())
        val name = stringTokenizer.nextToken()
        val number = stringTokenizer.nextToken().toInt()
        total += number
        //题目保证赢家只有一个, 因此如果一个数字被多人猜了, 那么这个数字一定不能获胜. 所以覆盖掉也没有影响
        treeMap[number] = name
    }

    //计算平均数的一半
    val halfAverage = total.toDouble() / n / 2
    //平均数的一半化成整数, 这个数字一定比原来的数字要小
    val target = halfAverage.toInt()
    //小于等于目标的最接近的项
    val floor = treeMap.floorEntry(target)
    //大于等于目标最接近的项
    val ceiling = treeMap.ceilingEntry(target)

    //判断谁最接近
    when {
        //floor 或者 ceiling 可能有一个不存在
        floor == null -> ceiling
        ceiling == null -> floor
        halfAverage - floor.key < ceiling.key - halfAverage -> floor
        else -> ceiling
    }.run {
        println("$target $value")
    }
}
