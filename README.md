# Kotlin-Training

> 初学者向け Kotlin構文理解のためのソースコード
## 開発環境
- IntelliJ IDEA 2018.3以上
- Kotlin 1.3以上

IntelliJ IDEAの公式サイトでIntelliJ IDEA Community（無償版）をダウンロードしてインストールしてください。<br> 
[IntelliJ IDEA](https://www.jetbrains.com/idea/)<br>

## 手順
IntelliJ IDEAを利用してコーディングします。

### 環境構築
以下の手順を実行して
1. IntelliJ IDEAを起動
2. Create New Projectを選択
3. KotlinのKotlin/JVMを選択してNextを選択
4. Project nameで好きな名前に変更してFinishを選択（エディタが開くまで数秒かかります）

### Hello! world.を表示する
さきほど作成したのIntelliJ IDEAのプロジェクト内で、左側のメニューの「src」を右クリックより<br>
「New」->「Kotlin File/Class」を選択してファイル名を「Lesson」にしてOKを選択して作成します。<br>
<a href="https://imgur.com/vt2q8jk"><img src="https://i.imgur.com/vt2q8jk.png" width="500" height="300" /></a>
<br>

作成されたLesson.ktで以下のように実装してください。

```kotlin
package lesson

fun main(args: Array<String>) {
    /* Hello! World.を表示 */
    println("Hello! world.") // Hello!. world.
}
```
エディタツールバー -> Run -> Runで実行します。<br>
またショートカットキーで「control + R」で実行できます（便利なのでオススメ）。<br>
<br>
実行するとエディタ下部の画面に "Hello world!"が表示されます。<br>
<br>
以上です。<br>
<br>
コンテンツ準備中のため、<br>
直接ソースコードを見て写経して学習してください。<br>
[Lesson.kt](https://github.com/Programmable-school/Kotlin-Training/blob/master/Lesson/src/Lesson.kt)<br>
