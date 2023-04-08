package com.example.side_project_puppy_mobile.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.side_project_puppy_mobile.DB.TmpDB
import com.example.side_project_puppy_mobile.adapter.RecyclerTrailAdapter
import com.example.side_project_puppy_mobile.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RecyclerTrailAdapter(TmpDB.TrailList2)

        binding.selectLocation.adapter = adapter

        binding.button.setOnClickListener(){
            Toast.makeText(this,"뒤로가기", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}