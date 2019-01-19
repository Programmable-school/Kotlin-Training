package lesson

/* キャスト変換（型変換） */
/**
 * 型の判定は is を使う。
 */
fun lessonCast() {
    val numStr: String = "1000"
    val num: Int = numStr.toInt()
    if (num is Int) {
        println("String -> Int: ${num}")        // String -> Int: 1000
    }

    val strNum: Int = 2000
    val str: String = strNum.toString()
    if (str is String) {
        println("Int -> String: ${str}")        // String -> Int: 1000
    }

    val classAny: Any = LessonCast1()
    if (classAny is LessonCast1) {
        println("classAnyの型はLessonCast1です。${classAny}") // classAnyの型はLessonCast1です。lesson.LessonCast1@3abbfa04
    }

    /**
     * Any型からLessonCast1へ変換。
     * オプショナルで変換することで型が違っていた場合はnullが入る。
     */
    val classCast1 = classAny as? LessonCast1
    val classCast2 = classAny as? LessonCast2
    println(classCast1)                         // lesson.LessonCast1@3abbfa04
    println(classCast2)                         // null

}

class LessonCast1 {}
class LessonCast2 {}