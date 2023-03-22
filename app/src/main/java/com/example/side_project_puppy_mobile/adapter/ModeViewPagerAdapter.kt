package com.example.side_project_puppy_mobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.dto.ModeData

class ModeViewPagerAdapter(modeList: ArrayList<ModeData>) : RecyclerView.Adapter<ModeViewPagerAdapter.PagerViewHolder>() {
    var TAG = "ModeViewPagerAdapter"
    var item = modeList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        if (position == 0){
            holder.modes.setImageResource(R.drawable.cl)}
        else{
            holder.modes.setImageResource(R.drawable.sl)}

    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.mode_item, parent, false)){

        val modes = itemView.findViewById<ImageView>(R.id.mode_img)
    }
}