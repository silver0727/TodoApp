package com.silver0727.presentation.utils

import android.widget.CheckBox
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.silver0727.presentation.model.task.TaskItem
import com.silver0727.presentation.ui.tasks.TasksAdapter

@BindingAdapter("setTasks")
fun RecyclerView.setTasks(tasks: List<TaskItem>?) {
    isVisible = tasks.isNullOrEmpty().not()
    if (tasks.isNullOrEmpty()) return
    (adapter as TasksAdapter).submitList(tasks.toMutableList())
}

@BindingAdapter("setTaskCompleted")
fun CheckBox.setTaskCompleted(completed: Boolean?) {
    isChecked = completed == true
}