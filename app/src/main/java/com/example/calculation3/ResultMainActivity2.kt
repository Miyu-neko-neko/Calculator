package com.example.calculation3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result_main2.*

class ResultMainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main2)

        // インテントに格納された箱を開ける。!!強制的にnonNullに変換
        val bundle: Bundle = intent.extras!!

        val numberOfLeft: Int = bundle.getInt("numberOfLeft")
        val numberOfRight: Int = bundle.getInt("numberOfRight")
        val markOfCalc: String? = bundle.getString("markOfCenter")

        val result: Int = when(markOfCalc){
            "+" -> numberOfLeft + numberOfRight
            "-" -> numberOfLeft - numberOfRight
            "×" -> numberOfLeft * numberOfRight
            "÷" -> numberOfLeft / numberOfRight
            else -> 0
        }

        resultTextView.text = result.toString()

        backButton.setOnClickListener{
            finish()
        }
    }
}
