package com.example.testapp.data

import com.example.testapp.di.ChatScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

@ChatScope
class MessageRepository @Inject constructor(
    private val receiverMessageSource: ReceiverMessageSource,
    private val senderMessagesSource: SenderMessagesSource
){
    val messageFlow: Flow<Message> = merge(
        receiverMessageSource.messages,
        senderMessagesSource.messages
    )

    suspend fun sendMessage(message: Message) {
        senderMessagesSource.sendMessage(message)
    }

}
