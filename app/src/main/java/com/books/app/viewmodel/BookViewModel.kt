package com.books.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.books.app.model.Book
import com.books.app.network.Callback
import com.books.app.network.FirestoreService
import java.lang.Exception

class BookViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listBook: MutableLiveData<List<Book>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getBookFromFirebase()
    }

    fun getBookFromFirebase(){
        firestoreService.getBook(object: Callback<List<Book>> {
            override fun onSuccess(result: List<Book>?) {
                listBook.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }
}