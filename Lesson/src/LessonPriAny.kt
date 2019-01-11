package lesson

import java.util.*

/* プリミティブ型、Any型  */
fun lessonPriAny() {
    val numInt: Int = 10                // 32ビット符号付き整数
    val numLong: Long = 10000000000000L // 64ビット浮動小数点数
    val numDouble: Double = 10.123      // 64ビット浮動小数点数
    val numFloat: Float = 10.123f       // 32ビット浮動小数点数
    val numByte: Byte = 0xF             // 8ビット符号付き整数
    val numShort: Short = 10000         // 16ビット符号付き整数
    val str: String = "文字列"           // 文字列型
    val char: Char = '文'               // １文字の文字型
    val isActive: Boolean = true        // Boolean型（trueかfalse）
    println(numInt)                 // 10
    println(numLong)                // 10000000000000
    println(numDouble)              // 10.123
    println(numFloat)               // 10.123
    println(numByte)                // 15
    println(numShort)               // 10000
    println(str)                    // 文字列
    println(char)                   // 文
    println(isActive)               // true

    var variable: Any
    variable = 1
    println("number ${variable}")   // number 1

    variable = "文字列"
    println("String ${variable}")   // String 文字列

    variable = false
    println("Boolean ${variable}")  // Boolean false

    variable = Date()
    println("class ${variable}")    // class Thu Jan 03 23:22:20 JST 2019
}