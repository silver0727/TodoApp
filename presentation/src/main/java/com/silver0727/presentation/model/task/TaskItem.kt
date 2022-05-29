package com.silver0727.presentation.model.task

import com.silver0727.domain.base.Item

data class TaskItem(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val onDetail: ((String, String) -> Unit)? = null
): Item()
