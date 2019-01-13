package lesson

/* while文（繰り返し） */
fun lessonWhile() {
    val nums: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5)
    var index: Int = 0
    var total: Int = nums[0]

    // while
    while (index < 5) {
        total += nums[index]
        index += 1
    }
    println("while ${total}")                                    // while 10

    // do-while
    do {
        println("do-while indexは${index}だけど必ず1回は実行される") // do-while indexは5だけど必ず１回は実行される
    } while (index < 5) // 繰り返し継続判断は後で実行される。
}