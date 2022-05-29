package com.silver0727.domain.dto

import com.silver0727.domain.base.DTO

data class TaskDTO(
    val id: String,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
): DTO()
