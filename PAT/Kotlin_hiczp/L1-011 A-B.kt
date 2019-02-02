

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * L1-011 A-B （20 分）
 * 本题要求你计算A−B。
 * 不过麻烦的是，A和B都是字符串 —— 即从字符串A中把字符串B所包含的字符全删掉，剩下的字符组成的就是字符串A−B。
 *
 * 这个问题时间限制只有 150ms, 就是来难为我 JVM 的
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //得到 a 和 b
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val a = bufferedReader.readLine()
    val b = bufferedReader.readLine()

    //为了避免过多的遍历 b, 我们首先要知道 b 包含了哪几个字符
    //如果 b 中包含了某个字符, 那么对应的数组中的这一位就会被标记为 true
    val dictionary = BooleanArray(256)
    b.forEach {
        dictionary[it.toInt()] = true
    }

    //处理 a 并输出
    StringBuilder().apply {
        a.forEach {
            if (!dictionary[it.toInt()]) append(it)
        }
    }.let {
        println(it)
    }
}
