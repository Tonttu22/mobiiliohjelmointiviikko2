package com.example.viikkotehtava2.model

data class Task(
    val id: Int,
    val title: String,
    val done: Boolean,
    val dueDate: String
)
