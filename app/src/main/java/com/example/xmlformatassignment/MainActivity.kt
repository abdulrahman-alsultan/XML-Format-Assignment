package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.InputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain: RecyclerView
    private lateinit var studentsList: ArrayList<Student>
    private lateinit var adapter: StudentNameRVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        studentsList = arrayListOf()

        try {
            val parser = MyXmlPullParser()
            var iStream: InputStream =  applicationContext!!.assets.open("s.xml")
            studentsList = parser.parse(iStream)
            Log.d("studentsList", studentsList.toString())
        }catch (e: Exception){
            Toast.makeText(this, "Error occur: $e", Toast.LENGTH_LONG).show()
            Log.d("Error occur", e.toString())
        }

        adapter = StudentNameRVAdapter(studentsList)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)



    }
}