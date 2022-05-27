package com.silver0727.presentation.utils

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import timber.log.Timber

fun Fragment?.navigate(action: NavDirections) {
    try {
        this?.findNavController()?.navigate(action)
    } catch (e: IllegalArgumentException) {
        Timber.e(e)
    }
}