package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityWelcomeBinding

class WelcomeActivity: AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding

    private var nickname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nickname = getUserNickname(this)

        binding.welcomeNicknameTv1.text = nickname

        binding.welcomeSignupBtn.setOnClickListener {
            startMainAcivity()
        }
    }

    private fun startMainAcivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
        finish()
    }
}