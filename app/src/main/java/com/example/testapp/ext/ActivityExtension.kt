package com.example.testapp.ext

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

fun Activity.closeKeyboard() {
    val view = currentFocus

    if (view != null) {
        val inputMethodManager =
            ContextCompat.getSystemService(
                this,
                InputMethodManager::class.java
            )
        inputMethodManager?.hideSoftInputFromWindow(view.windowToken,0)
    }
}
