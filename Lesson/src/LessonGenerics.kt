package lesson

/* ジェネリクス */
fun lessonGenerics() {

    /**
     * ジェネリクスクラスを使った例
     * CompanyHumanを継承したクラスしか利用できないよう制約する。
     */
    val staff1 = Company<Staff>(Staff("大学生A", "スタッフです。"))
    val manager1 = Company<Manager>(Manager("社員B", "社員です。", "XXX運営会社"))
    println("${staff1.getName} ${staff1.getProfile} ${staff1.companyHuman.isActive}")           // 大学生A スタッフです。 true
    println("${manager1.getName} ${manager1.getProfile} ${manager1.companyHuman.companyName}")  // 社員B 社員です。 XXX運営会社

    /**
     * ジェネリクス関数を使った例
     * CompanyHumanを継承したクラスしか利用できないよう制約する。
     */
    val staff2 = Staff("大学生B", "スタッフです。")
    val manager2 = Manager("社員B", "社員です。", "XXX運営会社")

    // 給料を支払う
    salalyPay(staff2)                                     // This is Staff.
    salalyPay(manager2)                                   // This is Manager. XXX運営会社
    println("スタッフの給料 ${staff2.salary}")              // スタッフの給料 200000
    println("マネージャーの給料 ${manager2.salary}")         // マネージャーの給料 500000
}

/**
 * ジェネリクス クラスに制約
 * CompanyHumanを継承するクラスを許容する
 */
class Company<T: CompanyHuman>(var companyHuman: T) {
    val getName: String
        get() = companyHuman.name
    val getProfile: String
        get() = companyHuman.profile
}

/**
 * ジェネリクス 関数に制約
 * CompanyHumanを継承するクラスを許容する
 */
fun <T: CompanyHuman> salalyPay(employee: T) {

    // employeeがStaffの場合は20万を設定
    if (employee is Staff) {
        // employeeがStaffの場合は20万を設定
        println("This is Staff.")
        employee.salary = 200_000
    }

    if (employee is Manager) {
        // employeeがManagerの場合は50万を設定
        println("This is Manager. ${employee.companyName}")
        employee.salary = 500_000
    }

}

interface CompanyHuman {
    val name: String
    val profile: String
    var salary: Int
}

class Staff: CompanyHuman {
    override val name: String
    override val profile: String
    override var salary: Int = 0
    var isActive: Boolean

    constructor(name: String, profile: String) {
        this.name = name
        this.profile = profile
        this.isActive = true
    }
}

class Manager: CompanyHuman {
    override val name: String
    override val profile: String
    override var salary: Int = 0
    val companyName: String

    constructor(name: String, profile: String, companyName: String) {
        this.name = name
        this.profile = profile
        this.companyName = companyName
    }

    // 解雇する関数
    fun breakStaff(staff: Staff) {
        staff.isActive = false
    }
}