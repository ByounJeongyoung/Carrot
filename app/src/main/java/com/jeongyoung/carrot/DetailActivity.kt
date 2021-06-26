package com.jeongyoung.carrot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jeongyoung.carrot.databinding.ActivityDetailBinding
import com.jeongyoung.carrot.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var mainActivity: MainActivity
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivity = MainActivity()

        val img = intent.getIntExtra("img",0)
        val title = intent.getStringExtra("title")
        val time = intent.getStringExtra("time")
        val content = intent.getStringExtra("content")

        binding.apply {
            detailImg.setImageResource(img)
            detailTitle.text = title.toString()
            timeTxt.text = time.toString()
            contentTxt.text = content.toString()
        }

    }
}