

/**
 * L1-017 到底有多二 （15 分）
 * 一个整数“犯二的程度”定义为该数字中包含2的个数与其位数的比值。
 * 如果这个数是负数，则程度增加0.5倍；
 * 如果还是个偶数，则再增加1倍。例如数字-13142223336是个11位数，其中有3个2，并且是负数，也是偶数，则它的犯二程度计算为：3/11×1.5×2×100%，约为81.82%。
 * 本题就请你计算一个给定整数到底有多二。
 *
 * 这是一个简单的过程式计算
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val n = readLine()!!

    val countOf2 = n.count { it == '2' }    //2 的个数
    val isNegative = n.startsWith('-')  //是否负数
    val countOfDigit = if (isNegative) n.length - 1 else n.length   //位数
    val isEven = n.toBigDecimal() % 2.toBigDecimal() == 0.toBigDecimal()    //是否是偶数

    var result = countOf2.toDouble() / countOfDigit
    if (isNegative) result *= 1.5
    if (isEven) result *= 2
    println("%.2f%%".format(result * 100))
}
