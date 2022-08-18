package com.example.instagram

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivitySignupBinding

class SignUpActivity:AppCompatActivity() {
    /*lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("SignUpActivity", "onCreate()")

        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    binding.signupBeforeBtn.visibility = View.GONE
                    binding.signupAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.signupBeforeBtn.visibility = View.VISIBLE
                    binding.signupAfterBtn.visibility = View.GONE

                    binding.signupBeforeBtn.isClickable = false
                }
            }
        })

        binding.signupNameEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    binding.signupBeforeBtn.visibility = View.GONE
                    binding.signupAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.signupBeforeBtn.visibility = View.VISIBLE
                    binding.signupAfterBtn.visibility = View.GONE

                    binding.signupBeforeBtn.isClickable = false
                }
            }
        })

        binding.signupPwEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    binding.signupBeforeBtn.visibility = View.GONE
                    binding.signupAfterBtn.visibility = View.VISIBLE
                } else {
                    binding.signupBeforeBtn.visibility = View.VISIBLE
                    binding.signupAfterBtn.visibility = View.GONE

                    binding.signupBeforeBtn.isClickable = false
                }
            }
        })

        binding.signupBeforeBtn.setOnClickListener {
            showAlertDialog()
        }

        binding.signupAfterBtn.setOnClickListener {
            if(signUp() == 1) {
                showAlertIdDialog()
            }
            else if(signUp() == 2) {
                showAlertNameDialog()
            } else if(signUp() == 3) {
                showAlertPwDialog()
            }
            else {
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
        } else if (binding.signupNameEt.text.toString().isEmpty()) {
            result = 2
        } else if (binding.signupPwEt.text.toString().isEmpty()) {
            result = 3
        }

        return result
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("정보를 입력해주세요.")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.show()
    }

    private fun showAlertIdDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("ID 형식이 잘못되었습니다.\n확인해주세요.")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.show()
    }

    private fun showAlertNameDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("성명 형식이 잘못되었습니다.\n확인해주세요.")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })
        builder.show()
    }

    private fun showAlertPwDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("회원가입 오류")
            .setMessage("비밀번호 형식이 잘못되었습니다.\n확인해주세요.")
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

        saveUser()
    }

    override fun onStop() {
        Log.d("SignUpActivity", "onStop()")
        super.onStop()
        // 정보 저장은 여기서
    }

    override fun onDestroy() {
        Log.d("SignUpActivity", "onDestroy()")
        super.onDestroy()
    }*/
}