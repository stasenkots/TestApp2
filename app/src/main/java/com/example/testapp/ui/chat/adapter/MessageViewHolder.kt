package com.example.testapp.ui.chat.adapter

import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.data.Message
import com.example.testapp.databinding.ItemMessageBinding

class MessageViewHolder(private val binding: ItemMessageBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(message: Message) {
        binding.messageText.text = message.text
        configureMessageImage(message)
    }

    private fun configureMessageImage(message: Message) {

        val image = message.image?.let {
            AppCompatResources.getDrawable(binding.root.context, message.image)
        }

        binding.messageImage.apply {
            setImageDrawable(image)
            isVisible = image != null
        }
    }
}
