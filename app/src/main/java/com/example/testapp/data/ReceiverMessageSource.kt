package com.example.testapp.data

import kotlinx.coroutines.flow.Flow


interface ReceiverMessageSource {

    val messages: Flow<Message>
}
