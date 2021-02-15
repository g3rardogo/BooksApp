package com.books.app.network

import com.books.app.model.Book
import com.books.app.model.Category
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val BOOKS_COLLECTION_NAME ="books"
const val CATEGORY_COLLECTION_NAME = "categories"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getBook(callback: Callback<List<Book>>){
        firebaseFirestore.collection(BOOKS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Book::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getCategories(callback: Callback<List<Category>>){
        firebaseFirestore.collection(CATEGORY_COLLECTION_NAME)
            .orderBy("name")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val listCategories = result.toObjects(Category::class.java)
                    callback.onSuccess(listCategories)
                    break
                }
            }
    }

}