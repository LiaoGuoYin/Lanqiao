

/**
 * L1-016 查验身份证 （15 分）
 * 一个合法的身份证号码由17位地区、日期编号和顺序编号加1位校验码组成。校验码的计算规则如下：
 * 首先对前17位数字加权求和,权重分配为：{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2}；
 * 然后将计算的和对11取模得到值Z；
 * 最后按照以下关系对应Z值与校验码M的值：
 * Z：0 1 2 3 4 5 6 7 8 9 10
 * M：1 0 X 9 8 7 6 5 4 3 2
 * 现在给定一些身份证号码,请你验证校验码的有效性,并输出有问题的号码。
 *
 * 这是一个简单的数据验证问题, 以下是不使用正则表达式的解法
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    var allPass = true
    repeat(readLine()!!.toInt()) {
        //读取身份证号
        val identityCard = readLine()!!
        val (numberPart, checkDigit) = identityCard.chunked(17)
        //首先确定前面都是数字
        if (numberPart.toLongOrNull() == null || numberPart.calculateCheckDigit() != checkDigit[0]) {
            allPass = false
            println(identityCard)
        }
    }

    if (allPass) {
        println("All passed")
    }
}

private val weights = arrayOf(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2)
private val checkDigitTable = arrayOf('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2')

private fun String.calculateCheckDigit() =
    toCharArray().map { Character.getNumericValue(it) }
        .foldIndexed(0) { index, sum, element ->
            sum + element * weights[index]
        }
        .let {
            checkDigitTable[it % 11]
        }
