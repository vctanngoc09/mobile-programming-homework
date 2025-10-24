package com.example.quanlythuvien.model

class Student(
    id: Int,
    name: String
) : Person(id, name) {

    override fun getDisplayName(): String {
        return "SV: $name"
    }

    override fun getDisplayId(): Int {
        return super.getDisplayId()
    }
}