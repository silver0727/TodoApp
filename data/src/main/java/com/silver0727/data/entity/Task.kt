package com.silver0727.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.silver0727.domain.dto.TaskDTO
import java.util.*

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey @ColumnInfo(name = "entryId") var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "description") var description: String = "",
    @ColumnInfo(name = "completed") var isCompleted: Boolean = false,
)
