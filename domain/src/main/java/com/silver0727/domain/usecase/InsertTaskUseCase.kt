package com.silver0727.domain.usecase

import com.silver0727.domain.TaskLocalRepository
import com.silver0727.domain.dto.TaskDTO

class InsertTaskUseCase(
    private val repository: TaskLocalRepository
) {
    suspend operator fun invoke(
        task: TaskDTO,
        onResult: (String) -> Unit = {}
    ) {
        repository.insertTask(task)
        onResult("Success")
    }

}