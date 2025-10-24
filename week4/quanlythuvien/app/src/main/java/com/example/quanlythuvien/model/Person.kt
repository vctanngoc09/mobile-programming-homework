package com.example.quanlythuvien.model

open class Person(
    protected var id: Int,
    protected var name: String
) {
    open fun getDisplayName() = name
    open fun getDisplayId() = id
}