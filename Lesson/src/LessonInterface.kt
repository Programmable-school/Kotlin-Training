package lesson

/**
 * インターフェース
 * データの受け渡しやメンバ・メソッドを規約したいときに用いる
 */
fun lessonInterface() {
    // データ受け渡し用にインターフェースでデータセット
    val student1: StudentDTO = object : StudentDTO {
        override val name: String
            get() = "Yamada"
        override val score: Int
            get() = 100
    }
    val student2: StudentDTO = object : StudentDTO {
        override val name: String
            get() = "Tanaka"
        override val score: Int
            get() = 200
    }
    val student3: StudentDTO = object : StudentDTO {
        override val name: String
            get() = "Koike"
        override val score: Int
            get() = 300
    }

    // 内定ジャッジメント
    val result1 = judgementJobOffer(student1)
    val result2 = judgementJobOffer(student2)
    val result3 = judgementJobOffer(student3)

    // 合否を表示
    if (result1 is JobOfferResultFailure) {
        println("name: ${result1.name}, isJudgement: ${result1.isJudgement}, " +
                "comment: ${result1.comment}, isOinoriEmail: ${result1.isOinoriEmail}") // name: Yamada, isJudgement: true, comment: 不合格, isOinoriEmail: true
    }
    if (result2 is JobOfferResultPass) {
        println("name: ${result2.name}, isJudgement: ${result2.isJudgement}, " +
                "comment: ${result2.comment}, ceremony: ${result2.ceremony}")           // name: Tanaka, isJudgement: true, comment: 内定, ceremony: 2019/10/1 10:00:00
    }
    if (result3 is JobOfferResultPass) {
        println("name: ${result3.name}, isJudgement: ${result3.isJudgement}, " +
                "comment: ${result3.comment}, ceremony: ${result3.ceremony}")           // name: Koike, isJudgement: true, comment: 内定, ceremony: 2019/10/1 10:00:00
    }
}

// 学生インターフェース
interface StudentDTO {
    val name: String
    val score: Int
}

// 採用結果のインターフェース（規約）
interface JobOfferResultDTO {
    val name: String
    val isJudgement: Boolean
    val comment: String
}

// 内定用の結果クラス
class JobOfferResultPass: JobOfferResultDTO {
    override var name: String = ""
    override var isJudgement: Boolean = false
    override var comment: String = ""
    lateinit var ceremony: String
}

// 不合格用の結果クラス
class JobOfferResultFailure: JobOfferResultDTO {
    override var name: String = ""
    override var isJudgement: Boolean = false
    override var comment: String = ""
    var isOinoriEmail: Boolean = false
}

fun judgementJobOffer(student: StudentDTO): JobOfferResultDTO {
    if (student.score >= 200) {
        val resultDTO = JobOfferResultPass()
        resultDTO.name = student.name
        resultDTO.isJudgement = true
        resultDTO.comment = "内定"
        resultDTO.ceremony = "2019/10/1 10:00:00"
        return resultDTO
    } else {
        val resultDTO = JobOfferResultFailure()
        resultDTO.name = student.name
        resultDTO.isJudgement = true
        resultDTO.comment = "不合格"
        resultDTO.isOinoriEmail = true
        return resultDTO
    }
}