package com.jeongyoung.carrot.arround

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeongyoung.carrot.databinding.FragmentArroundBinding


class ArroundFragment : Fragment() {

    private lateinit var binding: FragmentArroundBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         binding = FragmentArroundBinding.inflate(inflater, container, false)


        val recommendWordAdapter = RecommendWordAdapter()
        val recommendIconAdapter = RecommendIconAdapter()
        binding.apply {
            recyclerWord.adapter = recommendWordAdapter
            recyclerWord.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            recyclerGridIcon.adapter = recommendIconAdapter
            recyclerGridIcon.layoutManager = GridLayoutManager(context,4)
        }

        return binding.root
    }
}