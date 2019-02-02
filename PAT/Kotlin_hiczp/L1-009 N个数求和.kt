

import kotlin.math.abs

/**
 * L1-009 N个数求和 （20 分）
 * 本题的要求很简单，就是求N个数字的和。
 * 麻烦的是，这些数字是以有理数分子/分母的形式给出的，你输出的和也必须是有理数的形式。
 *
 * 这是一个求最小公倍数和最大公约数问题.
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    readLine()  //不需要 n

    //将输入装填到 List<Fraction>
    val fractions = readLine()!!.split(" ")
        .map { Fraction(it) }

    //所有分数加到第一个分数上, 然后输出
    fractions.reduce { accumulate, element ->
        accumulate.add(element)
    }.let {
        println(it)
    }
}

//greatest common divisor
//尾递归优化
private tailrec fun gcd(a: Long, b: Long): Long =
    if (a < b) gcd(b, a) else if (b == 0L) a else gcd(b, a % b)

//least Common Multiple
private fun lcm(a: Long, b: Long) = (a * b) / gcd(a, b)

//分数
private data class Fraction(
    //分子
    var numerator: Long,
    //分母
    var denominator: Long
) {
    constructor(string: String) : this(
        string.substringBefore("/").toLong(),
        string.substringAfter("/").toLong()
    )

    fun add(fraction: Fraction): Fraction {
        val (otherNumerator, otherDenominator) = fraction
        //得到两个分数的分母的最小公倍数
        val lcm = lcm(denominator, otherDenominator)
        //计算放大倍数
        val scale = lcm / denominator
        //分母直接等于最小公倍数
        denominator = lcm
        //另一个分数的放大倍数
        val otherScale = lcm / otherDenominator
        //分子放大后再相加
        numerator = numerator * scale + otherNumerator * otherScale
        return this
    }

    override fun toString(): String {
        //是否是负数
        val isNegative = numerator < 0
        //保持分子为正数, 否则将导致无限递归
        val numeratorAbs = abs(numerator)

        //简化分子分母所需的倍数
        val scale = gcd(numeratorAbs, denominator)
        //化简后的分子分母
        val simplifiedNumerator = numeratorAbs / scale
        val simplifiedDenominator = denominator / scale
        //将分子化到整数部分
        val intValue = simplifiedNumerator / simplifiedDenominator
        val transformedNumerator = simplifiedNumerator - intValue * simplifiedDenominator

        val hasIntPart = intValue != 0L
        val hasFractionPart = transformedNumerator != 0L

        //第五个测试点, 整数和分数都没有时输出 0
        if (!hasIntPart && !hasFractionPart) {
            return "0"
        }

        //最后的输出为 intValue transformedNumerator/simplifiedDenominator
        return StringBuilder().apply {
            if (isNegative) append('-')
            if (hasIntPart) append(intValue)
            if (hasIntPart && hasFractionPart) append(' ')
            if (hasFractionPart) {
                append(transformedNumerator)
                    .append("/")
                    .append(simplifiedDenominator)
            }
        }.toString()
    }
}
