import callbacklesson.ApiClient
import callbacklesson.CallbackLesson
import coroutineslesson.CoroutinesLesson
import model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rxlesson.RxLesson

fun main(args: Array<String>) {
    /**
     * Callback
     */
    val callbackLesson = CallbackLesson()
    callbackLesson.execute()
    Thread.sleep(1500)

    /**
     * Corutine
     */
    val coroutinesLesson = CoroutinesLesson()
    coroutinesLesson.execute()
    Thread.sleep(1500)

    /**
     * ReactiveX
     */
    val rxLesson = RxLesson()
    rxLesson.execute()
    Thread.sleep(1500)
}