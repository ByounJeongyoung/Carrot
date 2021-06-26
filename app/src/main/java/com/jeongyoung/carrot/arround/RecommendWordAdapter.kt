package com.jeongyoung.carrot.arround

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.jeongyoung.carrot.DetailActivity
import com.jeongyoung.carrot.MainActivity
import com.jeongyoung.carrot.databinding.FragmentArroundRecommendListBinding
import kotlin.coroutines.coroutineContext


class RecommendWordAdapter : RecyclerView.Adapter<RecommendWordAdapter.recommendHolder>() {
    val listData = arrayListOf<String>(
        "베이킹","중고폰","휴대폰","카페","세차","알바","코딩공부","피부관리","컴공선배","안드로이드","아이폰")

    inner class recommendHolder(val binding: FragmentArroundRecommendListBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun setMemo(word: String) {

            binding.word.text = word
        }
        init {
            binding.root.setOnClickListener{

                Toast.makeText(binding.root.context,binding.word.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(

        parent: ViewGroup,
        viewType: Int
    ): recommendHolder {
        val binding = FragmentArroundRecommendListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return recommendHolder((binding))
    }

    override fun onBindViewHolder(holder: RecommendWordAdapter.recommendHolder, position: Int) {
        val word = listData.get(position)
        holder.setMemo(word)
    }

    override fun getItemCount() = listData.size

}
