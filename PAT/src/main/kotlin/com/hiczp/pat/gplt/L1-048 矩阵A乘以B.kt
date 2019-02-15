package com.hiczp.pat.gplt

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * L1-048 矩阵A乘以B （15 分）
 * 给定两个矩阵A和B，要求你计算它们的乘积矩阵AB。
 * 需要注意的是，只有规模匹配的矩阵才可以相乘。即若A有Ra行、Ca列，B有Rb行、Cb列，则只有Ca与Rb相等时，两个矩阵才能相乘。
 *
 * 这道题说的是叉乘
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    //读取数据
    val readData = {
        val r = bufferedReader.readLine().substringBefore(' ').toInt()
        Array(r) {
            bufferedReader.readLine().split(' ').map { it.toInt() }.toIntArray()
        }
    }
    val a = Matrix(readData())
    val b = Matrix(readData())

    //如果 a 的列数不等于 b 的行数则无法叉乘
    val ca = a.data[0].size
    val rb = b.data.size
    if (ca != rb) {
        println("Error: $ca != $rb")
        return
    }

    //相乘
    println(a * b)
}

private class Matrix(val data: Array<IntArray>) {
    override fun toString() =
        StringBuilder().apply {
            val r = data.size
            val c = data[0].size
            appendln("$r $c")
            repeat(r) { currentRow ->
                repeat(c) { currentColumn ->
                    append(data[currentRow][currentColumn])
                    if (currentColumn != c - 1) append(' ') //末尾不得有多余空格
                }
                if (currentRow != r - 1) appendln()
            }
        }.toString()
}

private operator fun Matrix.times(other: Matrix): Matrix {
    val r1 = this.data.size
    val c1 = this.data[0].size
    val c2 = other.data[0].size
    val product = Array(r1) { IntArray(c2) }
    for (i in 0 until r1) {
        for (j in 0 until c2) {
            for (k in 0 until c1) {
                product[i][j] += this.data[i][k] * other.data[k][j]
            }
        }
    }
    return Matrix(product)
}
