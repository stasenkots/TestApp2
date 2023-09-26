package com.example.testapp.ui.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.FragmentChatBinding
import com.example.testapp.ext.closeKeyboard
import com.example.testapp.ui.chat.adapter.MessageAdapterDataObserver
import com.example.testapp.ui.chat.adapter.MessageAdapter
import kotlinx.coroutines.launch

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding
        get() = _binding!!


    private val messageAdapter = MessageAdapter()

    private val viewModel: ChatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureChatRecycleView()
        configureUserMessageInput()
    }

    private fun configureUserMessageInput() {
        with(binding) {
            sendButton.isEnabled = false
            sendButton.setOnClickListener {
                val text = chatInput.editText?.text?.toString() ?: ""
                viewModel.sendTextMessage(text)
                closeKeyboard()
            }

            chatInput.editText?.doAfterTextChanged {
                sendButton.isEnabled = it.toString().isNotBlank()
            }
        }
    }

    private fun configureChatRecycleView() {
        binding.chatRecycleView.apply {
            adapter = messageAdapter.apply {
                registerAdapterDataObserver(
                    MessageAdapterDataObserver {
                        smoothScrollToPosition(itemCount - 1)
                    }
                )
            }
            layoutManager = LinearLayoutManager(context).apply {
                stackFromEnd = true
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.messages.collect {
                    messageAdapter.addMessage(it)
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
