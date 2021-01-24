package com.books.app.view.adapter

import com.books.app.model.Book

interface BookListener {
    fun onBookClicked(book: Book, position: Int){

    }
}