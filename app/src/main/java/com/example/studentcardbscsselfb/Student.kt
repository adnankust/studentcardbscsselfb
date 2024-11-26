package com.example.studentcardbscsselfb

import android.graphics.Picture
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")

data class Student(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val name: String,
    val studentClass: String,
    val Position: Int,
    val picture: Int
)

