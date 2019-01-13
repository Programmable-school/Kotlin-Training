package lesson

/* Enum */
fun lessonEnum() {
    var type: SocialType = SocialType.Twitter
    var typeNum: Int = SocialType.Twitter.rowValue
    println(type)                               // Twitter
    println(typeNum)                            // 0

    type = SocialType.Facebook
    typeNum = SocialType.Facebook.rowValue
    println(type)                               // Facebook
    println(typeNum)                            // 1

    type = SocialType.Instagram
    typeNum = SocialType.Instagram.rowValue
    println(type)                               // Instagram
    println(typeNum)                            // 2
}

enum class SocialType(val rowValue: Int) {
    Twitter(0),
    Facebook(1),
    Instagram(2)
}