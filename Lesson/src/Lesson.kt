package lesson
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    println("---- Lesson_HelloWorld ----")
    lessonHelloWorld()
    println("------------------\n")

    println("---- Lesson_VarVal ----")
    lessonVarVal()
    println("------------------\n")

    println("---- Lesson_PriAny ----")
    lessonPriAny()
    println("------------------\n")

    println("---- Lesson_Optional ----")
    lessonOptional()
    println("------------------\n")

    println("---- Lesson_Unwrap ----")
    lessonUnwrap()
    println("------------------\n")

    println("---- Lesson_Calc ----")
    lessonCalc()
    println("------------------\n")

    println("---- Lesson_Array ----")
    lessonArray()
    println("------------------\n")

    println("---- Lesson_Collection ----")
    lessonCollection()
    println("------------------\n")

    println("---- Lesson_ListOperation ----")
    lessonListOperation()
    println("------------------\n")
}

/* Hello! World.を表示 */
fun lessonHelloWorld() {
    println("Hello! world.") // Hello!. world.
}

/* 変数と定数 */
fun lessonVarVal() {
    // 変数
    var count: Int = 1
    count += 1

    var message: String
    message = "Lesson ${count}"
    println(message)    // Lesson 2

    // 定数
    val name: String = "山田太郎"
    // name = "Yamada Taro" // 定数のためビルドエラーになる
    println(name)       // 山田太郎
}

/* プリミティブ型、Any型  */
fun lessonPriAny() {
    val numInt: Int = 10                // 32ビット符号付き整数
    val numLong: Long = 10000000000000L // 64ビット浮動小数点数
    val numDouble: Double = 10.123      // 64ビット浮動小数点数
    val numFloat: Float = 10.123f       // 32ビット浮動小数点数
    val numByte: Byte = 0xF             // 8ビット符号付き整数
    val numShort: Short = 10000         // 16ビット符号付き整数
    val str: String = "文字列"           // 文字列型
    val char: Char = '文'               // １文字の文字型
    val isActive: Boolean = true        // Boolean型（trueかfalse）
    println(numInt)                 // 10
    println(numLong)                // 10000000000000
    println(numDouble)              // 10.123
    println(numFloat)               // 10.123
    println(numByte)                // 15
    println(numShort)               // 10000
    println(str)                    // 文字列
    println(char)                   // 文
    println(isActive)               // true

    var variable: Any
    variable = 1
    println("number ${variable}")   // number 1

    variable = "文字列"
    println("String ${variable}")   // String 文字列

    variable = false
    println("Boolean ${variable}")  // Boolean false

    variable = Date()
    println("class ${variable}")    // class Thu Jan 03 23:22:20 JST 2019
}

/* Optional型 */
fun lessonOptional() {
    var strA: String? = null
    // var strA: String = null  // Optional型以外でnullを入れるとコンパイルエラーになる
    // println(strA.length)     // strAがnullの場合があるためコンパイルエラーになる
    println(strA)               // null

    // Optional型の場合はnullの場合があるかも？という意味で?をつける。
    println(strA?.length)       // null

    strA = "hogehoge"
    println(strA)               // hogehoge
    println(strA?.length)       // 8
}

/* アンラップ Optionalのデータを安全に取り出したい場合はアンラップを利用する */
fun lessonUnwrap() {

    // 書き方1
    var strA: String? = null
    strA?.let {
        // nullのため表示されない
        println(it)
    } ?: run {
        println("strAはnullです")    // strAはnullです
    }

    strA = "hogehoge"
    strA?.let {
        println(it)                 // hogehoge
    }

    // 書き方2
    var strB: String? = null
    val hoge1: String = strB ?: "nullです"
    println(hoge1)                  // nullです

    strB = "hogehoge"
    val hoge2: String = strB ?: "nullです"
    println(hoge2)                  // hogehoge

}

/* 演算子 */
fun lessonCalc() {
    val value: Int = 1
    val resultA: Int = value + 2
    val resultB: Int = value * 2
    val resultC: Int = value / 2
    println(resultA)    // 3
    println(resultB)    // 2
    println(resultC)    // 0

    var resultD: Int = 1
    resultD += 2
    var resultE: Int = 1
    resultE *= 2
    var resultF: Int = 1
    resultF /= 2
    println(resultD)    // 3
    println(resultE)    // 2
    println(resultF)    // 0
}


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

    // Arrayでは新しい要素を追加することはできないので次項のコレクションを利用する。
}

/* コレクション */
fun lessonCollection() {
    // MutableList: 要素を追加できる
    val mutableNums: MutableList<Int> = mutableListOf(0, 1, 2, 3)
    mutableNums.add(4)
    println(mutableNums)        // [0, 1, 2, 3, 4]

    // List: 読み取り専用 MutableListのスーパークラスのため代入できるがMutableListが持つ機能（addなど）は使えない
    val listNums: List<Int> = mutableNums
    println(listNums)           // [0, 1, 2, 3, 4]

    // Set: 要素に重複がなくなるが順序は保証されない
    val setNums: Set<Int> = setOf(0 , 1, 2, 2, 3, 3, 3, 4)
    println(setNums)            // [0, 1, 2, 3, 4]

    // Map: Key to Valueの配列　読み取り専用
    val mapNums: Map<String, String> = mapOf("name" to "Taro", "profile" to "I'm a engineer.")
    println(mapNums)            // {name=Taro, profile=I'm a engineer.}

    val mapResultA: String? = mapNums.get("name")
    val mapResultB: String? = mapNums.get("profile")
    val mapResultC: String? = mapNums.get("remarks") // 該当するkeyがない場合はnullが入る
    println(mapResultA)        // Taro
    println(mapResultB)        // I'm a engineer.
    println(mapResultC)        // null

    // MutableMap: Key to Valueの配列 要素を追加できる
    val mutableMap: MutableMap<String, String> = mutableMapOf("name" to "Hanako", "profile" to "I'm a Idol.")

    mutableMap.put("remarks", "pretty")
    println(mutableMap)         // {name=Hanako, profile=I'm a Idol., remarks=pretty}

    val mMapResultA: String? = mutableMap.get("name")
    val mMapResultB: String? = mutableMap.get("profile")
    val mMapResultC: String? = mutableMap.get("remarks")
    println(mMapResultA)        // Hanako
    println(mMapResultB)        // I'm a Idol.
    println(mMapResultC)        // pretty
}

/* filter, map, fold, all, any, sort, flatMap, zip */
fun lessonListOperation() {
    val nums: Array<Int> = arrayOf(0, 1, 2, 3, 4, 5)

    // ■ filter 条件に合う値だけを取り出します。条件に当てはまる要素が複数ある場合があるので配列で取得される。
    // 書き方1
    val numsFiltered1 = nums.filter { item -> item == 0 }
    println("filter1 ${numsFiltered1}")     // filter1 [0]

    // 書き方2
    val numsFiltered2 = nums.filter { item ->
        if (item == 0) {
            return@filter true
        }
        return@filter false
    }
    println("filter2 ${numsFiltered2}")     // filter2 [0]

    // ■ map 新しい要素の配列を作成する。値を加工して新しい配列を作成するときに利用する。
    // 書き方1
    val numsMap1 = nums.map { item -> item * 2 }
    println("map1 ${numsMap1}")             // map1 [0, 2, 4, 6, 8, 10]

    // 書き方2
    val numsMap2 = nums.map { item ->
        return@map item * 2
    }
    println("map2 ${numsMap2}")             // map2 [0, 2, 4, 6, 8, 10]

    // ■ fold
    // 配列の要素を左から右へ適用し,単一の値にします。
    val fold1: Int = nums.fold(0) { prevItem, currentItem -> prevItem + currentItem }
    println("fold1 ${fold1}")               // fold1 15

    val maxFold1: Int = nums.fold(0) { prevItem, currentItem ->
        if (prevItem > currentItem) {
            return@fold prevItem
        }
        return@fold  currentItem
    }
    println("maxFold1 ${maxFold1}")         // maxFold1 5

    val minFold1: Int = nums.fold(0) { prevItem, currentItem ->
        if (prevItem > currentItem) {
            return@fold currentItem
        }
        return@fold prevItem
    }
    println("minFold1 ${minFold1}")         // minFold1 0

    // ■ max, min
    // 配列の最大値と最小値を取得
    val max: Int? = nums.max()
    val min: Int? = nums.min()
    println("max ${max}")                    // max 5
    println("min ${min}")                    // min 0

    // ■ all
    // 全ての要素が条件を満たす場合は trueを返す
    val isAll1: Boolean = nums.all { item -> item >= 0 }
    println("isAll1 ${isAll1}")             // isAll1 true

    val isAll2: Boolean = nums.all { item -> item%2 == 0}
    println("isAll2 ${isAll2}")             // isAll2 false

    // ■ any
    // 条件を満たす要素が１つでもある場合は trueを返す
    val isAny1: Boolean = nums.any { item -> item >= 0 }
    println("isAny1 ${isAny1}")             // isAny1 true

    val isAny2: Boolean = nums.any { item -> item %2 == 0}
    println("isAny2 ${isAny2}")             // isAny2 true

    // ■ sort
    // 配列の要素を並べ替える
    // 昇順ソート（小さい順）
    val sort1: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5)
    sort1.sort()
    val sort2: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5)
    sort2.sortBy { it }
    println("sort1 ${sort1}")
    println("sort2 ${sort2}")

    // 降順ソート（大きい順）
    val sort3: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5)
    sort3.sortByDescending { it }
    val sort4: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4, 5)
    sort4.reverse()
    println("sort3 ${sort3}")
    println("sort4 ${sort4}")

    // ■ flatMap
    // 複数の配列をフラット（１次元配列）にする
    val flatNums1: ArrayList<Int> = arrayListOf(0, 1, 2)
    val flatNums2: ArrayList<String> = arrayListOf("one", "two", "three")
    val flatMap: List<Any> = arrayListOf(flatNums1, flatNums2).flatMap { num -> num }
    println("flatMap ${flatMap}")   // flatMap [0, 1, 2, one, two, three]

    // ■ zip
    // 二つのリストの要素をペアにする
    val zipNums1: ArrayList<Int> = arrayListOf(0, 1, 2)
    val zipNums2: ArrayList<String> = arrayListOf("one", "two", "three")
    val zip: List<Pair<Int, String>> = zipNums1.zip(zipNums2)
    println("zip ${zip}")           // zip [(0, one), (1, two), (2, three)]
}

/* if分（条件判断） */
/* 比較演算子 */
/* AND・OR */
/* 三項演算子 */
/* switch文（条件判断） */
/* when文（条件判断） */
/* while文（繰り返し） */
/* for文（繰り返し） */
/* 関数 */
/* Enum */
/* 構造体 */
/* クラス */
/* 継承 */
/* インターフェース */
/* 抽象クラス */
/* 値渡し参照渡し */
/* キャスト変換 */
/* 日付関数（Date） */
/* 数値計算（Math） */
/* objectとcompanion object */
/* 拡張関数 */
/* ジェネリクス */
/* ラムダ式 */
/* コールバック */
/* コルーチン */
/* ReactiveX */