package com.example.standchartdb5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //TextView tvMsg;
    lateinit var tvMsg: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //inflating xml -- parse- mem vars  in RAM
        tvMsg = findViewById(R.id.tvMessage)
    }

    //void clickHandler(View mview){}
    fun clickHandler(mview: View) {
        tvMsg.setText("welcome to android")
    }
}