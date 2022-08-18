package com.example.instagram

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    /*lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LoginActivity", "onCreate()")

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    binding.loginBeforeBtn.visibility = View.GONE
                    binding.loginAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.loginBeforeBtn.visibility = View.VISIBLE
                    binding.loginAfterBtn.visibility = View.GONE

                    binding.loginBeforeBtn.isClickable = false
                }
            }
        })

        binding.loginPwEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    binding.loginBeforeBtn.visibility = View.GONE
                    binding.loginAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.loginBeforeBtn.visibility = View.VISIBLE
                    binding.loginAfterBtn.visibility = View.GONE

                    binding.loginBeforeBtn.isClickable = false
                }
            }
        })

        binding.loginSignupTv2.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.loginAfterBtn.setOnClickListener {
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
    }*/
}