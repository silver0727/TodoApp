package com.silver0727.presentation.model.navigation

sealed class NavigationDestination {
    object Tasks: NavigationDestination()
    object AddTask: NavigationDestination()
    data class TaskDetail(
        val taskId: String,
        val title: String
    ): NavigationDestination()
}
