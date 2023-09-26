package com.example.testapp.data

import kotlinx.coroutines.flow.Flow

interface SenderMessagesSource {

    val messages: Flow<Message>
    suspend fun sendMessage(message: Message)
}
