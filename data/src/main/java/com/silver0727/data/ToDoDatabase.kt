package com.silver0727.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silver0727.data.dao.TaskDao
import com.silver0727.data.entity.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao
}