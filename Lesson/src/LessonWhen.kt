package lesson

/* when文（条件判断） */

fun lessonWhen() {
    /**
     * Kotlinにはswitch構文はないためwhen構文を使う
     */
    val resultA: String = lessonWhen0(1988)
    val resultB: String = lessonWhen0(2018)
    val resultC: String = lessonWhen0(100000)
    println(resultA)    // 昭和63年
    println(resultB)    // 平成30年
    println(resultC)    // 分かりません！
}

fun lessonWhen0(year: Int): String {
    val result: String
    when(year) {
        1988 -> result = "昭和63年"
        2018 -> result = "平成30年"
        else -> result = "分かりません！"
    }
    return result
}