package com.example.quanlythuvien.model

class Book(
    private var id: Int,
    private var title: String
) {
    fun getId() = id
    fun getTitle() = title
    fun setTitle(newTitle: String) { title = newTitle }
}