package com.example.standchartdb5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.standchartdb5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //TextView tvMsg;
    lateinit var tvMsg: TextView
    lateinit var etName: EditText
    lateinit var binding: ActivityMainBinding
   // lateinit var calcButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_main)  //inflating xml -- parse- mem vars  in RAM
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        tvMsg = findViewById(R.id.tvMessage)
        etName =  findViewById(R.id.etName)
       // calcButton = findViewById(R.id.calculate_button)
       // calcButton.setOnClickListener {  }
        binding.calculateButton.setOnClickListener {
            var cost =  binding.costOfService.text.toString()
            binding.tipResult.text = cost
        }
    }

    //void clickHandler(View mview){}
    fun clickHandler(mview: View) {
        tvMsg.setText("welcome to android")
        //Intent hIntent = new Intent();-- intension
        var name:String  = etName.text.toString()
        var hIntent: Intent = Intent(this,HomeActivity::class.java) //explicit intent
        hIntent.putExtra("nkey",name)
        startActivity(hIntent)
    }

    fun openDialer(view: View) {
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:12345678")) //implicit
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