# Kotlin-Training-Async-Training

> 初心者向け Kotlin入門トレーニング（非同期処理）。

## 目次
- [非同期処理（コールバック）](https://github.com/Programmable-school/Kotlin-Training/tree/master/Async-Training-1/src/main/kotlin/callbacklesson)
- [非同期処理（コルーチン）](https://github.com/Programmable-school/Kotlin-Training/tree/master/Async-Training-1/src/main/kotlin/coroutineslesson)
- [ReactiveX](https://github.com/Programmable-school/Kotlin-Training/tree/master/Async-Training-1/src/main/kotlin/rxlesson)

## 開発環境
- IntelliJ IDEA 2018.3以上
- Kotlin 1.3以上

IntelliJ IDEAの公式サイトでIntelliJ IDEA Community（無償版）をダウンロードしてインストールしてください。<br> 
[IntelliJ IDEA](https://www.jetbrains.com/idea/)<br>

## 手順
IntelliJ IDEAを利用してコーディングします。

### 環境構築
以下の手順を実行してGradleを導入したプロジェクトを作成します。
1. IntelliJ IDEAを起動
2. Create New Projectを選択
3. GradleのKotlinを選択してNextを選択
<br>
<br>
<a href="https://imgur.com/xFebqCE"><img src="https://i.imgur.com/xFebqCE.png" width="500" height="300" /></a>
<br>
<br>
4. 以下のキャプチャに従ってNextを選択<br>
<br>
<a href="https://imgur.com/h17zbFl"><img src="https://i.imgur.com/h17zbFl.png" width="500" height="300" /></a>
<br>
<br>
5. GroupIdはメールアドレスの逆で入力を推奨。ArtifactIdはプロジェクト名を入力。<br>
<br>
<a href="https://imgur.com/Q9e4PAY"><img src="https://i.imgur.com/Q9e4PAY.png" width="500" height="300" /></a>
<br>
<br>
6. Finishを選択してプロジェクト作成完了<br>
<br>
<a href="https://imgur.com/yUt3Shl"><img src="https://i.imgur.com/yUt3Shl.png" width="500" height="300" /></a>
<br>

### ライブラリを導入
本レッスンで利用するライブラリを導入します。
作成したプロジェクトのbuild.gradleのdependenciesを以下のようにします。
```gradle
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    /**
     * -- ここから追加 --
     */
    // HTTPリクエストを行う
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'

    // HTTPリクエストから取得したJSONをモデルクラスに変換してくれる
    implementation 'com.squareup.retrofit2:converter-gson:2.0.2'

    // retrofit2のcoroutines用のAdapter
    implementation 'com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2'

    // retrofit2のRxJava2用のAdapter
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'

    // コルーチン
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1'

    // ReactiveX
    implementation 'io.reactivex.rxjava2:rxkotlin:2.3.0'
    implementation 'io.reactivex.rxjava2:rxjava:2.2.3'
}

```

## 進め方
main.ktがプロジェクトのエントリーポイントです。<br>
各レッスンのコードを写経し、写経したコードをパッケージへ入れてからmain.ktをコールするようにして実装してください。<br>
パッケージの作成はIntellij IDEAのprojectを右クリックから作成欄が表示され作成できます。<br>
<br>
<a href="https://imgur.com/lWN4wLP"><img src="https://i.imgur.com/lWN4wLP.png" width="400" height="500" /></a>

### フォルダ構成
フォルダ構成は以下のようになります。<br>
<br>
<a href="https://i.imgur.com/VWmJWbb.png"><img src="https://i.imgur.com/VWmJWbb.png" width="300" height="500" /></a>