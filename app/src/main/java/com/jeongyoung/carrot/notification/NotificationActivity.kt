package com.jeongyoung.carrot.notification

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongyoung.carrot.R
import com.jeongyoung.carrot.databinding.ActivityMainBinding
import com.jeongyoung.carrot.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    private lateinit var activeTab: ActiveFragment
    private lateinit var keywordTab: KeyWordFragment

    private val tabTextList = arrayListOf("Chat", "Calls","Wallet","Market","Tab","Etc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activeTab = ActiveFragment()
        keywordTab = KeyWordFragment()

        binding.back.setOnClickListener {
            finish()
        }
        pager()
    }
    private fun pager() {
        binding.viewPager2.adapter = CustomFragmentStateAdapter(this)
        TabLayoutMediator(binding.tabLayout,binding.viewPager2) {
                tab, position ->
                tab.text = tabTextList[position]

        }.attach()
    }
}