package com.example.instagram

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM UserTable")
    fun getUsers(): List<User>

    @Query("SELECT * FROM usertable WHERE email = :email")
    fun getUser(email: String): User?

    @Query("SELECT * FROM usertable WHERE nickname = :nickname")
    fun getUserNickname(nickname: String): User?
}