package lesson

fun lessonFunction() {
    lessonFunction1()                                   // 関数です
    lessonFunction2("引数を指定できます")             // 引数を指定できます
    val result1: Int = lessonFunction3(10, 2)
    val result2: Int = lessonFunction4(10, 2)
    println("足し算の関数 ${result1} ${result2}")         // 足し算の関数 12 12
}

fun lessonFunction1() {
    println("関数です")
}

fun lessonFunction2(str: String) {
    println(str)
}

fun lessonFunction3(x: Int, y: Int): Int {
    return x + y
}

// {} returnを省略して書ける
fun lessonFunction4(x: Int, y: Int): Int = x + y