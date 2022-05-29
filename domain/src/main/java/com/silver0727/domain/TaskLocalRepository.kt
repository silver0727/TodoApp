package com.silver0727.domain

import com.silver0727.domain.model.TaskModel
import kotlinx.coroutines.flow.Flow

interface TaskLocalRepository {

    suspend fun insertTask(task: TaskModel)

    fun getTasks(): Flow<List<TaskModel>>

    fun getTaskById(taskId: String): Flow<TaskModel>

    fun testString(): String
}