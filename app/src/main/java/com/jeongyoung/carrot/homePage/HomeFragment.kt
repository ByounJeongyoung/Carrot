package com.jeongyoung.carrot.homePage

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.arround.RecommendIconAdapter
import com.jeongyoung.carrot.arround.RecommendWordAdapter
import com.jeongyoung.carrot.databinding.FragmentArroundBinding
import com.jeongyoung.carrot.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var model : MutableList<MerchandiseModel>
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.rotate_close_anim
        )
    }
    private val appear: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.appear_anim
        )
    }
    private val disappear: Animation by lazy {
        AnimationUtils.loadAnimation(
            context,
            R.anim.disappear_anim
        )
    }
    private var clicked = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        model = mutableListOf()
        model.apply {
            add(MerchandiseModel(R.drawable.home_pic_1,"홍익 돈까스(점심할인)","1초 전","7,000"))
            add(MerchandiseModel(R.drawable.home_pic_2,"회","22222초","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_3,"아이폰","33초","10,000"))
            add(MerchandiseModel(R.drawable.home_pic_4,"스피커","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_5,"트레비","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_6,"트레비","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_7,"트레비","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_8,"트레비","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_9,"트레비","영천동","90,000"))
        }

        val homeFragmentAdapter =HomeFragmentAdapter()
        homeFragmentAdapter.listData = model

        binding.homeRecycler.apply {
           adapter = homeFragmentAdapter
           layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL, false)
        }

        // AppBar click Listeners
        binding.apply {

            plusButton.setOnClickListener{ onAddButtonClicked() }

            searchBtn.setOnClickListener{ Toast.makeText(context,"Clicked Search",Toast.LENGTH_SHORT).show()}

            menuBtn.setOnClickListener{  Toast.makeText(context,"Clicked MenuBtn",Toast.LENGTH_SHORT).show()}

            notificationBtn.setOnClickListener{ Toast.makeText(context,"Clicked NoticeButton",Toast.LENGTH_SHORT).show()}
        }
        return binding.root
    }

    //Clicked floating Action Button
    //Visibility(Icon,Text) ,Animation ,Color

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setText(clicked)
        setAnimation(clicked)
        setBackgroundColor(clicked)
        clicked = !clicked
    }

    private fun setBackgroundColor(clicked: Boolean) {

    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding!!.apply {
                addButton.visibility = View.VISIBLE
                noticeButton.visibility = View.VISIBLE
            }
        } else {
            binding!!.apply {
                addButton.visibility = View.INVISIBLE
                noticeButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun setText(clicked: Boolean) {
        if (!clicked) {
            binding!!.apply {
                addText.visibility = View.VISIBLE
                noticeText.visibility = View.VISIBLE
            }
        } else {
            binding!!.apply {
                addText.visibility = View.INVISIBLE
                noticeText.visibility = View.INVISIBLE
            }
        }

    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding!!.apply {
                addButton.startAnimation(appear)
                noticeButton.startAnimation(appear)
                plusButton.apply {

                    startAnimation(rotateOpen)
                    setBackgroundColor(Color.WHITE)

                }
            }
        } else {
            binding!!.apply {
                addButton.startAnimation(disappear)
                noticeButton.startAnimation(disappear)
                plusButton.startAnimation(rotateClose)
            }
        }
    }

}