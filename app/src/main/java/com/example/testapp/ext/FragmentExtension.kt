package com.example.testapp.ext

import androidx.fragment.app.Fragment

fun Fragment.closeKeyboard() {
    requireActivity().closeKeyboard()
}
