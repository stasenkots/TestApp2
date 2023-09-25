package com.example.testapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.domain.GetAllMessagesUseCase
import com.example.testapp.domain.SendTextMessageUseCase
import javax.inject.Inject

class ChatViewModelFactory @Inject constructor(
    private val getAllMessagesUseCase: GetAllMessagesUseCase,
    private val sendTextMessageUseCase: SendTextMessageUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatViewModel(getAllMessagesUseCase, sendTextMessageUseCase) as T
    }
}
