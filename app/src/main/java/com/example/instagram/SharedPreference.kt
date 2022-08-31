package com.example.instagram

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

fun saveUserIdx(context: Context, userIdx: Int) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putInt("userIdx", userIdx)
    editor.apply()
}

fun getUserIdx(context: Context): Int {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getInt("userIdx", 0)
}

fun saveUserEmail(context: Context, email: String) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userEmail", email)
    editor.apply()
}

fun getUserEmail(context: Context): String {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userEmail", "")!!
}

fun saveUserPassword(context: Context, password: String) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userPassword", password)
    editor.apply()
}

fun getUserPassword(context: Context): String {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userPassword", "")!!
}

fun saveUserNickname(context: Context, nickname: String) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userNickname", nickname)
    editor.apply()
}

fun getUserNickname(context: Context): String {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userNickname", "")!!
}

fun saveUserName(context: Context, name: String) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userName", name)
    editor.apply()
}

fun getUserName(context: Context): String {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userName", "")!!
}

fun saveUserProfileImg(context: Context, profileImg: String) {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)
    val editor = spf.edit()

    editor.putString("userProfileImg", profileImg)
    editor.apply()
}

fun getUserProfileImg(context: Context): String {
    val spf = context.getSharedPreferences("auth", AppCompatActivity.MODE_PRIVATE)

    return spf.getString("userProfileImg", "")!!
}