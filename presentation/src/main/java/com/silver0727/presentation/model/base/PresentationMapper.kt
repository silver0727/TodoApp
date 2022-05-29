package com.silver0727.presentation.model.base

import com.silver0727.domain.base.Model
import com.silver0727.domain.base.Item

interface PresentationMapper<I : Item, D : Model> {
    fun toPresentation(dto: D): I
    fun toDomain(item: I): D
}