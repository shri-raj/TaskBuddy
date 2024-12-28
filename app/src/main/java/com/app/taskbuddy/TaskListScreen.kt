package com.app.taskbuddy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TaskListMainScreen(modifier: Modifier = Modifier, viewModel : TaskViewModel = viewModel()) {
    var taskname by remember { mutableStateOf("") }
    var showdialog by remember { mutableStateOf(false) }
    val taskList by viewModel.tasklist.observeAsState(emptyList())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {showdialog=true}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Add Item")
        }
        LazyColumn {
            items(taskList) { task ->
                TaskItem(task = task, OnCompletion = { viewModel.removeTask(task) })
            }
        }
    }
    if(showdialog) {
        AlertDialog(onDismissRequest = {showdialog=false},
            confirmButton = {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)  {
                    Button(onClick = {
                        if(taskname.isNotBlank()) {
                            viewModel.addTask(taskname)
                            taskname = ""
                            showdialog = false
                        }
                    }) {
                        Text("Add")
                    }
                    Button(onClick = { showdialog=false }) {
                        Text("Cancel")
                    }
                }
            },
            title = { Text("Add Task") },
            text = {
                OutlinedTextField(
                    value = taskname,
                    onValueChange = { taskname = it },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                )
            })
    }
}
