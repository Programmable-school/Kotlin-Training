package lesson

/* ラムダ式・無名関数 */
fun lessonLambdaExpression() {
    // ラムダ式（関数を式として利用できる (引数) -> {処理}　のように書ける）
    println("ラムダ式 ${lessonLambdaExpression1(10, 2)}, ${lessonLambdaExpression2(10, 2)}")

    // 無名関数（名前の無い関数　fun(引数)のように書ける）
    println("無名関数 ${lessonLambdaExpression3(10, 2)}, ${lessonLambdaExpression4(10, 2)}")
}

// ラムダ式
val lessonLambdaExpression1: (Int, Int) -> Int =  { x: Int, y: Int -> x + y }

// ラムダ式（型省略）
val lessonLambdaExpression2 = { x: Int, y: Int -> x + y }

// 無名関数
val lessonLambdaExpression3: (Int, Int) -> Int = fun(x: Int, y: Int): Int {
    return x + y
}

// 無名関数 {} returnを省略して書ける
val lessonLambdaExpression4: (Int, Int) -> Int = fun(x: Int, y: Int): Int = x + y