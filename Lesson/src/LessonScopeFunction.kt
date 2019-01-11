package lesson

/*
    スコープ関数一覧（一部）
    let     オブジェクト: it,     戻り値: 可能（結果を返す）
    run     オブジェクト: this,   戻り値: 可能（自分のオブジェクト）
    apply   オブジェクト: this,   戻り値: 不可
    also    オブジェクト: it,     戻り値: 不可
 */
fun lessonScopeFunction() {
    val str1: String = "scope"

    // let
    val let1: String = str1.let {
        println("${it} ${it.toUpperCase()}")   // scope SCOPE
        "letだよ"
    }
    println("let ${let1}")                     // let letだよ

    // run
    val run1: String = str1.run {
        println("${this} ${toUpperCase()}")    // scope SCOPE
        "runだよ"
    }
    println("run ${run1}")                     // run runだよ

    // apply
    val apply1: String = str1.apply {
        println("${this} ${toUpperCase()}")    // scope SCOPE
        "applyだよ"
    }
    println("apply ${apply1}")                 // apply scope

    // also
    val also1: String = str1.also {
        println("${it} ${it.toUpperCase()}")   // scope SCOPE
        "alsoだよ"
    }
    println("also ${also1}")                   // also scope
}