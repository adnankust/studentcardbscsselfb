package com.example.studentcardbscsselfb

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val database = AppDatabase.getDatabase(this)
        val studentDao = database.studentDao()

        CoroutineScope(Dispatchers.IO).launch {

            //Insert sample data if the database is empty

            if(studentDao.getAllStudents().isEmpty()) {
                studentDao.insertStudent(Student(20, "Adnan", "7th Class", 1, R.drawable.adnan1))
                studentDao.insertStudent(Student(21, "Shahid", "5th Class", 2, R.drawable.shahid))
                studentDao.insertStudent(Student(22, "Adam", "5th Class", 4, R.drawable.guy1))
            }

            val students = studentDao.getAllStudents()

            withContext(Dispatchers.Main) {
                adapter = StudentAdapter(students)
                recyclerView.adapter = adapter
            }

        }
    }
}