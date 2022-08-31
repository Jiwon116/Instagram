package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityUserpasswordBinding

class UserPasswordActivity: AppCompatActivity() {
    lateinit var binding: ActivityUserpasswordBinding

    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userinfoPasswordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length >= 6) {
                    binding.userinfoPasswordBtn.visibility = View.GONE
                    binding.userinfoPasswordAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.userinfoPasswordBtn.visibility = View.VISIBLE
                    binding.userinfoPasswordAfterBtn.visibility = View.GONE

                    binding.userinfoPasswordBtn.isClickable = false
                }
            }
        })

        binding.userinfoPasswordAfterBtn.setOnClickListener {
            saveUser()
            startWelcomeActivity()
        }
    }

    private fun saveUser() {
        password = binding.userinfoPasswordEt.text.toString()

        saveUserPassword(this, password)
    }

    private fun startWelcomeActivity() {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
        finish()
    }
}