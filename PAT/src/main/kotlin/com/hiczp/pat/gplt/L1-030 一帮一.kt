package com.hiczp.pat.gplt

import java.util.*
import kotlin.collections.ArrayList

/**
 * L1-030 一帮一 （15 分）
 * “一帮一学习小组”是中小学中常见的学习组织方式，老师把学习成绩靠前的学生跟学习成绩靠后的学生排在一组。
 * 本题就请你编写程序帮助老师自动完成这个分配工作，即在得到全班学生的排名后，在当前尚未分组的学生中，将名次最靠前的学生与名次最靠后的异性学生分为一组。
 *
 * 这是一个队列问题
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    //按名次排序
    val orderByRank = ArrayList<Student>()
    //女生
    val female = ArrayDeque<Student>()
    //男生
    val male = ArrayDeque<Student>()

    //输入
    repeat(scanner.nextInt()) {
        val student = Student(scanner.nextInt(), scanner.next())
        orderByRank.add(student)
        if (student.gender == 0) {
            female
        } else {
            male
        }.apply {
            add(student)
        }
    }

    orderByRank.forEach { student ->
        if (student.gender == 0) {
            female to male
        } else {
            male to female
        }.let { (currentGender, oppositeGender) ->
            //从当前性别对应的队列中移除当前学生
            currentGender.removeFirst()
            //从另一性别的队列中取得最后一个
            val anotherStudent = oppositeGender.removeLast()
            //输出
            println("${student.name} ${anotherStudent.name}")
            //判断是否已空(题目保证男女人数相等, 只需要判断一个即可)
            if (female.isEmpty() || male.isEmpty()) {
                return
            }
        }
    }
}

private data class Student(
    val gender: Int,
    val name: String
)
