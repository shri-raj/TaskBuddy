package com.app.taskbuddy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class TaskViewModel : ViewModel() {

    val tododao = MainApplication.taskDB.getTaskDao()

    val tasklist: LiveData<List<TaskData>> = tododao.getAllTasks()

    fun addTask(taskName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            tododao.addTask(TaskData(name = taskName,date = getCurrentDateAtMidnight()))
        }
    }

    fun removeTask(task: TaskData) {
        viewModelScope.launch(Dispatchers.IO) {
            tododao.deleteTask(task)
        }
    }
}
private fun getCurrentDateAtMidnight(): String {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    return SimpleDateFormat("EEE MMM dd, yyyy", Locale.getDefault()).format(calendar.time)
}