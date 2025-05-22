package com.example.todo.presentation.screens.apiscreens

import android.widget.GridLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.todo.presentation.components.ApiCard
import com.example.todo.presentation.components.TodoItemCard

@Composable
fun ApiDashboard(navController: NavController,
                 viewModel: ApiViewModel = hiltViewModel()
){
    // reference variables for our items
    val tasks by viewModel.tasks
    val isLoading by viewModel.isLoading
    val error by viewModel.error

    // called the action to fetch tasks from view model on screen load
    LaunchedEffect(Unit) {
        viewModel.fetchTasks()
    }
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        // is data loading
        if(isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterVertically as Alignment.Horizontal)
            )
            // if not
            // it is an error
            error?.let{
                Text(text = it ,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp),
                    color = MaterialTheme.colorScheme.error)}
            LazyColumn {
                items(tasks){ task ->
                    ApiCard(
                        todo = task,
                        onCompleteChange = {},
                        onEditClick = {},
                        onDeleteClick = {}
                    ) { }
                }
            }
            // list of tasks from api
        }
    }
}