package com.example.standchartdb5

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel:ViewModel() {
    lateinit var timer:CountDownTimer

     var _seconds = MutableLiveData<Int>()

    var number = 0

    fun addNumber(){
        number++
    }

    fun seconds(): LiveData<Int> {
        return _seconds
    }

    fun startTimer(){
        timer = object : CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                var timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
            }

        }.start()
    }


}

/*
class MainViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): ViewModelProvider.Factory {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")    }
}
*/
