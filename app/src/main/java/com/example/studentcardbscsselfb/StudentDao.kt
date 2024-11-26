package com.example.studentcardbscsselfb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM students")
    suspend fun getAllStudents(): List<Student>

}