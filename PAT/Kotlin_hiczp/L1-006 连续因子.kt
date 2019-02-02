

import java.util.*
import kotlin.math.sqrt

/**
 * L1-006 连续因子 （20 分）
 * 一个正整数 N 的因子中可能存在若干连续的数字。
 * 例如 630 可以分解为 3×5×6×7，其中 5、6、7 就是 3 个连续的数字。
 * 给定任一正整数 N，要求编写程序求出最长连续因子的个数，并输出最小的连续因子序列。
 *
 * 这个问题实际上是一个数学问题, 具体的数学原理此处不做讨论.
 * 首先我们从题目上可以得知, 题目想要的因式分解的形式并非是完全分解(例如 3*5*6*7 中, 6 还可以继续分解)
 * 换而言之, 这个题目不需要我们将 n 完全因式分解.
 * 题目想要的因式分解的完美情况是这样的一个东西 2*3*4*5*6*7*8*9*10*11*12 (同时这种情况是 n 最小的
 * 我们会发现 12!=479001600, 13!=6227020800, 而 Integer.MAX_VALUE=0x7fffffff=2147483647
 * 简单地说, 在 n 可能的范围内, 我们得到的最长可能的连续因子序列, 只有 12 那么长.
 * 既然只有 12, 那么也就意味着我们可以进行穷举(内层循环最多 12 次).
 * 穷举的思路是这样的:
 * 首先我们得到当前 n 对应的最大可能的因子的值为 sqrt(n)+1
 * 那么因子的区间为 [2, sqrt(n)+1]
 * 那么我们的问题就变成了, 找出这个区间中连续的一段(最大 12 个偏移量)是 n 的因子(复数).
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //读取输入
    val n = Scanner(System.`in`).nextInt()

    //计算最大可能的因子, 因子范围即为 2..maxFactor
    val maxFactor = (sqrt(n.toDouble()) + 1).toInt()

    //最长连续因子序列的开始和结束
    //这里故意让 end 比 start 小是因为下面比较大小的时候不能用 >=
    //特殊情形例如 n 为 9
    var start = 2
    var end = 1
    //有一种特殊情况是这个数为素数
    var isPrimeNumber = true
    //外层循环遍历了所有可能的因子
    for (currentStart in 2..maxFactor) {
        var previousProduct = 1L    //注意, 测试点 6 的测试内容是一个非常大的数字, 将导致 Int 类型的累乘积溢出(Java 没有 unsigned int)
        //如果当前正在判断的这一序列除 n 可以被除尽, 那么说明是其因子(复数)
        for (currentEnd in currentStart..maxFactor) {
            //当前的 currentStart..currentEnd 的累乘积
            val currentProduct = previousProduct * currentEnd
            if (currentProduct > n) break
            if (n % currentProduct == 0L) {
                //如果 n 被除尽了, 那么它一定不是素数
                isPrimeNumber = false
                //如果当前序列比已记录的序列长, 则记下它
                //不能用 >= 否则如果前后两段连续序列一样长, 会导致后一段序列被记录
                if ((currentEnd - currentStart) > (end - start)) {
                    start = currentStart
                    end = currentEnd
                }
            }
            previousProduct = currentProduct    //通过这种方式, 就不需要每次全部重新计算
        }
    }

    if (isPrimeNumber) {    //处理 n 为素数的情况
        println(1)
        println(n)
    } else {
        println(end - start + 1)
        println((start..end).joinToString(separator = "*"))
    }
}
