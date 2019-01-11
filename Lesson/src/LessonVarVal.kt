package lesson

/* 変数と定数 */
fun lessonVarVal() {
    // 変数
    var count: Int = 1
    count += 1

    var message: String
    message = "Lesson ${count}"
    println(message)    // Lesson 2

    // 定数
    val name: String = "山田太郎"
    // name = "Yamada Taro" // 定数のためビルドエラーになる
    println(name)       // 山田太郎
}