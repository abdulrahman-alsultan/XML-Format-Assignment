package com.example.xmlformatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_details_item_row.view.*

class StudentNameRVAdapter(private val studentDetails: ArrayList<Student>): RecyclerView.Adapter<StudentNameRVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_details_item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = studentDetails[position]

        holder.itemView.apply {
            RV_tv_student_name.text = "Name: ${student.name}"
            RV_tv_student_mark.text = "Mark: ${student.mark}"

        }
    }

    override fun getItemCount(): Int = studentDetails.size
}