

/**
 * L1-003 个位数统计 （15 分）
 * 给定一个 k 位整数，请编写程序统计每种不同的个位数字出现的次数。例如：给定 N=100311，则有 2 个 0，3 个 1，和 1 个 3。
 *
 * 思路是使用一个"表"
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //创造一个表
    val table = IntArray(10)
    //读取整一行
    readLine()!!.forEach {
        //对类型进行转换, char 和 string 的行为是不同的.
        //string 会被转为其语义上的数字.
        //而 char 会保持它本身的内存然后按 int 去读取它(与 c语言 一致). 注意, char 存储的不是 ASCII, 是 unicode.
        //java 使用 UTF16 来保存字符. 这就是为什么 "大家好".length==3 而不是 6 或者 9 或者 12
        //详见编码问题 https://www.ibm.com/developerworks/cn/java/unicode-programming-language/index.html
        table[Character.getNumericValue(it)]++
    }
    //输出
    table.forEachIndexed { index, it ->
        if (it != 0) println("$index:$it")
    }
}
