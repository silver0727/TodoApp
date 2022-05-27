package com.silver0727.data.repository

import com.silver0727.data.dao.TaskDao
import com.silver0727.data.entity.Task
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
            Task(
                title = task.title,
                description = task.description,
                isCompleted = task.isCompleted
            )
        )
    }

    override fun getTasks(): Flow<List<TaskDTO>> {
        val test = local.observeTasks().map {
            it.map { task ->
                TaskDTO(
                    id = task.id,
                    title = task.title,
                    description = task.description,
                    isCompleted = task.isCompleted,
                )
            }
        }
        return test
    }

    override fun testString(): String {
        return "오성이 바보~~~~~"
    }
}