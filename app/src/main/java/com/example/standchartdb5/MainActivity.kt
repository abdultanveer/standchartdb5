package com.example.standchartdb5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //TextView tvMsg;
    lateinit var tvMsg: TextView
    lateinit var etName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  //inflating xml -- parse- mem vars  in RAM
        tvMsg = findViewById(R.id.tvMessage)
        etName =  findViewById(R.id.etName)
    }

    //void clickHandler(View mview){}
    fun clickHandler(mview: View) {
        tvMsg.setText("welcome to android")
        //Intent hIntent = new Intent();-- intension
        var name:String  = etName.text.toString()
        var hIntent: Intent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("nkey",name)
        startActivity(hIntent)
    }
}