package com.example.side_project_puppy_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.side_project_puppy_mobile.databinding.ActivityMainBinding
import com.example.side_project_puppy_mobile.databinding.ActivitySelectLocationBinding
import com.example.side_project_puppy_mobile.ui.HomeActivity

class SelectLocationActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_select_location)

        var binding = ActivitySelectLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

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