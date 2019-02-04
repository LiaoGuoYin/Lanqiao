package com.hiczp.pat.gplt

/**
 * L1-004 计算摄氏温度 （5 分）
 * 给定一个华氏温度F，本题要求编写程序，计算对应的摄氏温度C。计算公式：C=5×(F−32)/9。题目保证输入与输出均在整型范围内。
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val fahrenheit = readLine()!!.toInt()
    //这个问题的输入保证了全部的数据一定的整数. 但是实际操作中必须要注意任何地方都可能出现浮点数.
    //匿名浮点数常量可用以下方式来表示 1.0, 1.0f, 1.0F
    //(注意, . 号实际上表示 double, 1.0 在一些情况下可能不会被自动转换到 float 导致类型错误)
    //标准库中大多数数学运算也要求使用 double, 具体使用情形需要按照需求来选择类型.
    //关于浮点数精度问题可以参见著名的 0.1+0.2 问题 https://0.30000000000000004.com/
    //java 中使用 BigDecimal 来解决(通常 OJ 不会搞这种题目, 因为 BigDecimal 里面是一个数组, 计算起来非常慢)
    println("Celsius = ${5 * (fahrenheit - 32) / 9}")
}
