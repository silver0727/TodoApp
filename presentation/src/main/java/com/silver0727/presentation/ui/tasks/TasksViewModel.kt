package com.silver0727.presentation.ui.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silver0727.domain.TaskLocalRepository
import com.silver0727.presentation.model.navigation.NavigationDestination
import com.silver0727.presentation.model.task.TaskItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val repository: TaskLocalRepository
) : ViewModel() {

    private var _tasks = MutableLiveData<List<TaskItem>>()
    val tasks: LiveData<List<TaskItem>> = _tasks

    private var _navigationDestination = MutableSharedFlow<NavigationDestination?>()
    val navigationDestination = _navigationDestination.asSharedFlow()

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

    private fun setNavigationEvent(event: NavigationDestination) {
        viewModelScope.launch {
            _navigationDestination.emit(event)
        }
    }

    fun setAddTaskEvent() {
        setNavigationEvent(event = NavigationDestination.AddTask)
    }
}