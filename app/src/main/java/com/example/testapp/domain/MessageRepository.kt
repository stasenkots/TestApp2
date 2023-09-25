package com.example.testapp.domain

import com.example.testapp.data.Message
import com.example.testapp.data.MessageGenerator
import com.example.testapp.di.ApplicationScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject
import javax.inject.Singleton


@ApplicationScope
class MessageRepository @Inject constructor(
    messageGenerator: MessageGenerator
) {
    private val userMessages: MutableSharedFlow<Message> = MutableSharedFlow()

    val messageFlow: Flow<Message> = merge(
        messageGenerator.generateTextMessage(),
        messageGenerator.generateTextWithImageMessage(),
        userMessages
    )

    suspend fun sendMessage(message: Message) {
        userMessages.emit(message)
    }

}
