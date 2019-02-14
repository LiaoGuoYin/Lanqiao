package com.hiczp.pat.gplt

/**
 * L1-046 整除光棍 （20 分）
 * 这里所谓的“光棍”，并不是指单身汪啦~ 说的是全部由1组成的数字，比如1、11、111、1111等。
 * 传说任何一个光棍都能被一个不以5结尾的奇数整除。比如，111111就可以被13整除。
 * 现在，你的程序要读入一个整数x，这个整数一定是奇数并且不以5结尾。
 * 然后，经过计算，输出两个数字：第一个数字s，表示x乘以s是一个光棍，第二个数字n是这个光棍的位数。
 * 这样的解当然不是唯一的,题目要求你输出最小的解。
 *
 * 简单的大数计算
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val input = readLine()!!
    //所求的光棍数一定与 x 相等或比 x 位数更多
    val lengthOfX = input.length
    val x = input.toBigInteger()

    var number = "1".repeat(lengthOfX).toBigInteger()
    while (number % x != 0.toBigInteger()) {
        //通过 乘以十再加一 来生成下一个光棍数, 避免每次重新生成
        number = number * 10.toBigInteger() + 1.toBigInteger()
    }
    println("${number / x} ${number.toString().length}")
}
