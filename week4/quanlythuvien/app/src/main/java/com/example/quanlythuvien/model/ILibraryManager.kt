package com.example.quanlythuvien.model

interface ILibraryManager {
    fun addBook(book: Book)
    fun removeBook(book: Book)
    fun addStudent(student: Student)
    fun removeStudent(student: Student)
    fun borrowBook(student: Student, book: Book)
    fun getBooksBorrowed(student: Student): List<Book>
}