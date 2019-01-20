package lesson

import java.text.SimpleDateFormat
import java.util.*

/* 日付関数（Date） */
fun lessonDate() {

    // ■ 現在の日時を取得
    val nowDate: Date = Date()
    println(nowDate)                                        // Sun Jan 20 10:05:32 JST 2019
    println(nowDate.toString())                             // Sun Jan 20 10:05:32 JST 2019

    // ■ タイムゾーン確認（実行環境に依存）
    println(TimeZone.getDefault().id)                       // Asia/Tokyo
    println(TimeZone.getDefault().rawOffset/(60*60*1000))   // 9

    // ■ 文字列から日時を取得
    val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val date1 = df.parse("2019/1/6 10:20:30")
    println(date1)                                      // Sun Jan 06 10:20:30 JST 2019

    val calendar1 = Calendar.getInstance()
    calendar1.time = date1
    val year = calendar1.get(Calendar.YEAR)             // 年
    val month = calendar1.get(Calendar.MONTH) + 1       // 月 0始まりなので1を足す
    val day = calendar1.get(Calendar.DATE)              // 日
    val hour = calendar1.get(Calendar.HOUR_OF_DAY)      // 時
    val minute = calendar1.get(Calendar.MINUTE)         // 分
    val second = calendar1.get(Calendar.SECOND)         // 秒
    val dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK) // 曜日（数値）
    val dayOfWeekStr = arrayListOf<String>("日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日")[dayOfWeek]  // 曜日（文字列）
    println("${year}/${month}/${day} (${dayOfWeekStr}) ${hour}:${minute}:${second}")    //  2019/1/6 (月曜日) 10:20:30

    // ■ set関数より日付を指定
    val calendar2 = Calendar.getInstance()
    calendar2.set(Calendar.YEAR, 2019)                  // 2019年
    calendar2.set(Calendar.MONTH, 1)                    // 2月（0始まり）
    calendar2.set(Calendar.DATE, 10)                    // 10日
    calendar2.set(Calendar.HOUR_OF_DAY, 4)              // 4時
    calendar2.set(Calendar.MINUTE, 20)                  // 20分
    calendar2.set(Calendar.SECOND, 30)                  // 30秒
    println(calendar2.time)                             // Sun Feb 10 04:20:30 JST 2019
}