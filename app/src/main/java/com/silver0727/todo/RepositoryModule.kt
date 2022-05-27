package com.silver0727.todo

import com.silver0727.data.dao.TaskDao
import com.silver0727.data.repository.TaskLocalRepositoryImpl
import com.silver0727.domain.TaskLocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesTaskLocalRepository(
        taskDao: TaskDao
    ): TaskLocalRepository {
        return TaskLocalRepositoryImpl(taskDao)
    }
}