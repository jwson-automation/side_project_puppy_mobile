package com.example.side_project_puppy_mobile.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.side_project_puppy_mobile.adapter.RecyclerTrailAdapter

import com.example.side_project_puppy_mobile.databinding.ActivityHomeBinding
import com.example.side_project_puppy_mobile.dto.TrailData

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<TrailData>()
        list.add(TrailData("두류공원","대구광역시","달서구 두류공원로49길"))
        list.add(TrailData("포켓몬공원2","대구광역시","달서구 두류공원로49길"))
        list.add(TrailData("공원3","대구광역시","달서구 두류공원로50길"))
        list.add(TrailData("슈퍼마켓공원3","대구광역시","달서구 두류공원로50길"))
        list.add(TrailData("센트럴파크공원3","대구광역시","달서구 두류공원로50길"))
        list.add(TrailData("코끼리공원3","대구광역시","달서구 두류공원로50길"))

        val adapter = RecyclerTrailAdapter(list)

        binding.selectLocation.adapter = adapter

        binding.button.setOnClickListener(){
            Toast.makeText(this,"뒤로가기", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}