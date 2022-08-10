package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LoginActivity", "onCreate()")

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignupTv2.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            // 새로운 Activity(SignUp)에 가려지지만 백그라운드에서 돌아감
            onPause()
        }

        binding.loginBtn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if(binding.loginIdEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        if(binding.loginPwEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        val email: String = binding.loginIdEt.text.toString()
        val pwd: String = binding.loginPwEt.text.toString()

        val userDB = UserDatabase.getInstance(this)!!
        val user = userDB.UserDao().getUser(email, pwd)
        user?.let{
            Log.d("LOGINACT/GET_USER", "userId: ${user.id}, $user")
            saveUserIdx(this, user.id)
            startMainActivity()
        }
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
    }

    override fun onStart() {
        Log.d("LoginActivity", "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LoginActivity", "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LoginActivity", "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LoginActivity", "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("LoginActivity", "onDestroy()")
        super.onDestroy()
    }
}