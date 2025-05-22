package com.example.todo.data.services

import com.example.todo.data.model.CreateTaskRequest
import com.example.todo.data.model.Task
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TaskApiService {
    // add annotation to represent the HTTP method
    @GET("/api/tasks")
    suspend fun getTasks():List<Task>
    @POST("api/tasks")
    suspend fun createTask(@Body task : CreateTaskRequest): Task

    // companion Object : This object is used for implementing the interface

    companion object{
        private val base_url = " "// server link ,ngrok link
        // function to create connection to endpoint
        fun create(): TaskApiService{
            // return retrofit which sets up our network communication
            val retrofit = Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(TaskApiService::class.java)
        }
    }
}