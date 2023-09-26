package com.example.testapp.domain

import com.example.testapp.data.Message
import com.example.testapp.data.MessageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMessagesUseCase @Inject constructor(
    private val messageRepository: MessageRepository
) {
    fun execute(): Flow<Message> {
        return messageRepository.messageFlow
    }
}
