package com.silver0727.data.repository

import com.silver0727.data.dao.TaskDao
import com.silver0727.data.entity.task.Task
import com.silver0727.data.entity.task.TaskEntityMapper
import com.silver0727.domain.TaskLocalRepository
import com.silver0727.domain.dto.TaskDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TaskLocalRepositoryImpl @Inject constructor(
    private val local: TaskDao,
) : TaskLocalRepository {

    override suspend fun insertTask(task: TaskDTO) {
        local.insertTask(
            TaskEntityMapper.toData(task)
        )
    }

    override fun getTasks(): Flow<List<TaskDTO>> {
        return local.observeTasks().map { tasks ->
            tasks.map { TaskEntityMapper.toDomain(it) }
        }
    }

    override fun getTaskById(taskId: String): Flow<TaskDTO> {
        return local.observeTaskById(taskId = taskId).map { task ->
            TaskEntityMapper.toDomain(task)
        }
    }

    override fun testString(): String {
        return "오성이 바보~~~~~"
    }
}