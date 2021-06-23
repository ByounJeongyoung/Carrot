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
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var fragmentHomeBinding: FragmentHomeBinding? = null



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
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding


        binding.plusButton.setOnClickListener {
            onAddButtonClicked()
        }

        binding.searchBtn.setOnClickListener {
            Toast.makeText(context,"Clicked Search",Toast.LENGTH_SHORT).show()
        }

        binding.menuBtn.setOnClickListener {
            Toast.makeText(context,"Clicked MenuBtn",Toast.LENGTH_SHORT).show()
        }
        binding.notificationBtn.setOnClickListener {
            Toast.makeText(context,"Clicked NoticeButton",Toast.LENGTH_SHORT).show()
        }






        return fragmentHomeBinding!!.root

    }


    override fun onDestroyView() {
        super.onDestroyView()

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setText(clicked)
        setBackgroundColor(clicked)
        clicked = !clicked
    }

    private fun setBackgroundColor(clicked: Boolean) {

    }


    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            fragmentHomeBinding!!.apply {
                addButton.visibility = View.VISIBLE
                noticeButton.visibility = View.VISIBLE
            }
        } else {
            fragmentHomeBinding!!.apply {
                addButton.visibility = View.INVISIBLE
                noticeButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            fragmentHomeBinding!!.apply {
                addButton.startAnimation(appear)
                noticeButton.startAnimation(appear)
                plusButton.apply {

                    startAnimation(rotateOpen)
                    setBackgroundColor(Color.WHITE)

                }
            }
        } else {
            fragmentHomeBinding!!.apply {
                addButton.startAnimation(disappear)
                noticeButton.startAnimation(disappear)
                plusButton.startAnimation(rotateClose)
            }
        }
    }

    private fun setText(clicked: Boolean) {
        if (!clicked) {
            fragmentHomeBinding!!.apply {
                addText.visibility = View.VISIBLE
                noticeText.visibility = View.VISIBLE
            }
        } else {
            fragmentHomeBinding!!.apply {
                addText.visibility = View.INVISIBLE
                noticeText.visibility = View.INVISIBLE
            }
        }

    }
}