package com.example.testapp.di

import com.example.testapp.domain.GetAllMessagesUseCase
import com.example.testapp.domain.SendTextMessageUseCase
import dagger.Component

@ChatScope
@Component(modules = [MessagesBindsModule::class])
interface ChatComponent {

    val getAllMessagesUseCase: GetAllMessagesUseCase
    val sendTextMessageUseCase: SendTextMessageUseCase
}
