package lesson

/* 抽象クラス */
/**
 * データの受け渡しやメンバ・メソッドを規約したいときに用いる。
 * 継承して使用する。抽象クラスはそのままではインスタンス化できない。
 * インターフェース性質はほぼ一緒だが、インターフェースと違い多重継承できない。
 */
fun lessonAbstract() {
    EnglishTeacher("Taro").helloTeacher()       // Hello. Taro is Teacher
    JapaneaseTeacher("Hanako").helloPartTime()  // Hello. Hanako is PartTime
}

abstract class Teacher() {
    abstract fun helloTeacher()
}

abstract class PartTime {
    abstract fun helloPartTime()
}

class EnglishTeacher(val name: String): Teacher() {
    override fun helloTeacher() {
        println("Hello. ${name} is Teacher")
    }
}

class JapaneaseTeacher(val name: String): PartTime() {
    override fun helloPartTime() {
        println("Hello. ${name} is PartTime")
    }
}

// 抽象クラスの多重継承はできない。
/*
class MathTeacher(val name: String): Teacher(), PartTime() {
    override fun helloTeacher() {
        println("Hello. ${name} is Teacher")
    }
    override fun helloPartTime() {
        println("Hello. ${name} is PartTime")
    }
}
*/