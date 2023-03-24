package com.example.side_project_puppy_mobile.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.dto.ModeData
import com.example.side_project_puppy_mobile.fragment.Mode1Fragment
import com.example.side_project_puppy_mobile.fragment.Mode2Fragment

class ModeViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    var TAG = "ModeViewPagerAdapter"
    val fragmentList = listOf<Fragment>(Mode1Fragment(),Mode2Fragment())

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}