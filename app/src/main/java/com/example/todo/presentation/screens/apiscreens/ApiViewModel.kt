package com.example.todo.presentation.screens.apiscreens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.data.model.Task
import com.example.todo.data.repository.ApiRepository
import kotlinx.coroutines.launch

class ApiViewModel(private val repository : ApiRepository): ViewModel() {
    // reference variables to expose data
    // This will capture tasks from our returned Api tasks
    private val _tasks = mutableStateOf<List<Task>>(emptyList())
    // the supply of above tasks to ou composable screens
    val tasks : State<List<Task>> = _tasks
    private val _isLoading = mutableStateOf(false)
    val isLoading : State<Boolean> = _isLoading
    // reference to any occurrence if an error
    private val _error = mutableStateOf<String?>(null)
    val error : State<String?> = _error
    // function fetch our tasks
    fun fetchTasks (){
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
              _tasks.value = repository.getTasks()
            }catch (e: Exception){
                _error.value = e.message?: "Unknown error occurred"
            }finally {
                _isLoading.value= false
            }
        }}
}

class ApiViewModelFactory(private val repository : ApiRepository) : ViewModelProvider.Factory{
    override fun<T : ViewModel> create (modelClass : Class<T>) : T {
        if(modelClass.isAssignableFrom(ApiViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ApiViewModel(repository) as T
        }
        throw IllegalArgumentException ("Unknown ViewModel Class ")
    }
}