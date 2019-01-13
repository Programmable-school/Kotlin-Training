package lesson

/* AND・OR, 三項演算子 */
fun lessonAndOr() {
    val isActive: Boolean = true
    val age: Int = 20

    // 書き方1
    if (isActive && age == 20) {
        println("AND isActiveとageは一緒")  // AND isActiveとageは一緒
    } else {
        // ※ココは通らない
        println("AND 一致しない")
    }

    if (isActive || age == 30) {
        println("OR isActiveだけ一致")      // OR isActiveだけ一致
    } else {
        // ※ココは通らない
        println("OR 一致しない")
    }

    // 三項演算子
    /**
     * Kotlinには三項演算子はない！
     */
}