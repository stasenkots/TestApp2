package com.example.testapp.ext

import androidx.fragment.app.Fragment
import com.example.testapp.TestApplication
import com.example.testapp.di.ApplicationComponent

val Fragment.appComponent: ApplicationComponent
    get() = (requireContext().applicationContext as TestApplication).appComponent

fun Fragment.closeKeyboard() {
    requireActivity().closeKeyboard()
}
