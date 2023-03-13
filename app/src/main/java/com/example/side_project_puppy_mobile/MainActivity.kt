package com.example.side_project_puppy_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.side_project_puppy_mobile.databinding.ActivityMainBinding
import com.example.side_project_puppy_mobile.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.GoogleLoginButton.setOnClickListener(){
            Toast.makeText(this,"구글 로그인", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

}