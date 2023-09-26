package com.example.testapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.di.ChatComponent
import com.example.testapp.di.DaggerChatComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val chatComponent: ChatComponent by lazy { DaggerChatComponent.create() }

    private val getAllMessagesUseCase = chatComponent.getAllMessagesUseCase
    private val sendTextMessageUseCase = chatComponent.sendTextMessageUseCase

    val messages = getAllMessagesUseCase.execute()
        .flowOn(Dispatchers.IO)

    fun sendTextMessage(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            sendTextMessageUseCase.execute(text)
        }
    }


}
