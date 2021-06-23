package com.jeongyoung.carrot.arround

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeongyoung.carrot.databinding.FragmentArroundRecommendListBinding


class RecommendWordAdapter : RecyclerView.Adapter<RecommendWordAdapter.recommendHolder>() {
    val listData = arrayListOf<String>(
        "중국어","헬스장","이사","피부관리","중국어","헬스장","이사","피부관리")

    inner class recommendHolder(val binding: FragmentArroundRecommendListBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun setMemo(word: String) {
            binding.word.text = word
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): recommendHolder {
        val binding = FragmentArroundRecommendListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return recommendHolder((binding))
    }

    override fun onBindViewHolder(holder: recommendHolder, position: Int) {
        val word = listData.get(position)
        holder.setMemo(word)
    }

    override fun getItemCount() = listData.size

}