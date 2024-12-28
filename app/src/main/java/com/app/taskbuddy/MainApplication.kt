package com.app.taskbuddy

import android.app.Application
import androidx.room.Room
import com.app.taskbuddy.db.TaskDB

class MainApplication: Application() {

    companion object{
        lateinit var taskDB : TaskDB
    }

    override fun onCreate() {
        super.onCreate()
        taskDB = Room.databaseBuilder(applicationContext, TaskDB::class.java, TaskDB.NAME).build()
    }
}