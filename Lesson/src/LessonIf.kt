package lesson

/* if文（条件分岐） */
fun lessonIf() {
    var value: Int = 1

    if (value == 1) {
        println("Case ${value} valueは1です。")         // Case 1 valueは1です。
    } else {
        // ※ココは通らない
        println("Case ${value} valueは1以外です。")
    }

    value = 2
    if (value == 1) {
        // ※ココは通らない
        println("Case ${value} valueは1です。")
    } else {
        println("Case ${value} valueは1以外です。")      // Case 2 valueは1以外です。
    }

    value = 3
    if (value == 1) {
        // ※ココは通らない
        println("Case ${value} valueは1です。")
    } else if (value == 3) {
        println("Case ${value} valueは3です。")         // Case 3 valueは3です。
    } else {
        // ※ココは通らない
        println("Case ${value} valueは1以外です。")
    }

}