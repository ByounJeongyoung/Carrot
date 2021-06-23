package com.jeongyoung.carrot.homePage

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.arround.RecommendIconAdapter
import com.jeongyoung.carrot.databinding.FragmentArroundIconListBinding
import com.jeongyoung.carrot.databinding.FragmentHomeItemBinding


class HomeFragmentAdapter() : RecyclerView.Adapter<HomeFragmentAdapter.Holder>() {

    var listData = mutableListOf<MerchandiseModel>()

    inner class Holder(val binding: FragmentHomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: MerchandiseModel) {

            binding.apply {
                homeImg.setImageResource(model.img)
                titleTxt.text = model.title
                timeTxt.text = model.time
                priceTxt.text = model.price
            }

        }

        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "상품이름:${binding.titleTxt.text.toString()}\n" +
                        "올라온시간:${binding.timeTxt.text.toString()}\n" +
                        "가격:${binding.priceTxt.text.toString()}",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            FragmentHomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: HomeFragmentAdapter.Holder, position: Int) {
        holder.bind(listData.get(position))
    }

    override fun getItemCount() = listData.size

}
