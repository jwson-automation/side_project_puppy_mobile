package com.example.side_project_puppy_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.side_project_puppy_mobile.databinding.ActivityMainBinding
import com.example.side_project_puppy_mobile.ui.HomeActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth
    lateinit var getResultText: ActivityResultLauncher<Intent>
    val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Auth
        auth = Firebase.auth

        //Google Login
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        val googleSignInClient = GoogleSignIn.getClient(this, gso)

        var getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                Log.d(TAG, "onCreate: 반응했다")
                Log.d(TAG, "initResultReceiver: $it")
                Log.d(TAG, "initResultReceiver: ${it.data}")
                Log.d(TAG, "initResultReceiver: ${it.resultCode}")
                Log.d(TAG, "initResultReceiver: ${it.javaClass}")

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
            getResultText.launch(signInIntent)
        }
    }

}