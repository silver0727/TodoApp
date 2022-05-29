package com.silver0727.presentation.ui.editing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silver0727.domain.TaskLocalRepository
import com.silver0727.domain.dto.TaskDTO
import com.silver0727.domain.usecase.InsertTaskUseCase
import com.silver0727.presentation.model.navigation.NavigationDestination
import com.silver0727.presentation.model.task.TaskItem
import com.silver0727.presentation.model.task.TaskItemMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TaskEditingViewModel @Inject constructor(
    private val repository: TaskLocalRepository,
    private val insertTaskUseCase: InsertTaskUseCase
): ViewModel() {

    private val _taskUpdatedEvent = MutableStateFlow<NavigationDestination?>(null)
    val taskUpdatedEvent = _taskUpdatedEvent.asStateFlow()

    private var _task = MutableStateFlow<TaskItem?>(null)
    val task = _task.asStateFlow()

    fun fetchTaskById(taskId: String) {
        viewModelScope.launch {
            if (taskId.isEmpty()) {
                return@launch
            }
            repository.getTaskById(taskId).collect {
                _task.value = TaskItemMapper.toPresentation(it).copy(
                    onDetail = { taskId, title ->
                        test(taskId, title)
                    }
                )
            }
        }
    }

    private fun test(id: String, title: String) {
        viewModelScope.launch {
            _taskUpdatedEvent.emit(
                NavigationDestination.TaskDetail(
                    taskId = id,
                    title = title
                )
            )
        }
    }

    fun insertTask(
        title: String,
        description: String
    ) {
        viewModelScope.launch {
            val taskDTO = TaskDTO(
                title = title,
                description = description,
                isCompleted = false
            )

            if (title.isEmpty() || description.isEmpty()) return@launch

            insertTaskUseCase(taskDTO) {
                Timber.v("success? $it")
                setNavigationEvent()
            }
        }
    }

    private fun setNavigationEvent() {
        viewModelScope.launch {
            _taskUpdatedEvent.emit(NavigationDestination.Tasks)
        }
    }
}