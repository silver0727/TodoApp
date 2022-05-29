package com.silver0727.data.base

import com.silver0727.domain.base.DTO
import com.silver0727.domain.base.Entity

interface DataMapper<E : Entity, D : DTO> {
    fun toData(dto: D): E
    fun toDomain(entity: E): D
}