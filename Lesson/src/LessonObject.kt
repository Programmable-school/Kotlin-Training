package lesson

/* objectとcompanion object */
fun lessonObject() {

    /**
     * object
     */
    val object1 = object {
        var num: Int = 0
        var str: String = "object1"
    }
    println("object1: ${object1.num}, ${object1.str}")      // object1: 0, object1

    /**
     * サブクラスを作るまでもない場合にObjectを利用する。
     */
    val object2 = object : ObjectDTO {
        override var num: Int = 10
        override var str: String = "object2"
    }
    println("object2: ${object2.num}, ${object2.str}")      // object2: 10, object2

    /**
     * Singletonを実現するためにobjectを利用する。
     * Singletonとは一度生成されたらアプリが消えるまで生き続けるインスタンスのこと。
     * staticメンバ、関数のように利用できるので、Utilityクラスを作成するときに利用する。
     */
    println("singleton: ${SingletonClass.num}, ${SingletonClass.str} ${SingletonClass.getHello()}") // singleton: 0, singleton Hello

    /**
     * companion object
     * companion objectとして指定されたメンバと関数はインスタンスを生成しなくても呼べる。
     * インスタンス生成時にとある処理が必要な場合はcompanionの中に集約できる。
     */
    val companionObject = CompanionClass.create()
    println("companion: ${CompanionClass.TAG} ${companionObject.num} ${companionObject.str}")       // companion: COMPANION_CLASS 100 companion

}

interface ObjectDTO {
    var num: Int
    var str: String
}

object SingletonClass {
    var num: Int = 0
    var str: String = "singleton"
    init {
        println("Singleton生成") // 生成は１度だけなので１度しか呼ばれない
    }
    fun getHello(): String = "Hello"
}

class CompanionClass {
    var num: Int = 0
    var str: String = ""

    companion object {
        const val TAG = "COMPANION_CLASS"
        fun create(): CompanionClass {
            val instance = CompanionClass()
            instance.num = 100
            instance.str = "companion"
            return instance
        }
    }
}