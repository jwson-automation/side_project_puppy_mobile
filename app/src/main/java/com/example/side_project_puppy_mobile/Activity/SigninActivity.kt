package com.example.side_project_puppy_mobile.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.side_project_puppy_mobile.R

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    //sign-in
    //혹시 이미 회원가입된 정보가 DB에 있다면, 로그인 페이지로 연결하고,
    //아직 회원가입된 아이디가 없다면, 회원가입 페이지로 연결 --> 닉네임과, 주소, 등을 결정할 수 있도록 한다.

}