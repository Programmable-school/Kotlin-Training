package lesson

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
