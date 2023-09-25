package com.example.testapp.data

import com.example.testapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject
import kotlin.random.Random

class MessageGenerator @Inject constructor() {

    private var count = AtomicInteger()
    fun generateTextMessage(): Flow<Message> {
        return flow {
            while (true) {
                delay(1000)
                val text = "Message ${count.incrementAndGet()}"
                val message = Message(text = text)
                emit(message)
            }

        }
    }

    fun generateTextWithImageMessage(): Flow<Message> {
        return flow {
            while (true) {
                delay(2000)
                val text = "Message ${count.incrementAndGet()}"
                val message = Message(text = text, image = R.drawable.plus_image)
                emit(message)
            }

        }
    }
}
