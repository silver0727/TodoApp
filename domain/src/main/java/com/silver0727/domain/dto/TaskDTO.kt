package com.silver0727.domain.dto

data class TaskDTO(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
)
