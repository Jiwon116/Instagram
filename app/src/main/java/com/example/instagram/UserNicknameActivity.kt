package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityUsernicknameBinding

class UserNicknameActivity:AppCompatActivity() {
    lateinit var binding: ActivityUsernicknameBinding

    private var userIdx: Int = 0
    private var email: String = ""
    private var nickname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsernicknameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = getUserEmail(this)

        binding.userinfoNicknameEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length >= 2) {
                    binding.userinfoNicknameBtn.visibility = View.GONE
                    binding.userinfoNicknameAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.userinfoNicknameBtn.visibility = View.VISIBLE
                    binding.userinfoNicknameAfterBtn.visibility = View.GONE

                    binding.userinfoNicknameBtn.isClickable = false
                }
            }
        })

        binding.userinfoNicknameAfterBtn.setOnClickListener {
            getUserNickname()
            startUserPwdActivity()
        }
    }

    private fun getUserNickname() {
        nickname = binding.userinfoNicknameEt.text.toString()
        saveUserNickname(this, nickname)

        val userDB = UserDatabase.getInstance(this)!!
        val user = userDB.UserDao().getUser(email)

        user?.let{
            saveUserIdx(this, user.id)
        }
    }

    private fun startUserPwdActivity() {
        val intent = Intent(this, UserPasswordActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
        finish()
    }
}