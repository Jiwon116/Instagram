package com.example.instagram

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(
    var email: String,
    var password: String,
    var nickname: String,
    var name: String,
    var profileImg: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}