package lesson

/* 配列 */
fun lessonArray() {
    val numsA: Array<Int> = arrayOf(0, 1, 2, 3)
    println(numsA.count())               // 4
    println("${numsA[0]} ${numsA[1]}")   // 0 1
    // println(numsA[4]) // 範囲外の要素にアクセスするため例外エラー発生する

    // 初期値確定していない場合はサイズを確保したnull配列を定義する
    val numsB: Array<Int?> = arrayOfNulls<Int?>(4)
    numsB[0] = 0
    numsB[1] = 1
    numsB[2] = 2
    numsB[3] = 3
    println("${numsB[0]} ${numsB[1]} ${numsB[2]} ${numsB[3]}")   // 0 1 2 3

    /*
        Arrayでは新しい要素を追加することはできないので次項のコレクションを利用する。
     */
}