package com.app.taskbuddy.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.taskbuddy.TaskData


@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<TaskData>>

    @Insert
    fun addTask(task: TaskData)
    @Delete
    fun deleteTask(task: TaskData)
}