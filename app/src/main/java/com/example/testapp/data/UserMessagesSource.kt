package com.example.testapp.data

import com.example.testapp.di.ChatScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@ChatScope
class UserMessagesSource @Inject constructor() : SenderMessagesSource {

    private val userMessages: MutableSharedFlow<Message> = MutableSharedFlow()

    override val messages: Flow<Message>
        get() = userMessages

    override suspend fun sendMessage(message: Message) {
        userMessages.emit(message)
    }

}
