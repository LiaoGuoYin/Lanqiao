package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet

/**
 * L1-020 帅到没朋友 （20 分）
 * 当芸芸众生忙着在朋友圈中发照片的时候，总有一些人因为太帅而没有朋友。本题就要求你找出那些帅到没有朋友的人。
 *
 * 这是一个数据查询问题. 读取输入的时候先记下有朋友的人.
 * 这道题的限时只有 200ms. 第四个测试点 cpp 耗时 120ms, 所以 java 是不可能通过的.
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    //记录有朋友的人的表
    val personHasFriend = HashSet<String>()
    //读取数据
    repeat(bufferedReader.readLine().toInt()) {
        val stringTokenizer = StringTokenizer(bufferedReader.readLine())
        val k = stringTokenizer.nextToken().toInt()
        if (k == 1) return@repeat //如果此朋友圈只有一人则不做操作
        //朋友圈有两人以上则此朋友圈中的所有人都有朋友
        repeat(k) {
            personHasFriend.add(stringTokenizer.nextToken())
        }
    }

    //读取需要查询的人
    val m = bufferedReader.readLine().toInt()
    val stringTokenizer = StringTokenizer(bufferedReader.readLine())

    //是否是第一个输出内容
    var isFirst = true
    //已查询过的人的表
    val searched = HashSet<String>()
    repeat(m) {
        //当前人
        val person = stringTokenizer.nextToken()

        //如果此人已被查询过则不做操作
        if (person in searched) {
            return@repeat
        } else {
            searched.add(person)
        }

        //判断此人有没有朋友
        if (person !in personHasFriend) {
            //如果不是第一个输出的内容, 则先输出一个空格
            if (isFirst) {
                isFirst = false
            } else {
                print(' ')
            }
            //直接输出, 不需要将没朋友的人存下来, 从而加快速度
            print(person)
        }
    }

    //如果之前的循环里没有任何输出, 那么 isFirst 将是 true
    if (isFirst) {
        println("No one is handsome")
    }
}
