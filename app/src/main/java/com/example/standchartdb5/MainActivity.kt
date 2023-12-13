package com.example.standchartdb5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
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

    fun openDialer(view: View) {
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678"))
        startActivity(dIntent)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
       // }
    }

    fun setAlarm(view: View) {
        createAlarm("B5 STANDARD",11,46)
    }
}