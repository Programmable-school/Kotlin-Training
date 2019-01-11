package lesson

/* リスト操作 */
fun lessonListOperation() {
    val nums: Array<Int> = arrayOf(0, 1, 2, 3, 4, 5)

    // ■ filter
    // 条件に合う値だけを取り出します。条件に当てはまる要素が複数ある場合があるので配列で取得される。
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

    // ■ map
    // 新しい要素の配列を作成する。値を加工して新しい配列を作成するときに利用する。
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