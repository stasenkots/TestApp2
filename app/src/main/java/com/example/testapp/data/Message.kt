package com.example.testapp.data

import androidx.annotation.DrawableRes
import java.util.UUID

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val text: String? = null,
    @DrawableRes val image: Int? = null
)
