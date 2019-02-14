package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * L1-049 天梯赛座位分配 （20 分）
 * 天梯赛每年有大量参赛队员，要保证同一所学校的所有队员都不能相邻，分配座位就成为一件比较麻烦的事情。
 * 为此我们制定如下策略：假设某赛场有 N 所学校参赛，第 i 所学校有 M[\i] 支队伍，每队 10 位参赛选手。
 * 令每校选手排成一列纵队，第 i+1 队的选手排在第 i 队选手之后。
 * 从第 1 所学校开始，各校的第 1 位队员顺次入座，然后是各校的第 2 位队员…… 以此类推。
 * 如果最后只剩下 1 所学校的队伍还没有分配座位，则需要安排他们的队员隔位就坐。
 * 本题就要求你编写程序，自动为各校生成队员的座位号，从 1 开始编号。
 *
 * 在座位的分配过程中, 一共有三种情况
 * 所有学校都有人剩余 -> 按照顺序继续排
 * 有至少一个学校的人已经被排完了 -> 下一轮排座位跳过这个学校
 * 只剩下一个学校的人还没有排完 -> 排下这个学校的人后, 空一个桌子再继续排这个学校的人
 * (隔位就坐的意思是存在空桌子)
 *
 * 这道题的思想是把座位序号填到人身上而不是把人摆到座位上
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //输入
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val n = bufferedReader.readLine().toInt()
    //每所学校的队伍数量
    val stringTokenizer = StringTokenizer(bufferedReader.readLine())
    val teamCounts = IntArray(n) {
        stringTokenizer.nextToken().toInt()
    }

    //由于所有学校的所有队伍的人数都是 10 人, 因此不存在未被排空的学校在当前轮中的队伍序号不一样的情况
    //学校可用性, 标记为 false 意味着这个学校已经排完
    val schoolAvailableTable = BooleanArray(n) { true }
    //当前正在排座位的学校的序号(游标)
    var currentSchool = 0
    //当前正在排座位的队伍序号(游标)
    var currentTeam = 0
    //当前正在排座位的人在队伍中的序号(游标)
    var currentMember = 0
    //当前正在被排的座位的编号
    var seatNumber = 1
    //已就坐的人员与座位号的对照表 学校编号-队伍编号-队员在队伍里的编号
    val seatTable = Array(n) { Array(teamCounts[it]) { IntArray(10) } }

    //开始排座位
    while (true) {
        seatTable[currentSchool][currentTeam][currentMember] = seatNumber

        //寻找下一个学校
        var nextSchool = -1
        for (i in (currentSchool + 1) until n) {
            if (schoolAvailableTable[i]) {
                nextSchool = i
                break
            }
        }
        if (nextSchool != -1) {
            currentSchool = nextSchool
        } else {    //如果没有下一个可用学校, 说明排到底了, 要回到第一个可用的学校重新开始
            //如果回到第一个, 首先会使得正在排位置的人在队伍中的序号增加
            currentMember++
            //如果达到 10, 那么正在排位置的队伍的序号会增加, 这可能导致某些学校被排完
            if (currentMember == 10) {
                currentMember = 0
                currentTeam++
                //检查哪些学校被排完了
                schoolAvailableTable.forEachIndexed { index, it ->
                    //这个学校没有被标记为排完并且这个学校的队伍数量没有超过接下来马上要排的队伍序号
                    if (it && teamCounts[index] == currentTeam) {
                        schoolAvailableTable[index] = false
                    }
                }
            }

            //从第一个开始找一个可用的学校
            nextSchool = schoolAvailableTable.indexOfFirst { it }

            //如果没有任何可用学校说明全部排完
            if (nextSchool == -1) break
            //如果下一个学校与当前的一样, 那么要空一格
            if (nextSchool == currentSchool) seatNumber++
            currentSchool = nextSchool
        }

        //座位号自增
        seatNumber++
    }

    //输出
    output(seatTable)
}

private fun output(seatTable: Array<Array<IntArray>>) =
    seatTable.forEachIndexed { schoolIndex, school ->
        println("#${schoolIndex + 1}")
        school.forEach { team ->
            team.forEachIndexed { index, seat ->
                print(seat)
                if (index != 9) print(' ')
            }
            println()
        }
    }
