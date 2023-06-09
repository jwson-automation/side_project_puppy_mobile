package com.example.side_project_puppy_mobile.fragment

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.side_project_puppy_mobile.Activity.HomeActivity
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.databinding.FragmentMode1Binding


class Mode1Fragment : Fragment() {
    private lateinit var binding: FragmentMode1Binding
    val TAG = "Mode1Fragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMode1Binding.inflate(inflater,container,false)
        binding.modeCl.setOnClickListener{
            Log.d(TAG, "onCreateView: modeCl click!!")
            val HomeActivityIntent = Intent(activity, HomeActivity::class.java)
            startActivity(HomeActivityIntent)
        }
        return binding.root
    }
}