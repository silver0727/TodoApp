package com.silver0727.presentation.model.navigation

sealed class NavigationDestination {
    object Tasks: NavigationDestination()
    object AddTask: NavigationDestination()
}
