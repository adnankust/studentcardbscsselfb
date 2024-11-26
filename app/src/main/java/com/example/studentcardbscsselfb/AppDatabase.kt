package com.example.studentcardbscsselfb

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1)


abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: android.content.Context): AppDatabase {
           return INSTANCE ?: synchronized(this) {
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                       AppDatabase::class.java,
                       "student_database"
                       ).build()
                   INSTANCE = instance
                   instance

           }
        }
    }
}