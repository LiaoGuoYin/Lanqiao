package com.hiczp.pat.gplt

/**
 * L1-027 出租 （20 分）
 * 下面是新浪微博上曾经很火的一张图：
 * 一时间网上一片求救声，急问这个怎么破。
 * 其实这段代码很简单，index数组就是arr数组的下标，index[0]=2 对应 arr[2]=1，index[1]=0 对应 arr[0]=8，index[2]=3 对应 arr[3]=0，以此类推…… 很容易得到电话号码是18013820100。
 * 本题要求你编写一个程序，为任何一个电话号码生成这段代码 —— 事实上，只要生成最前面两行就可以了，后面内容是不变的。
 *
 * 这个问题没啥好说的
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val phone = readLine()!!.map {
        Character.getNumericValue(it)
    }

    val array = phone.distinct().sortedDescending()
    val index = IntArray(phone.size) {
        array.indexOf(phone[it])
    }

    println(
        """
            int[] arr = new int[]{${array.joinToString(",")}};
            int[] index = new int[]{${index.joinToString(",")}};
        """.trimIndent()
    )
}
