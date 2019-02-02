

import kotlin.math.pow

/**
 * L1-012 计算指数 （5 分）
 * 真的没骗你，这道才是简单题 —— 对任意给定的不超过 10 的正整数 n，要求你输出 2^n。不难吧？
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    readLine()!!.toInt()
        .let {
            it to 2.toDouble().pow(it).toInt()
        }.let { (exponent, result) ->
            println("2^$exponent = $result")
        }
}
