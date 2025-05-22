package com.example.todo.data.model

data class Task(
    val id : Int? = null,
    val tasker : Tasker,
    val title: String,
    val completed: Boolean,
    val created_at: String? = null,
    val user : Int? = null
)
