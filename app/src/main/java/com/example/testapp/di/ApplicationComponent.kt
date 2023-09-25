package com.example.testapp.di

import com.example.testapp.ui.chat.ChatViewModelFactory
import dagger.Component

@Component
@ApplicationScope
interface ApplicationComponent {

    val chatViewModelFactory: ChatViewModelFactory
}
