package com.example.quanlythuvien.model

class LibraryManager : ILibraryManager {

    private val students = mutableListOf<Student>()
    private val books = mutableListOf<Book>()
    private val borrowed = mutableMapOf<Int, MutableList<Book>>() // studentId -> list Books

    override fun addBook(book: Book) {
        books.add(book)
    }

    override fun removeBook(book: Book) {
        books.remove(book)
    }

    override fun addStudent(student: Student) {
        students.add(student)
//        borrowed.putIfAbsent(student.getId(), mutableListOf())
    }

    override fun removeStudent(student: Student) {
        students.remove(student)
    }

    override fun borrowBook(student: Student, book: Book) {
        val list = borrowed.getOrPut(student.getDisplayId()) { mutableListOf() }
        if (!list.contains(book)) list.add(book)
    }

    override fun getBooksBorrowed(student: Student): List<Book> {
        return borrowed[student.getDisplayId()] ?: emptyList()
    }

    fun getAllBooks() = books
    fun getAllStudents() = students
}