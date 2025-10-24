package com.example.quanlythuvien.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.quanlythuvien.model.Book
import com.example.quanlythuvien.model.LibraryManager
import com.example.quanlythuvien.model.Student

class LibraryViewModel : ViewModel() {

    private val manager = LibraryManager()

    var students = mutableStateListOf<Student>()
        private set

    var books = mutableStateListOf<Book>()
        private set

    init {
        // Dummy data
        val s1 = Student(1, "Nguyen Van A")
        val s2 = Student(2, "Tran Thi B")
        manager.addStudent(s1)
        manager.addStudent(s2)
        students.addAll(manager.getAllStudents())

        val b1 = Book(1, "Sách 01")
        val b2 = Book(2, "Sách 02")
        manager.addBook(b1)
        manager.addBook(b2)
        books.addAll(manager.getAllBooks())
    }

    fun addBook(title: String) {
        val book = Book(books.size + 1, title)
        manager.addBook(book)
        books.add(book)
    }

    fun addStudent(name: String){
        val student = Student(books.size + 1, name)
        manager.addStudent(student)
        students.add(student)
    }

    fun borrowBook(student: Student, book: Book) {
        manager.borrowBook(student, book)
    }

    fun removeBook(book: Book) {
        manager.removeBook(book)
        books.remove(book)
    }

    fun removeStudent(student: Student){
        manager.removeStudent(student)
        students.remove(student)
    }

    fun getBooksBorrowed(student: Student): List<Book> {
        return manager.getBooksBorrowed(student)
    }




}