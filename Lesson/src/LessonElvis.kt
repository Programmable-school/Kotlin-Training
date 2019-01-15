package lesson

/**
 * エルビス演算子
 * データがnullでなければそのデータを代入してnullであれば指定したデータを代入する
 */
fun lessonElvis() {
    val value1: Int? = 10
    val value2: Int? = null

    /**
     * value1はnullではないので10が代入され、value2はnullなので指定したデータ（0）が代入される
     */
    // 書き方 1
    val result11: Int = if (value1 != null) value1 else 0
    val result12: Int = if (value2 != null) value2 else 0
    println("${result11}, ${result12}")     // 10, 0

    // 書き方 2（推奨）
    val result21: Int = value1 ?: 0
    val result22: Int = value2 ?: 0
    println("${result21}, ${result22}")     // 10, 0

}