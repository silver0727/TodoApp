package com.silver0727.domain.model

import com.silver0727.domain.base.Model

data class TaskModel(
    val id: String = "",
    val title: String,
    val description: String,
    val isCompleted: Boolean,
): Model()
