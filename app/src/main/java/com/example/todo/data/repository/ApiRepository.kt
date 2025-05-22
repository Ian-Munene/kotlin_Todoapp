package com.example.todo.data.repository

import com.example.todo.data.model.Task
import com.example.todo.data.services.TaskApiService

class ApiRepository(private val apiService: TaskApiService) {
    suspend fun getTasks():List<Task>{
        return apiService.getTasks()
    }
}