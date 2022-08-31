package com.example.instagram

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import com.kakao.sdk.user.UserApiClient
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    var email = String
    var nickname = String

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LoginActivity", "onCreate()")

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.isNotEmpty()) {
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
                if (editable.isNotEmpty()) {
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

        // 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Log.d(TAG, "로그인 필요")
            }
            else if (tokenInfo != null) {
                // 카카오 로그인이 이미 되어있으면
                Log.d(TAG, "로그인 유지")
                startMainActivity()
            }
        }

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {    // 로그인 할 때 발생하는 에러
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱에 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                // 로그인에 성공하면
                Log.d(TAG, "카카오톡 계정 연결 성공")

                startMainActivity()
            }
        }

        binding.loginKakaoIv.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)

            }else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
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
        finish()
    }
}