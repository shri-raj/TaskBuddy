package com.app.taskbuddy.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.taskbuddy.TaskData

@Database(entities = [TaskData::class], version = 1, exportSchema = false)
abstract class TaskDB : RoomDatabase() {
     companion object {
         const val NAME = "task_db"
     }
    abstract fun getTaskDao(): TaskDao

}