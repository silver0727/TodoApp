package com.silver0727.data

import android.content.Context
import androidx.room.Room
import com.silver0727.data.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideToDoDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java, "Tasks.db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesTaskDao(
        toDoDB: ToDoDatabase
    ): TaskDao {
        return toDoDB.taskDao()
    }

}