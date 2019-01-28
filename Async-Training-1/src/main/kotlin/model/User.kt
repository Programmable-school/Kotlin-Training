package model

data class User(
    var id: String,
    var name: String,
    var followees_count: Int,
    var followers_count: Int,
    var items_count: Int,
    var permanent_id: Int,
    var profile_image_url: String,
    var team_only: Boolean,
    var facebook_id: String? = null,
    var github_login_name: String? = null,
    var linkedin_id: String? = null,
    var location: String? = null,
    var organization: String? = null,
    var twitter_screen_name: String? = null,
    var website_url: String? = null
)