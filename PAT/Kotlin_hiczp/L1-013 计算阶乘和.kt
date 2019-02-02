

/**
 * L1-013 计算阶乘和 （10 分）
 * 对于给定的正整数N，需要你计算 S=1!+2!+3!+...+N!。
 *
 * 这道题目证明 pat 服务器的 cpu 非常弱
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    (1..readLine()!!.toInt())
        .map {
            (1..it).reduce { acc, element ->
                acc * element
            }
        }
        .sum()
        .let {
            println(it)
        }
}
