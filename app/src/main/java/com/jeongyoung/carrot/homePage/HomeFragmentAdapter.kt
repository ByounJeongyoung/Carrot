package com.jeongyoung.carrot.homePage

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeFragmentAdapter(var crimes: List<HomeFragementData>):RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder>() {

   inner class ViewHolder(view : View):RecyclerView.ViewHolder(view){


    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount() = crimes.size
}