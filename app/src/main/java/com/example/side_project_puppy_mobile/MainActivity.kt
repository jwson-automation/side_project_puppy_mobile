package com.example.side_project_puppy_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.side_project_puppy_mobile.databinding.ActivityMainBinding
import com.example.side_project_puppy_mobile.ui.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding


    val RC_SIGN_IN = 9001
    var firebaseAuth = FirebaseAuth.getInstance()
    var googleSignInClient : GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Google Login
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(this, gso)

        var getLoginResponse =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                Log.d(TAG, "resultCode: ${it.resultCode}")

                if (it.resultCode == RESULT_OK) {
                    Log.d(TAG, "onCreate: 로그인성공!")

                    val homeIntet = Intent(this, HomeActivity::class.java)
                    startActivity(homeIntet)
                }else{
                    Log.d(TAG, "onCreate: 로그인실패!")
                    Toast.makeText(this,"구글 로그인이 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }

        binding.GoogleLoginButton.setOnClickListener() {
            val signInIntent = googleSignInClient.signInIntent
            getLoginResponse.launch(signInIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}