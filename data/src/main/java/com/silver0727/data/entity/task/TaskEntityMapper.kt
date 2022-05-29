package com.silver0727.data.entity.task

import com.silver0727.data.base.DataMapper
import com.silver0727.domain.dto.TaskDTO

object TaskEntityMapper : DataMapper<Task, TaskDTO> {
    override fun toData(dto: TaskDTO): Task {
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

    override fun toDomain(entity: Task): TaskDTO {
        return TaskDTO(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            isCompleted = entity.isCompleted
        )
    }
}