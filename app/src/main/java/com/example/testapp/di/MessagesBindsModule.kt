package com.example.testapp.di

import com.example.testapp.data.MessageGenerator
import com.example.testapp.data.ReceiverMessageSource
import com.example.testapp.data.SenderMessagesSource
import com.example.testapp.data.UserMessagesSource
import dagger.Binds
import dagger.Module

@Module
interface MessagesBindsModule {

    @Binds
    fun senderMessagesSource(userMessagesSource: UserMessagesSource): SenderMessagesSource

    @Binds
    fun receiverMessagesSource(messageGenerator: MessageGenerator): ReceiverMessageSource

}
