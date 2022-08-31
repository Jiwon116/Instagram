package com.example.instagram

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var userIdx: Int = 0
    private var email: String = ""
    private var password: String = ""
    private var nickname: String = ""
    private var name: String = ""
    private var profileImg: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUserInfo()

        initNavigation()
    }

    private fun getUserInfo() {
        userIdx = getUserIdx(this)
        email = getUserEmail(this)
        password = getUserPassword(this)
        nickname = getUserNickname(this)
        name = getUserName(this)
        profileImg = getUserProfileImg(this)

        Log.i(ContentValues.TAG,"사용자 정보 - 아이디: $userIdx, 이메일: $email, 비번: $password, 사용자이름: $nickname, 이름: $name, 프로필: $profileImg")
    }

    private fun initNavigation() {
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.searchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.reelsFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ReelsFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.likeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LikeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.profileFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

}