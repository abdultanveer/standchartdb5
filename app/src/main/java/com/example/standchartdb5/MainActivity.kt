package com.example.standchartdb5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.standchartdb5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
        //"MainActivity"
    //TextView tvMsg;
    lateinit var tvMsg: TextView
    lateinit var etName: EditText
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
   // lateinit var calcButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_main)  //inflating xml -- parse- mem vars  in RAM
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(TAG,"oncreated")

        tvMsg = findViewById(R.id.tvMessage)
        etName =  findViewById(R.id.etName)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
      /* mainViewModel =  MainViewModel by viewModels<MainViewModel>{
           MainViewModelFactory()

       }*/
        //mainViewModel = ViewModelProvider.AndroidViewModelFactory(this.application).create(MainViewModel::class.java)
        binding.tvInc.text = mainViewModel.number.toString()

       // calcButton = findViewById(R.id.calculate_button)
       // calcButton.setOnClickListener {  }
        binding.calculateButton.setOnClickListener {
            var cost =  binding.costOfService.text.toString()
            var tip =  calculateTip(cost.toInt())

            binding.tipResult.text = tip.toString()
            //throw  NullPointerException("demo crash")
        }
    }

    private fun calculateTip(cost: Int): Int {
        var  c:Int =0
        for (i in 1..10){
            c  = i * 5
        }

        return cost/10

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"started")

    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"resumed-- restore   the  game state")

    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"paused--save game state")

    }

    override fun onStop() {
        super.onStop()
        Log.v(TAG,"stopped")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"destroyed  -- release all the  resources")

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
    //var no = 0

    fun increment(view: View) {
        mainViewModel.addNumber()
        binding.tvInc.text = mainViewModel.number.toString()
    }
}