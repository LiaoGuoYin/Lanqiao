package com.hiczp.pat.gplt

import java.util.*

/**
 * L1-033 出生年 （15 分）
 * 以上是新浪微博中一奇葩贴：“我出生于1988年，直到25岁才遇到4个数字都不相同的年份。”也就是说，直到2013年才达到“4个数字都不相同”的要求。
 * 本题请你根据要求，自动填充“我出生于y年，直到x岁才遇到n个数字都不相同的年份”这句话。
 *
 * 简单的穷举问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    //输入
    val y = scanner.nextInt()
    val n = scanner.nextInt()

    //穷举
    run {
        //y 的范围为 [1, 3000] 意味着 y 可能就是 3000. 而一千年一定出现 4 个数字都不同的年份, 所以循环到 4000
        for (currentYear in y..4000) {
            //求当前年份中不同数字的个数
            val differentNumber = currentYear.toString()
                .padStart(4, '0')
                .toCharArray()
                .distinct()
                .count()
            if (differentNumber == n) {
                return@run currentYear
            }
        }
        null
    }?.let { year ->
        println("${year - y} ${year.toString().padStart(4, '0')}")
    }
}
