package com.hiczp.pat.gplt

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * L1-002 打印沙漏 （20 分）
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 *
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 类似这样的题, 实际上是找规律问题.
 * 简单的规律可以无脑使用数学归纳法.
 * 层数   点数
 *   1  1
 *   3  7
 *   5  17
 *   7  31
 *   n  1+(1+2)*2+(1+2+2)*2+(1+2+2+2)*2+...+(n-2)*2
 * 设层数到点数的函数为 floor(n), 那么有
 * floor(n)=1+(1+2*1 + 1+2*2 + 1+2*3 +...+ n-2)*2   //等差数列 d=2, a1=3
 *         =2((n+1)/2)^2-1
 *         =(n+1)^2/2-1
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //写程序的时候, 什么都不要想, 先把变量和输入部分写好. 之后的内容写好了再想.
    //关于 Scanner(System.in), 由于此 Scanner 使用了 System.in 这个流(这是 jvm 托管的). 而关闭 Scanner 时会关闭其中的流.
    //绝大多数继承了 Closeable 接口的类都会调用其中的流的 close() 方法, 所以会链式关闭一直到底.
    //这会导致整个程序的 System.in 被关闭. 所以 Scanner 不能使用 .close() 方法. 如果必须要保持其行为和通常的文件流或者网络流一致(用于工程型代码, 通常 OJ 题目不会有这种情形).
    //需要使用 CloseShieldInputStream, 这是一个本身没有作用的 InputStream, 唯一功能是自身被关闭时不关闭其中的流.
    //(这个类在 Apache Commons, 一种用于补充标准库的工具库, 类似 cpp 的 boost, 主要提供了大量简化文件, 网络, 数据的操作的 API)
    //(同样强大的第三方库还有 Google Guava, 提供了大量算法和设计模式的实现类)
    //(OJ 没有构建系统, 很难使用第三方库, 所以仅做了解)
    //关于 System.console, 它仅指向启动该程序的系统控制台. 但是在很多情况下, 这个控制台是不存在的
    //例如在 IDE 中, 实际上 IDE 是使用 Process.run 来启动程序的, 所以 System.console.reader 会返回 null, 即控制台根本不存在.
    //通常 OJ 也是那么启动程序的, 所以不要使用 System.console 来获取输入.
    val (n, symbol) = with(Scanner(System.`in`)) {
        nextInt() to next()
    }

    //现在我们得到了符号的数量, 我们想要知道那么多个符号能够组成至少多少层塔
    //之前的公式的逆运算
    //计算层的数量的值
    val floor = (sqrt((n + 1) * 2.0) - 1).toInt().let {
        if (it % 2 == 0) it - 1 else it //处理计算得到的层数为偶数的情况(其实只有输入的 n 为 6 时才会发生)
    }

    //现在我们得到了层的数量, 我们开始准备输出
    //我们观察到, 第一层(从上到下)的宽度等于层的总数. 第二层的宽度为 第一层的宽度-2, 一直降到 1, 然后反转.
    for (width in floor downTo 1 step 2) {
        println(symbol.toFilledString(width, floor))
    }
    //如果层数不为 1, 那么就有下半部分
    if (floor != 1) {
        for (width in 3..floor step 2) {
            println(symbol.toFilledString(width, floor))
        }
    }
    println(n - ((floor + 1.0).pow(2) / 2 - 1).toInt())
}

private fun String.toFilledString(length: Int, totalLength: Int) =
    "${" ".repeat((totalLength - length) / 2)}${this.repeat(length)}"
