package com.silver0727.presentation.model.task

import com.silver0727.domain.dto.TaskDTO
import com.silver0727.presentation.model.base.PresentationMapper

object TaskItemMapper : PresentationMapper<TaskItem, TaskDTO> {

    override fun toPresentation(dto: TaskDTO): TaskItem {
        return TaskItem(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            isCompleted = dto.isCompleted
        )
    }

    override fun toDomain(item: TaskItem): TaskDTO {
        return TaskDTO(
            id = item.id,
            title = item.title,
            description = item.description,
            isCompleted = item.isCompleted
        )
    }

}