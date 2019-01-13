package lesson

/* for文（繰り返し） */
fun lessonFor() {
    val nums: ArrayList<Int> = arrayListOf(10, 20, 30, 40, 50, 60)

    // for-in
    for (value in nums) {
        println("for ${value}")                     // for 10 ... for 60
    }

    // for-in indexも取得
    for ((index, value) in nums.withIndex()) {
        println("for ${index} ${value}")            // for 0 10 ... for 5 60
    }

    // foreach
    nums.forEach {
        println("foreach ${it}")                    // foreach 10 ... foreach 60
    }

    // foreach indexも取得
    nums.withIndex().forEach {
        println("foreach ${it.index} ${it.value}")  // foreach 0 10 ... foreach 5 60
    }

}