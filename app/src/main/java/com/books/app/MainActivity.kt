package com.books.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.books.app.model.Book
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}