package coroutineslesson

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * CoroutineLesson
 * コルーチンを使ってApiClientからデータを取得する。
 * 参考記事：https://qiita.com/kawmra/items/d024f9ab32ffe0604d39
 */
class CoroutinesLesson: CoroutineScope {

    private val loadingJob: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = loadingJob

    fun execute() {
        println("---- Lesson_Coroutines ----")

        val service = ApiClient().getService()
        /**
         * ユーザー情報の一覧を取得する
         */
        launch(Dispatchers.Unconfined) {
            try {
                val result = service.users().await()
                println("users count ${result.count()}")
            } catch (error: Throwable) {
                println("error: ${error.message}")
            }
        }

        /**
         * ユーザー情報の一覧から特定のユーザー情報を取得
         */
        launch(Dispatchers.Unconfined) {
            try {
                val resultA = service.users().await()
                val resultB = service.user(resultA.last().id).await()
                println("user ${resultB}")
            } catch (error: Throwable) {
                println("error: ${error.message}")
            }
            println("-----------------------------")
        }

        /**
         * Dispatchers.Default -> バックグラウンドスレッド
         * Dispatchers.Unconfined -> メインスレッド
         */
    }
}