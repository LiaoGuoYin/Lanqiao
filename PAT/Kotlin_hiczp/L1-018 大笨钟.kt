

/**
 * L1-018 大笨钟 （10 分）
 * 微博上有个自称“大笨钟V”的家伙，每天敲钟催促码农们爱惜身体早点睡觉。
 * 不过由于笨钟自己作息也不是很规律，所以敲钟并不定时。
 * 一般敲钟的点数是根据敲钟时间而定的，如果正好在某个整点敲，那么“当”数就等于那个整点数；
 * 如果过了整点，就敲下一个整点数。另外，虽然一天有24小时，钟却是只在后半天敲1~12下。
 * 例如在23:00敲钟，就是“当当当当当当当当当当当”，而到了23:01就会是“当当当当当当当当当当当当”。
 * 在午夜00:00到中午12:00期间（端点时间包括在内），笨钟是不敲的。
 * 下面就请你写个程序，根据当前时间替大笨钟敲钟。
 *
 * 这是一个简单的判断问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val input = readLine()!!
    when {
        "00:00" <= input && input <= "12:00" -> 0
        else -> {
            val (hour, minute) = input.split(":").map { it.toInt() }
            (if (minute == 0) hour else hour + 1) - 12
        }
    }.let {
        when (it) {
            0 -> "Only $input.  Too early to Dang."
            else -> "Dang".repeat(it)
        }
    }.let(::println)
}
