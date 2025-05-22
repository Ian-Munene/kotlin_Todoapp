package com.example.todo.data.model

// model will define the body for our post request i.e. posting a task via our api

data class CreateTaskRequest(
    val tittle: String,
    val completed: Boolean= false,
    val tasker: Int,
    val user : Int? = null
)
