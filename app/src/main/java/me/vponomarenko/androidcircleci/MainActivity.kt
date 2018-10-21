package me.vponomarenko.androidcircleci

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val textReverser = TextReverser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_click_me.setOnClickListener {
            text_main.text = textReverser.reverse(text_main.text.toString())
        }
    }
}
