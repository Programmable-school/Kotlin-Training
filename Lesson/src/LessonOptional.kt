package lesson

/* Optional型 */
// Optional型の場合はnullの場合があるかも？という意味で?をつける。
fun lessonOptional() {
    var strA: String? = null
    // var strA: String = null  // Optional型以外でnullを入れるとコンパイルエラーになる
    // println(strA.length)     // strAがnullの場合があるためコンパイルエラーになる
    println(strA)               // null
    println(strA?.length)       // null

    strA = "hogehoge"
    println(strA)               // hogehoge
    println(strA?.length)       // 8
}
