package com.example.todo.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ForgotPassword(navController: NavController){
    var email by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.Center){
            Text("Forgot Password", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = email, onValueChange = { email = it },
                label = { Text("Email") })

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {}
            ){
                Text("Reset Password")
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview(){
    ForgotPassword(rememberNavController())
}