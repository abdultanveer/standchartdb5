package com.example.standchartdb5

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(var countries: Array<String>) : RecyclerView.Adapter<CViewHolder>() {
    var TAG = CountriesAdapter::class.java.simpleName
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CViewHolder {
        Log.i(TAG,"harsh bought a row plannk from the market and gave it to  gowtham")

        var rowPlank =  LayoutInflater.from(parent.context).inflate(R.layout.row_plank,parent,false)

        return   CViewHolder(rowPlank)
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "mansi counted no of items --"+countries.size)
        return countries.size
    }

    override fun onBindViewHolder(holder: CViewHolder, position: Int) {
        Log.i(TAG,"ayasha is writing --"+countries[position])
        holder.tvRow.text  = countries[position]
    }
}


class CViewHolder( val rowPlank: View): RecyclerView.ViewHolder(rowPlank){
    //Log.i(TAG,"gowtham received that row plank given by harsh")
    val tvRow: TextView = rowPlank.findViewById(R.id.tvRow)



}
