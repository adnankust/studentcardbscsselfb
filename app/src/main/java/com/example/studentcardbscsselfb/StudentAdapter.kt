package com.example.studentcardbscsselfb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val studentName: TextView = view.findViewById(R.id.student_name)
        val studentClass: TextView = view.findViewById(R.id.student_class)
        val studentPosition: TextView = view.findViewById(R.id.student_position)
        val studentPicture: ImageView = view.findViewById(R.id.student_picture)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = student.name
        holder.studentClass.text = "Class: ${student.studentClass}"
        holder.studentPosition.text = "Position: ${student.Position}"
        //Load image using Glide or other library
        Glide.with(holder.itemView.context)
            .load(student.picture)
            .into(holder.studentPicture)



    }

    override fun getItemCount(): Int {
        return students.size
    }


}
