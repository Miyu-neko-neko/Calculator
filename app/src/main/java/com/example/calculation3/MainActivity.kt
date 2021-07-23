package com.example.calculation3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ボタン処理の実装。OnClickメソッド
        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)
        Button0.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        clearButton.setOnClickListener(this)
        resultButton.setOnClickListener(this)
        tasuButton.setOnClickListener(this)
        hikuButton.setOnClickListener(this)
        kakeruButton.setOnClickListener(this)
        waruButton.setOnClickListener(this)

        // =ボタン
        resultButton.setOnClickListener{
            val numberOfLeft: Int = textViewLeft.text.toString().toInt()
            val numberOfRight: Int = textViewRight.text.toString().toInt()
            val markOfCenter: String = textViewCenter.text.toString()

            //TextViewの実装
            textViewLeft.text = ""
            textViewRight.text = ""
            textViewCenter.text = ""

            // 送信元画面から、送信先画面へインテントの渡し先を決める。　::はクラスリテラル。JAVAライブラリを使用する際に
            //使う
            val intent = Intent(this@MainActivity,ResultMainActivity2::class.java)
            //渡す情報を識別するキー,渡す情報
            intent.putExtra("numberOfLeft",numberOfLeft)
            intent.putExtra("numberOfRight",numberOfRight)
            intent.putExtra("markOfCenter",markOfCenter)
            //新しい外面を開いてインテントを渡す
            startActivity(intent)

        }
    }

    override fun onClick(v: View?) {

        //ViewをButton型に変換する（キャスト）。Textを取得できる。
        val button: Button = v as Button

        when (v.id){
            R.id.clearButton
            ->{
                textViewLeft.text = ""
                textViewRight.text = ""
                textViewCenter.text = ""
            }
            R.id.minusButton
                //空白の時は-を代入
            ->if (textViewCenter.text.toString() == ""){
                if (textViewLeft.text.toString() == "") {
                    textViewLeft.text = button.text
                }
            } else {
                if (textViewRight.text.toString() == "") {
                    textViewRight.text = button.text
                }
            }
            R.id.tasuButton
                //左側テキストが空白じゃなかったら+を代入
            -> if (textViewLeft.text.toString() != "") {
                textViewCenter.text = "+"
            }
            R.id.hikuButton
                //左側テキストが空白じゃなかったら+を代入
            -> if (textViewLeft.text.toString() != "") {
                textViewCenter.text = "-"
            }
            R.id.kakeruButton
                //左側テキストが空白じゃなかったら+を代入
            -> if (textViewLeft.text.toString() != "") {
                textViewCenter.text = "×"
            }
            R.id.waruButton
                //左側テキストが空白じゃなかったら+を代入
            -> if (textViewLeft.text.toString() != "") {
                textViewCenter.text = "÷"
            }
            R.id.Button0
                //真ん中が空白の場合
            -> if (textViewCenter.text.toString() == "") {
                //左側が0かつ-じゃない場合
                if (textViewLeft.text.toString() != "0" && textViewLeft.text.toString() != "-") {
                    //末尾に0を追加
                    textViewLeft.append(button.text)
                }
            }
            else {
                //右側が0かつ-じゃない場合、末尾に0を追加
                if (textViewRight.text.toString() != "0" && textViewRight.text.toString() != "-") {
                    textViewRight.append(button.text)
                }
            }

            else
            -> if (textViewCenter.text.toString() == "") {
                //0が入力されてたら上書きする。
                if (textViewLeft.text.toString() == "0") {
                    textViewLeft.text = button.text
                } else {
                    textViewLeft.append(button.text)
                }
            } else {
                if (textViewRight.text.toString() == "0") {
                    textViewRight.text = button.text
                } else {
                    textViewRight.append(button.text)
                }
            }
        }
    }
}
