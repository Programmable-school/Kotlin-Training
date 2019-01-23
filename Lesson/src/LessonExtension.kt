package lesson

/* 拡張関数 */
fun lessonExtension() {
    "Hello world".output()                  // Hello world

    val comment: String = 100.getComment()
    println(comment)                        // 数値は100です。
}

/**
 * Stringにoutputという関数を拡張
 */
fun String.output() { println(this) }

/**
 * IntにgetCommentとうい関数を拡張
 */
fun Int.getComment(): String = "数値は${this}です。"
