package com.silver0727.todo

import com.silver0727.domain.TaskLocalRepository
import com.silver0727.domain.usecase.InsertTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesInsertTaskUseCase(
        repository: TaskLocalRepository
    ): InsertTaskUseCase {
        return InsertTaskUseCase(repository)
    }
}