package com.example.testapp.domain

import com.example.testapp.data.Message
import javax.inject.Inject

class SendTextMessageUseCase @Inject constructor(
    private val messageRepository: MessageRepository
) {
    suspend fun execute(text: String) {
        val message = Message(text = text)
        messageRepository.sendMessage(message)
    }
}
