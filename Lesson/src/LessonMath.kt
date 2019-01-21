package lesson

/* 数値計算（Math） */
fun lessonMath() {
    // ■ 四捨五入
    val round1 = Math.round(5.71)
    val round2 = Math.round(5.21)
    println(round1)                 // 6
    println(round2)                 // 5

    // ■ 切り上げ
    val ceil1 = Math.ceil(5.71)
    val ceil2 = Math.ceil(5.21)
    println(ceil1)                  // 6.0
    println(ceil2)                  // 6.0

    // ■ 小数点以下を切り捨てて最大整数を返す
    val floor1 = Math.floor(5.71)
    val floor2 = Math.floor(-5.71)
    println(floor1)                 // 5.0
    println(floor2)                 // -6.0

    // ■ 2乗
    val pow = Math.pow(2.0, 3.0)
    println(pow)                    // 8.0
}