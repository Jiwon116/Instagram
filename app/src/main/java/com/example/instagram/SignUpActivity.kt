package com.example.instagram

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivitySignupBinding

class SignUpActivity:AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("SignUpActivity", "onCreate()")

        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupBtn.setOnClickListener {
            if(signUp() == 1) {
                onPause()
                showAlertIdDialog()
            }
            else if(signUp() == 2) {
                onPause()
                showAlertPwDialog()
            }
            else {
                saveUser()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun getUser(): User {
        val email: String = binding.signupIdEt.text.toString()
        val pwd: String = binding.signupPwEt.text.toString()
        val name: String = binding.signupNameEt.text.toString()

        return User(email, pwd, name)
    }

    private fun signUp(): Int {
        var result: Int = 0
        if(binding.signupIdEt.text.toString().isEmpty()) {
            result = 1
        } else if (binding.signupPwEt.text.toString().isEmpty()) {
            result = 2
        }

        return result
    }

    private fun showAlertIdDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("이메일 형식이 잘못되었습니다.")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.show()
    }

    private fun showAlertPwDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("비밀번호 형식이 잘못되었습니다.")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.show()
    }

    private fun saveUser() {
        val userDB = UserDatabase.getInstance(this)!!
        userDB.UserDao().insert(getUser())
        val users = userDB.UserDao().getUsers()
        Log.d("User Info", users.toString())
    }

    override fun onStart() {
        Log.d("SignUpActivity", "onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.d("SignUpActivity", "onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("SignUpActivity", "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d("SignUpActivity", "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("SignUpActivity", "onDestroy()")
        super.onDestroy()
    }
}