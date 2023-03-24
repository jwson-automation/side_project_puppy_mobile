package com.example.side_project_puppy_mobile.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.side_project_puppy_mobile.Activity.CardActivity
import com.example.side_project_puppy_mobile.Activity.HomeActivity
import com.example.side_project_puppy_mobile.R
import com.example.side_project_puppy_mobile.databinding.FragmentMode1Binding
import com.example.side_project_puppy_mobile.databinding.FragmentMode2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Mode2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mode2Fragment : Fragment() {
    val TAG = "Mode2Fragment"
    private lateinit var binding: FragmentMode2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMode2Binding.inflate(inflater,container,false)
        binding.modeSl.setOnClickListener{
            Log.d(TAG, "onCreateView: modeSl click!!")
            val HomeActivityIntent = Intent(activity, CardActivity::class.java)
            startActivity(HomeActivityIntent)
        }
        return binding.root
    }
}