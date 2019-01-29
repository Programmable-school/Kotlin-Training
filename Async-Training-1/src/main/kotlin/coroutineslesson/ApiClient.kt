package coroutineslesson

import model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * HTTPクライアントのretrofit利用する
 * Qiita APIを使ってデータを取得する
 *  概要（公式）： https://qiita.com/api/v2/docs
 *  概要（非公式だがわかりやすい）： https://qiita.com/tag1216/items/b0b90e30c7e581aa2b00
 *  注意：リクエストしすぎるとリクエスト制限がかかる
 */
class ApiClient {
    private val baseUrl = "https://qiita.com/"     // APIのURLを設定
    private val retrofit = Retrofit.Builder()      // retrofitの設定
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())   // Coroutinesのadapterを設定
        .build()
    fun getService(): QiitaService = retrofit.create(QiitaService::class.java)
}

interface QiitaService {
    @GET("api/v2/users")
    fun users(): Deferred<List<User>>

    @GET("api/v2/users/{user_id}")
    fun user(@Path("user_id") id: String): Deferred<User>
}