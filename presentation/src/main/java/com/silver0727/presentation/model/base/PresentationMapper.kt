package com.silver0727.presentation.model.base

import com.silver0727.domain.base.DTO
import com.silver0727.domain.base.Item

interface PresentationMapper<I : Item, D : DTO> {
    fun toPresentation(dto: D): I
    fun toDomain(item: I): D
}