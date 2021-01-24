package com.books.app.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.books.app.R
import com.books.app.model.Book
import com.bumptech.glide.Glide

class BookAdapter(val bookListener: BookListener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var lisBook= ArrayList<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) {
        val book = lisBook[position] as Book
        holder.tvBookName.text = book.title
        holder.tvBookAutor.text = book.author
        holder.tvBookPrice.text = book.price
        holder.tvBookCategory.text = book.category
        Glide.with(holder.itemView.context)
                .load(book.image)
                .into(holder.ivBookImage)

        holder.itemView.setOnClickListener{
            bookListener.onBookClicked(book, position)
        }

    }

    fun updateData(data: List<Book>){
        lisBook.clear()
        lisBook.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = lisBook.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvBookName = itemView.findViewById<TextView>(R.id.tvBookName)
        val tvBookAutor = itemView.findViewById<TextView>(R.id.tvBookAutor)
        val tvBookPrice = itemView.findViewById<TextView>(R.id.tvBookPrice)
        val tvBookCategory = itemView.findViewById<TextView>(R.id.tvBookCategory)
        val ivBookImage = itemView.findViewById<ImageView>(R.id.ivBookImage)
    }
}