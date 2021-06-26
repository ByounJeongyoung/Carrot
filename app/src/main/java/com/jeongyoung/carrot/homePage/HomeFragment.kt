package com.jeongyoung.carrot.homePage

import android.content.res.ColorStateList
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
import com.jeongyoung.carrot.MainActivity
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.arround.RecommendIconAdapter
import com.jeongyoung.carrot.arround.RecommendWordAdapter
import com.jeongyoung.carrot.databinding.FragmentArroundBinding
import com.jeongyoung.carrot.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var  mainActivity: MainActivity
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
    private val appBarOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            context, R.anim.app_bar_open
        )
    }
        private val appBarClose: Animation by lazy{
            AnimationUtils.loadAnimation(
                context,R.anim.app_bar_close
            )
        }

    private var clicked = false
    private var clickedBar = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //RecyclerView Model in Home Fragment
        val content = "운동화 팝니다 얼마 신지 않았어요 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ 직거래 가능합니다 패션의 트렌드!!나이키 운동화와 함께 하세요 운동화 팝니다 얼마 신지 않았어요 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ 직거래 가능합니다 패션의 트렌드!!나이키 운동화와 함께 하세요"
        //Model List
        model = mutableListOf()
        model.apply {
            add(MerchandiseModel(R.drawable.home_pic_11,"당근모먼툰 1화|혹시...\n꼬꼬맘이세요...?","당근마켓","",content))
            add(MerchandiseModel(R.drawable.home_pic_12,"제이컬렉션 반바지 하늘색\n프리사이즈","오산동 · 끌올 30초전","5,000원",content))
            add(MerchandiseModel(R.drawable.home_pic_13,"아담한 통나무 테이블","청계동 · 55초전","20,000원",content))
            add(MerchandiseModel(R.drawable.home_pic_7,"혼공파 파이썬 책 팔아요~~","영천동","비전공자 무료",content))
            add(MerchandiseModel(R.drawable.home_pic_9,"나이키 운동화","오산동 · 끌올 59초전","37,000",content))
            add(MerchandiseModel(R.drawable.home_pic_13,"아담한 통나무 테이블","청계동 · 55초전","20,000원",content))
            add(MerchandiseModel(R.drawable.home_pic_2,"스피커","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_2,"스피커","영천동","90,000"))
            add(MerchandiseModel(R.drawable.home_pic_2,"스피커","영천동","90,000"))
        }

        val homeFragmentAdapter =HomeFragmentAdapter()
        //Connect model list with Adapter's model list
        homeFragmentAdapter.listData = model

        //Connect recyclerview
        binding.homeRecycler.apply {
           adapter = homeFragmentAdapter
           layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL, false)
        }


        binding.apply {
            //AppBar click Listeners
            spinnerBtn.setOnClickListener { setAppbarRotate() }

            locationName.setOnClickListener {setAppbarRotate()  }

            searchBtn.setOnClickListener{ Toast.makeText(context,"Clicked Search",Toast.LENGTH_SHORT).show()}

            menuBtn.setOnClickListener{  Toast.makeText(context,"Clicked MenuBtn",Toast.LENGTH_SHORT).show()}

            notificationBtn.setOnClickListener{ Toast.makeText(context,"Clicked NoticeButton",Toast.LENGTH_SHORT).show()}

            //Floating Action Button
            plusButton.setOnClickListener{ onAddButtonClicked() }

        }
        return binding.root
    }


    private fun setAppbarRotate() {

        if(!clickedBar){
            binding.spinnerBtn.startAnimation(appBarOpen)
            }else{
               binding.spinnerBtn.startAnimation(appBarClose)
            }

    clickedBar = !clickedBar
    }


    //Clicked floating Action Button
    //Visibility(Icon,Text) ,Animation ,Color

    private fun onAddButtonClicked() {
        //Visible
        //clicked  == Select or Not
        setVisibility(clicked)
        setText(clicked)
        setAnimation(clicked)
        setButtonColor(clicked)
        setBackgroundColor(clicked)
        clicked = !clicked
    }

    private fun setButtonColor(clicked: Boolean) {
        if(!clicked){
            // FloatingActionBtn tint 변경
            binding.apply {
                plusButton.apply {
                    backgroundTintList = ColorStateList.valueOf(Color.DKGRAY)



                }
                plusButton.setImageResource(R.drawable.ic_add_after)
            }
        }else{
            binding.apply {
                plusButton.apply {
                    backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FF7F00"))
                    setRippleColor(Color.BLUE)

                }
            }
        }

    }

    private fun setBackgroundColor(clicked: Boolean) {
      if(!clicked) {
       binding.backgroundColor.setBackgroundColor(Color.parseColor("#7A070606"))
      }else{
          binding.backgroundColor.setBackgroundColor(Color.parseColor("#00000000"))
      }

    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.apply {
                addButton.visibility = View.VISIBLE
                noticeButton.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                addButton.visibility = View.INVISIBLE
                noticeButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun setText(clicked: Boolean) {
        if (!clicked) {
            binding.apply {
                addText.visibility = View.VISIBLE
                noticeText.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                addText.visibility = View.INVISIBLE
                noticeText.visibility = View.INVISIBLE
            }
        }

    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.apply {
                addButton.startAnimation(appear)
                noticeButton.startAnimation(appear)
                plusButton.apply {

                    startAnimation(rotateOpen)
                    setBackgroundColor(Color.WHITE)

                }
            }
        } else {
            binding.apply {
                addButton.startAnimation(disappear)
                noticeButton.startAnimation(disappear)
                plusButton.startAnimation(rotateClose)
            }
        }
    }

}