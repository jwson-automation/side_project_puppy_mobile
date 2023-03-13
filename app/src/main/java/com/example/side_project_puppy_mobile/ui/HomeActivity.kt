package com.example.side_project_puppy_mobile.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.databinding.ActivityHomeBinding
import com.example.side_project_puppy_mobile.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener(){
            Toast.makeText(this,"뒤로가기", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


}