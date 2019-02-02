

import kotlin.math.roundToInt

/**
 * L1-015 跟奥巴马一起画方块 （15 分）
 * 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。
 * 2014年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。
 * 现在你也跟他一起画吧！
 *
 * Java 四舍五入工具方法 Math.round(double a)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //输入
    val (n, c) = readLine()!!.split(' ')

    //计算长宽
    val width = n.toInt()
    val height = (n.toDouble() / 2).roundToInt()

    //输出
    val line = c.repeat(width)
    repeat(height) {
        println(line)
    }
}
