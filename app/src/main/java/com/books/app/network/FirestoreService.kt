package com.books.app.network
import com.books.app.model.Book
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val BOOKS_COLLECTION_NAME ="books"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings =FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()
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
}