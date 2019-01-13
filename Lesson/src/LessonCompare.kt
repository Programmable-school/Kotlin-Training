package lesson

/* 比較演算子 */
fun lessonCompare() {
    var value: Int = 1

    if (value == 1) {
        println("Case == valueは1です。")           // Case == valueは1です。
    }

    if (value != 1) {
        // ※ココは通らない
        println("Case != valueは1以外です。")
    }

    if (value > 1) {
        // ※ココは通らない
        println("Case > valueは1以上です。")
    } else {
        println("Case > valueは1含め1以下です。")   // Case > valueは1含め1以下です。
    }

    if (value >= 1) {
        println("Case >= valueは1含め1以下です。")  // Case >= valueは1含め1以下です。
    } else {
        // ※ココは通らない
        println("Case >= valueは1以下です。")
    }

    if (value < 1) {
        // ※ココは通らない
        println("Case < valueは1以下です。")
    } else {
        println("Case < valueは1含め1以上です。")   // Case < valueは1含め1以上です。
    }

    if (value <= 1) {
        println("Case <= valueは1含め1以下です。")  // Case <= valueは1含め1以下です。
    } else {
        // ※ココは通らない
        println("Case <= valueは1以上です。")
    }
}