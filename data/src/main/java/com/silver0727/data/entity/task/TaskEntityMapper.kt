package com.silver0727.data.entity.task

import com.silver0727.data.base.DataMapper
import com.silver0727.domain.model.TaskModel

object TaskEntityMapper : DataMapper<Task, TaskModel> {
    override fun toData(dto: TaskModel): Task {
        val taskId = dto.id
        val task = Task(
            title = dto.title,
            description = dto.description,
            isCompleted = dto.isCompleted
        )
        return if (taskId.isEmpty()) {
            task
        } else {
            task.copy(id = taskId)
        }
    }

    override fun toDomain(entity: Task): TaskModel {
        return TaskModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            isCompleted = entity.isCompleted
        )
    }
}