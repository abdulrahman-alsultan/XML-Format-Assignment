package com.example.xmlformatassignment

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParser {
    private val studentsDetails = ArrayList<Student>()
    private var text: String? = null
    private var studentId = 0
    private var studentName = ""
    private var studentMark = 0F

    fun parse(inputStream: InputStream): ArrayList<Student> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("name", ignoreCase = true) -> {
                            studentName = text.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            studentMark = text!!.toFloat()
                            studentsDetails.add(Student(studentName, studentMark))
                        }
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
            Log.d("errorrrr XmlPullP", e.toString())
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("errorrrr IOException", e.toString())
        }
        return studentsDetails
    }
}