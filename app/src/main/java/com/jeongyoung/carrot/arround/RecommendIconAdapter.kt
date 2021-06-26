package com.jeongyoung.carrot.arround

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.jeongyoung.carrot.DetailActivity
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.databinding.FragmentArroundIconListBinding
import kotlin.coroutines.coroutineContext


class RecommendIconAdapter : RecyclerView.Adapter<RecommendIconAdapter.Holder>() {
    val listData = arrayListOf<Int>(
        R.drawable.icon_1,
        R.drawable.icon_2,
        R.drawable.icon_3,
        R.drawable.icon_4,
        R.drawable.icon_5,
        R.drawable.icon_7,
        R.drawable.icon_8,
        R.drawable.icon_9,
        R.drawable.icon_10,
        R.drawable.icon_11,
        R.drawable.icon_12,
    )

     inner class Holder(val binding: FragmentArroundIconListBinding) :
        RecyclerView.ViewHolder(binding.root){
            init {
                binding.root.setOnClickListener{

                    Toast.makeText(binding.root.context,"아이콘을 클릭 하셨습니다",Toast.LENGTH_SHORT).show()
                }
            }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder { val binding = FragmentArroundIconListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecommendIconAdapter.Holder, position: Int) {
        holder.binding.recommendIcon.setImageResource(listData[position])

    }

    override fun getItemCount() = listData.size

}
