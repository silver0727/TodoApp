package com.silver0727.presentation.model.task

import com.silver0727.domain.model.TaskModel
import com.silver0727.presentation.model.base.PresentationMapper

object TaskItemMapper : PresentationMapper<TaskItem, TaskModel> {

    override fun toPresentation(dto: TaskModel): TaskItem {
        return TaskItem(
            id = dto.id,
            title = dto.title,
            description = dto.description,
            isCompleted = dto.isCompleted
        )
    }

    override fun toDomain(item: TaskItem): TaskModel {
        return TaskModel(
            id = item.id,
            title = item.title,
            description = item.description,
            isCompleted = item.isCompleted
        )
    }

}