import com.oracle.tools.packager.Log
import model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main(args: Array<String>) {
    println("Start")
    /**
     * ApiClientからCallbackでデータを取得する
     */
    val service = ApiClient().getService()

    // ユーザー情報の一覧を取得する
    service.users()
        .enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                /**
                 * 注意：code=403になった場合はAPI制限のため時間をあけて実行してください。
                 */
                println("success: get users ${response}")

                val data: List<User>? = response.body()
                var targetId: String = ""
                data?.let {
                    println("users count ${it.count()}")     // users count 20
                    // 取得したユーザー一覧の最後のユーザーのIDを設定
                    targetId = it.last().id
                }

                // 特定のユーザー情報を取得
                service.user(targetId)
                    .enqueue(object : Callback<User> {
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            println("success: get user ${response}")
                            val data = response.body()
                            data?.let {
                                println("${it.id} ${it.name} ${it.profile_image_url}")
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            println("error: ${t.message}")
                        }
                    })
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("error: ${t.message}")
            }
        })

    Thread.sleep(3000)
    println("Stop")
}