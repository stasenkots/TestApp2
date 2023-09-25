package com.example.testapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.Message
import com.example.testapp.domain.GetAllMessagesUseCase
import com.example.testapp.domain.SendTextMessageUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ChatViewModel(
    getAllMessagesUseCase: GetAllMessagesUseCase,
    private val sendTextMessageUseCase: SendTextMessageUseCase
) : ViewModel() {

    val messages = getAllMessagesUseCase.execute()
        .flowOn(Dispatchers.IO)
        .buffer(capacity = UNLIMITED)

    fun sendTextMessage(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            sendTextMessageUseCase.execute(text)
        }
    }

}
