package lesson

/**
 * 継承
 *  共通のメンバ・メソッドがある場合は親クラス（スーパークラス）を作成し、
 *  親クラスを継承する子クラス（サブクラス）を用意することで子クラスは親クラスの持ち物を利用できる。
 *  修飾子によってアクセス制限できる
 *  public: 誰でも利用できる
 *  private: 親クラスのみ利用できる
 *  protected: 親クラスと子クラスのみ利用できる。外部からアクセスはできない
 */
fun lessonInheritance() {
    // Engineerの社員を生成
    val employee1: Employee = Employee(0)           // class create
    employee1.setProfile("Taro", "President")
    val info1 = employee1.getMyInfo()
    println("${employee1.name} ${info1}")               // Taro {name=Taro, tel=0120000000, id=0, profile=President}

    // Marketingの社員を生成
    val employee2: Employee = Employee(1)           // class create
    employee2.setProfile("Hanako", "Engineer")
    val info2 = employee2.getMyInfo()
    println("${employee2.name} ${info2}")               // Hanako Hanako {name=Hanako, tel=0120000000, id=1, profile=Engineer}

    // 親クラスのprivateは親クラスのみアクセスできる
    val hesokuriResult1 = employee1.getHesokuri()
    val hesokuriResult2 = employee2.getHesokuri()
    println("${employee1.name} ${hesokuriResult1}")     // Taro 会社のへそくりは　1円
    println("${employee2.name} ${hesokuriResult2}")     // Hanako 社長じゃないから分からない
    // employee1.hesokuri   // 呼ぶことはできない

    // protectedは親クラスと子クラスのみアクセスできる
    employee1.checkAsset()                              // Company Asset: 100000000
    // employee1.asset      // 呼ぶことはできない
}

/**
 * スーパークラス
 * openをつけることでoverride及びサブクラス化できる。
 */
open class CompanyEmployee {
    var companyName: String	                 // 会社名
    var companyTel: String	                 // 会社の電話番号
    var employeeId: Int = -1	             // 社員ID
    protected var asset: Long	             // 会社の資産
    private var hesokuri: Int                // 会社のへそくり

    constructor() {
        this.companyName = "Develop Inc."
        this.companyTel = "0120000000"
        this.asset = 100_000_000
        this.hesokuri = 1
        println("class create")
    }

    // 会社情報を取得
    fun getCompanyInfo(): MutableMap<String, Any> = mutableMapOf("name" to companyName, "tel" to companyTel)

    // ヘソクリ情報取得（社員IDが0（社長）だけ教える）
    fun getHesokuri(id: Int): String {
        if (id == 0) {
            return "会社のへそくりは　${hesokuri}円"
        } else {
            return "社長じゃないから分からない"
        }
    }
}

/**
 * サブクラス
 * CompanyEmployeeを継承する。
 */
class Employee: CompanyEmployee {
    lateinit var name: String
    lateinit var profile: String

    // superを継承することでCompanyEmployeeのコンストラクタを呼ぶ
    constructor(id: Int): super()  {
        super.employeeId = id	  // CompanyEmployeeのメンバを使える
    }

    fun setProfile(name: String, profile: String) {
        this.name = name
        this.profile = profile
    }

    fun getMyInfo(): Map<String, Any> {
        val info: MutableMap<String, Any> = super.getCompanyInfo()
        info.put("id", super.employeeId)
        info.put("name", name)
        info.put("profile", profile)
        return info
    }

    fun checkAsset() {
        println("Company Asset: ${super.asset}")
    }

    fun getHesokuri(): String = super.getHesokuri(super.employeeId)

}
