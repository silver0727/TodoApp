package com.silver0727.presentation.ui.editing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silver0727.domain.dto.TaskDTO
import com.silver0727.domain.usecase.InsertTaskUseCase
import com.silver0727.presentation.model.navigation.NavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TaskEditingViewModel @Inject constructor(
    private val insertTaskUseCase: InsertTaskUseCase
): ViewModel() {

    private val _taskUpdatedEvent = MutableLiveData<NavigationDestination?>()
    val taskUpdatedEvent: LiveData<NavigationDestination?> = _taskUpdatedEvent

    private fun setNavigationEvent() {
        _taskUpdatedEvent.value = NavigationDestination.Tasks
    }

    fun insertTask(
        title: String,
        description: String
    ) {
        viewModelScope.launch {

            val taskDTO = TaskDTO(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                isCompleted = false
            )

            insertTaskUseCase(taskDTO) {
                Timber.v("success? $it")
                setNavigationEvent()
            }
        }
    }
}