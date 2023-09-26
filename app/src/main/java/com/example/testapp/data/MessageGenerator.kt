package com.example.testapp.data

import com.example.testapp.R
import com.example.testapp.di.ChatScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

@ChatScope
class MessageGenerator @Inject constructor() : ReceiverMessageSource {

    private var count = AtomicInteger()
    private fun generateTextMessage(): Flow<Message> {
        return flow {
            while (true) {
                delay(1000)
                val text = "Message ${count.incrementAndGet()}"
                val message = Message(text = text)
                emit(message)
            }

        }
    }

    private fun generateTextWithImageMessage(): Flow<Message> {
        return flow {
            while (true) {
                delay(2000)
                val text = "Message ${count.incrementAndGet()}"
                val message = Message(text = text, image = R.drawable.plus_image)
                emit(message)
            }

        }
    }

    override val messages: Flow<Message>
        get() =  merge(generateTextWithImageMessage(), generateTextMessage())
}
