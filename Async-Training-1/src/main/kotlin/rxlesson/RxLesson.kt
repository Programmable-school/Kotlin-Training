package rxlesson

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
import model.User

/**
 * Observable: ストリーム（データを流す通路）
 * BehaviorSubject: 最後のデータを保持する。onNextで新しいデータを流し、subscribeとvalueでデータを取得できる
 * fromArray: 引数に指定されたデータのObservableを生成
 * zip: 複数のObservableから流れてきたデータを組み合わせて単一のデータにする
 * map: 機能はリスト操作のmapと同じ。Observableで返す
 * flatMap: 機能はリスト操作のmapと同じ。Observableを触れれないが、中の値にアクセスできる。
 * dispose: subscribeした後はdisposeをすることで購読を終了する。
 *          subscribeしたオブジェクトが消えることが保証されていないため、使い終わったら明示的にdisposeを呼んで終了させる。
 */
class RxLesson {
    fun execute() {
        println("---- Lesson_ReactiveX ----")
        /**
         * Rxで値を加工する
         */
        lessonRxProcess()

        /**
         * Rxでデータバインディングのようなことをする
         */
        lessonRxBinding()

        /**
         * RxでAPIのレスポンスを取得する
         */
        lessonRxApiRequest()

        /**
         * RxでPromiseAllのようなことをする
         */
        lessonRxPromiseAll()

        /**
         * RxでAsync/Awaitのようなことをする
         */
        lessonRxAsyncAwait()

        println("-----------------------------")
    }

    fun lessonRxProcess() {
        val o1: Observable<Int> = Observable.fromArray(1,2,3,4,5)
        val o2: Observable<String> = Observable.fromArray("A", "B", "C", "D", "E")
        o1.subscribe {
            println("RxProcess o1 ${it}")   // RxProcess o1 1 ... RxProcess o1 5 の順に表示される
        }

        // o1に流れてくる値を加工してストリームへ流す
        o1.map { it * 2 }.subscribe {
            println("RxProcess o1 ${it}")   // RxProcess o1 2 ... RxProcess o1 10 の順に表示される
        }

        // list1からlist2へ順番にストーリムへ流す
        val list1: List<Int> = listOf(1, 2, 3, 4, 5)
        val list2: List<String> = listOf("A", "B", "C", "D", "E")
        val o3: Observable<List<Any>> = Observable.fromArray(list1, list2)
        o3.map {
            if (it.first() is Int) {
                return@map (it as List<Int>).map { item -> item * 2 }
            } else {
                return@map (it as List<String>).map { item -> item + item }
            }
        }.subscribe {
            println("RxProcess o3 ${it}") // RxProcess o3 [2, 4, 6, 8, 10] ... RxProcess o3 [AA, BB, CC, DD, EE] の順に表示される
        }

        // o1とo2の値を結合してストリームへ流す
        val o4: Observable<String> = Observable.zip(o1, o2,
            BiFunction<Int, String, String> { d1, d2 -> "${d1}: ${d2}" })
        o4.subscribe {
            println("RxProcess o4 ${it}") // RxProcess o4 A: 1 ... RxProcess o4 E: 5 の順に表示される
        }
    }

    fun lessonRxBinding() {
        val o1: BehaviorSubject<Int> = BehaviorSubject.createDefault(1)
        val o2: BehaviorSubject<String> = BehaviorSubject.createDefault("A")
        println("RxBinding o1 ${o1.value}, o2 ${o2.value}")     // RxBinding o1 1, o2 A

        // o1をsubscribeしてo2の値を変える
        val disposable: Disposable = o1.subscribe {
            when(it) {
                2 -> o2.onNext("B")
                3 -> o2.onNext("C")
                4 -> o2.onNext("D")
                5 -> o2.onNext("E")
                else -> o2.onNext("A")
            }
        }

        /**
         * onNextでsubscribeで値を取得できる。
         * subscribe内に処理を書けばo1の値によってユニークな処理を実現できる。
         */
        o1.onNext(2)
        println("RxBinding o1 ${o1.value}, o2 ${o2.value}")     // RxBinding o1 2, o2 B

        o1.onNext(3)
        println("RxBinding o1 ${o1.value}, o2 ${o2.value}")     // RxBinding o1 3, o2 C

        o1.onNext(4)
        println("RxBinding o1 ${o1.value}, o2 ${o2.value}")     // RxBinding o1 4, o2 D

        o1.onNext(5)
        println("RxBinding o1 ${o1.value}, o2 ${o2.value}")     // RxBinding o1 5, o2 E

        disposable.dispose()
    }

    fun lessonRxApiRequest() {
        val service = ApiClient().getService()

        service.users().subscribe({ users: List<User> ->
            println("success: users count ${users.count()}")     // success: users count 20
        }, { error: Throwable ->
            println("error: ${error.message}")
        }).dispose()

        Thread.sleep(1000)
    }

    fun lessonRxPromiseAll() {
        val service = ApiClient().getService()
        val id = "hukusuke1007" // ご自身のQiita IDに変更してください。
        /**
         * 並列処理をする場合はzipを利用する。
         */
        Observable.zip(
            service.users().toObservable(),
            service.user(id).toObservable(),
            BiFunction<List<User>, User, Unit> { t1, t2 ->
                println(t1.count())     // users count 20
                println(t2)             // User(id=hukusuke1007, name=Shohei Nakagawa...
            }
        ).subscribe({
            println("success")          // success
        }, { error: Throwable ->
            println("error: ${error.message}")
        }).dispose()

        Thread.sleep(1000)
    }

    fun lessonRxAsyncAwait() {
        /**
         * ユーザー情報の一覧から特定のユーザー情報を取得
         * flatMapにすることでObservableではなくオブジェクトそのものを取得できる。
         */
        val service = ApiClient().getService()
        service.users().flatMap {
            return@flatMap service.user(it.last().id)
        }.subscribe({ user: User ->
            println("success: ${user}")               // success: User(id= ....
        }, { error: Throwable ->
            println("error: ${error.message}")
        }).dispose()

        Thread.sleep(1000)
    }
}