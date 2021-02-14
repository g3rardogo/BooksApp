package com.books.app.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.books.app.R
import com.books.app.view.ui.fragments.BooksFragment
import com.books.app.view.ui.fragments.CategoriesMenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}