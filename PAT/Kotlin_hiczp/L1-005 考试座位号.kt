

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * L1-005 考试座位号 （15 分）
 * 每个 PAT 考生在参加考试时都会被分配两个座位号，一个是试机座位，一个是考试座位。
 * 正常情况下，考生在入场时先得到试机座位号码，入座进入试机状态后，系统会显示该考生的考试座位号码，考试时考生需要换到考试座位就座。
 * 但有些考生迟到了，试机已经结束，他们只能拿着领到的试机座位号码求助于你，从后台查出他们的考试座位号码。
 *
 * 这是一个简单的数据存取问题, 但是数据量有 1000. Java 的控制台输入输出很慢, 所以使用了一些奇技淫巧
 * (结果还是超时, 没我了
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    //在没有 buffer 的情况下, 数据读取的速度似乎不够快, 这里使用 BufferedReader
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    //由于没有数据是重复的, 因此使用一个数组来保存数据
    //数组下标为试机座位号
    val students = kotlin.arrayOfNulls<String>(1001) //这个数组的内存申请似乎就要很长时间
    repeat(bufferedReader.readLineAsInt()) {
        //用 StringTokenizer 手动处理分割问题以加快处理速度
        val stringTokenizer = StringTokenizer(bufferedReader.readLine())
        val id = stringTokenizer.nextToken()
        val testSeatNumber = stringTokenizer.nextToken().toInt()
        val examSeatNumber = stringTokenizer.nextToken()
        students[testSeatNumber] = "$id $examSeatNumber"     //直接合并两个列从而避免使用二维数组, 加快寻址
    }

    val m = bufferedReader.readLineAsInt()

    val stringTokenizer = StringTokenizer(bufferedReader.readLine())
    repeat(m) {
        println(students[stringTokenizer.nextToken().toInt()])
    }
}

//强制 inline 以减少函数退栈次数
//inline 功能详见 https://en.wikipedia.org/wiki/Inline_function
//类似的编译器处理还有 tailrec, 尾递归优化
@Suppress("NOTHING_TO_INLINE")
private inline fun BufferedReader.readLineAsInt() = readLine().toInt()
