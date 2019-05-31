package lesson

/* クラス */
fun lessonClass() {

    // ■ class
    println("--- class")
    lessonClass_Class()
    println("--- ")

    // ■ data class
    println("--- data class")
    lessonClass_Data()
    println("--- ")
}

/**
 * データのまとまり。データやメソッドをを定義できる。
 */
fun lessonClass_Class() {
    // クラスのインスタンスを生成するときは クラス名() の書き方をする
    val man: Human = Human(SexType.Man, "1990/1/1")
    man.name = "Taro"
    man.setStatus(170, 80)
    man.showStatus()            // name Taro height 170 weight 80 birthday 1990/1/1

    // setはprivateだけ許容しているためビルドエラーになる
    // man.birthday = 20

    val woman: Human = Human(SexType.Woman, "1992/1/1")
    woman.name = "Hanako"
    woman.setStatus(150, 100)
    woman.showStatus()          // name Hanako height 150 weight 100 birthday 1992/1/1

    man.introPartner(woman)     // まぁいつ別れるか分からないけどね。これは独り言だから内緒だよ！
    man.showPartner()           // Taroのパートナーは Hanako
    woman.showPartner()         // Hanakoのパートナーは Taro
}

class Human {
    /**
     * 変数（propety）
     */
    
    /** 修飾子:public    外部公開, 修飾子がない場合はpublicになる */
    public lateinit var name: String
    var sexType: SexType

    /** 修飾子:private   外部公開しないので自分しか読み書きできない */
    private var height: Int = 0
    private var weight: Int = 0 

    /** publicのoptional型で宣言. Optional型の場合はデータにnullチェックを行う */
    var partner: Human? = null

    /** 読み取り専用（定数） private setを使用する */
    var birthday: String = ""
        private set

    /**
     * コンストラクタはクラスのインスタンス（実体）が生成されたタイミングで処理される
     */
    constructor(sexType: SexType, birthday: String) {
        this.sexType = sexType
        this.birthday = birthday
    }

    /**
     * 関数　修飾子を付けれる（public, privateなど） 修飾子がない場合はpublicになる.
     */
    fun setStatus(height: Int, weight: Int) {
        this.height = height
        this.weight = weight
    }

    fun showStatus() {
        println("name: $name, height: $height, weight: $weight, birthday: $birthday")
    }

    fun introPartner(human: Human) {
        if (this.sexType != human.sexType) {
            this.partner = human
            human.partner = this
            this.showHonne()
        }
    }

    fun showPartner() {
        this.partner?.let {
            println("${name}のパートナーは ${it.name}")
        }
    }

    private fun showHonne() {
        println("まぁいつ別れるか分からないけどね。これは独り言だから内緒だよ！")
    }

}

enum class SexType {
    Man,
    Woman
}


/**
 * データを保持するためのクラス
 * copyメソッドを使用することで新たにインスタンスを生成して同じデータを代入できる（値渡しのようなもの）
 */
fun lessonClass_Data() {
    val human1: HumanData = HumanData("Taro", 20)
    println("${human1.name}, ${human1.age}")        // Taro, 20
    println(human1.getProfile())                    // name: Taro, age: 20

    // human1のデータをhuman2へコピーする（新たにインスタンスを生成して渡しているだけ）
    val human2: HumanData = human1.copy()
    human1.name = "Hanako"
    human1.age = 30

    println(human1.getProfile())                    // name: Hanako, age: 30
    println(human2.getProfile())                    // name: Taro, age: 20
}


data class HumanData(var name: String, var age: Int) {
    fun getProfile(): String = "name: ${name}, age: ${age}"
}