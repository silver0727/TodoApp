package com.silver0727.presentation.ui.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silver0727.domain.TaskLocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val repository: TaskLocalRepository
) : ViewModel() {

    private var _tasks = MutableLiveData<List<TaskItem>>()
    val tasks: LiveData<List<TaskItem>> = _tasks


    fun fetchTasks() {
        viewModelScope.launch {
            repository.getTasks().collect { taskList ->
                _tasks.postValue(
                    taskList.map { task ->
                        TaskItem(
                            id = task.id,
                            title = task.title,
                            description = task.description,
                            isCompleted = task.isCompleted,
                        )
                    }
                )
            }
        }
        Timber.v("Test ${repository.testString()}")
    }

}