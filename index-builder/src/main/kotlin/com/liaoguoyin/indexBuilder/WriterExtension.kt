package com.liaoguoyin.indexBuilder

import java.io.BufferedWriter

fun BufferedWriter.writeLine(string: String) {
    write(string)
    newLine()
}
