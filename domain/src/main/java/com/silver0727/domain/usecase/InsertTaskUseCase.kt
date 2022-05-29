package com.silver0727.domain.usecase

import com.silver0727.domain.TaskLocalRepository
import com.silver0727.domain.model.TaskModel

class InsertTaskUseCase(
    private val repository: TaskLocalRepository
) {
    suspend operator fun invoke(
        task: TaskModel,
        onResult: (String) -> Unit = {}
    ) {
        repository.insertTask(task)
        onResult("Success")
    }

}