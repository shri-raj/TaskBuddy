package com.app.taskbuddy


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskData (
    @PrimaryKey(autoGenerate = true)
    var id : Int =0 ,
    var name : String,
    var date : String
)
