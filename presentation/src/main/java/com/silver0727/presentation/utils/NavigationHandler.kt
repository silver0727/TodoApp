package com.silver0727.presentation.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.silver0727.presentation.R
import timber.log.Timber

object NavigationHandler {

    fun navigateSafe(
        activity: FragmentActivity?,
        direction: NavDirections
    ) {
        try {
            val navHostFragment =
                activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            navHostFragment?.navController?.currentDestination?.getAction(direction.actionId)?.let {
                navHostFragment.navController.navigate(direction)
            }
        } catch (e: IllegalArgumentException) {
            Timber.e(e)
        }
    }

    fun navigateSafe(
        fragment: Fragment?,
        direction: NavDirections
    ) {
        try {
            fragment?.findNavController()?.currentDestination?.getAction(direction.actionId)?.let {
                fragment.findNavController().navigate(direction)
            }
        } catch (e: IllegalArgumentException) {
            Timber.e(e)
        }
    }
}