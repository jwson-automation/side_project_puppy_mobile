package com.example.side_project_puppy_mobile.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.side_project_puppy_mobile.adapter.ModeViewPagerAdapter
import com.example.side_project_puppy_mobile.databinding.ActivityModeBinding
import com.example.side_project_puppy_mobile.dto.ModeData



class ModeActivity : AppCompatActivity() {
    val TAG = "SelectLocationActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = ArrayList<ModeData>()
        list.add(ModeData("cl.png","Current Location"))
        list.add(ModeData("sl.png","Search Location"))


        var binding = ActivityModeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // adapter에 자료 넣어주기, 가로로 바꿔주기
        binding.modeViewpager.adapter = ModeViewPagerAdapter(list)
        binding.modeViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        binding.SearchLocationBtn.setOnClickListener(){
            val HomeActivityIntent = Intent(this, HomeActivity::class.java)
            startActivity(HomeActivityIntent)
        }

        binding.CurrentLocationBtn.setOnClickListener(){
            val HomeActivityIntent = Intent(this, HomeActivity::class.java)
            startActivity(HomeActivityIntent)
        }
    }



//
}