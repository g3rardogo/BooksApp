package com.books.app.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.books.app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}