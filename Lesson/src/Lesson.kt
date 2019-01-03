package lesson
import java.util.*

fun main(args: Array<String>) {
    println("---- Lesson_HelloWorld ----")
    lessonHelloWorld()
    println("------------------\n")

    println("---- Lesson_VarVal ----")
    lessonVarVal()
    println("------------------\n")

    println("---- Lesson_PriAny ----")
    lessonPriAny()
    println("------------------\n")
}

/* Hello! World.を表示 */
fun lessonHelloWorld() {
    println("Hello! world.") // Hello!. world.
}

/* 変数と定数 */
fun lessonVarVal() {
    // 変数
    var count: Int = 1
    count += 1

    var message: String = ""
    message = "Lesson ${count}"
    println(message)    // Lesson 2

    // 定数
    val name: String = "山田太郎"
    // name = "Yamada Taro" // 定数のためビルドエラーになる
    println(name)       // 山田太郎
}

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
/* Optional型 */
/* null安全 */
/* 演算子 */
/* コレクション */
/* 配列 */
/* filter, map, reduce, sort */
/* if分 */
/* 比較演算子 */
/* AND・OR */
/* 三項演算子 */
/* switch文 */
/* when文 */
/* while文 */
/* for文 */
/* 関数 */
/* Enum */
/* 構造体 */
/* クラス */
/* 継承 */
/* インターフェース */
/* 抽象クラス */
/* 値渡し参照渡し */
/* キャスト変換 */
/* 日付関数（Date） */
/* 数値計算（Math） */
/* objectとcompanion object */
/* 拡張関数 */
/* ジェネリクス */
/* ラムダ式 */
/* コールバック */
/* コルーチン */
/* ReactiveX */