package lesson

/* アンラップ Optionalのデータを安全に取り出したい場合はアンラップを利用する */
fun lessonUnwrap() {

    // 書き方1
    var strA: String? = null
    strA?.let {
        // nullのため表示されない
        println(it)
    } ?: run {
        println("strAはnullです")    // strAはnullです
    }

    strA = "hogehoge"
    strA?.let {
        println(it)                 // hogehoge
    }

    // 書き方2
    var strB: String? = null
    val hoge1: String = strB ?: "nullです"
    println(hoge1)                  // nullです

    strB = "hogehoge"
    val hoge2: String = strB ?: "nullです"
    println(hoge2)                  // hogehoge

}