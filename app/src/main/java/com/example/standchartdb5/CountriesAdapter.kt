package com.example.standchartdb5

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter: RecyclerView.Adapter<CViewHolder>() {
    var TAG = CountriesAdapter::class.java.simpleName
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CViewHolder {
        Log.i(TAG,"harsh bought a row plannk from the market and gave it to  gowtham")

        var rowView =  LayoutInflater.from(parent.context).inflate(R.layout.row_plank,parent,false)

        return   CViewHolder(rowView)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}


class CViewHolder(private val rowView: View): RecyclerView.ViewHolder(rowView){
    //Log.i(TAG,"gowtham received that row plank given by harsh")


}
