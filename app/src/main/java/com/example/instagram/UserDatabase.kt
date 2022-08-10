package com.example.instagram

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao

    companion object {
        private var instance:UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if(instance == null) {
                synchronized(UserDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database" // 다른 데이터베이스랑 이름겹치면 꼬이기 때문
                    ).allowMainThreadQueries().build() // 워크스레드가 아닌 메인스레드에 맡겨줌
                }
            }
            return instance
        }
    }
}