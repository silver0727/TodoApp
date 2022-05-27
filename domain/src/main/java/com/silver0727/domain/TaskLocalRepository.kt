package com.silver0727.domain

import com.silver0727.domain.dto.TaskDTO
import kotlinx.coroutines.flow.Flow

interface TaskLocalRepository {

    suspend fun insertTask(task: TaskDTO)

    fun getTasks(): Flow<List<TaskDTO>>

    fun testString(): String
}