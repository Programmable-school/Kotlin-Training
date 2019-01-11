package lesson

/* 演算子 */
fun lessonCalc() {
    val value: Int = 1
    val resultA: Int = value + 2
    val resultB: Int = value * 2
    val resultC: Int = value / 2
    println(resultA)    // 3
    println(resultB)    // 2
    println(resultC)    // 0

    var resultD: Int = 1
    resultD += 2
    var resultE: Int = 1
    resultE *= 2
    var resultF: Int = 1
    resultF /= 2
    println(resultD)    // 3
    println(resultE)    // 2
    println(resultF)    // 0
}