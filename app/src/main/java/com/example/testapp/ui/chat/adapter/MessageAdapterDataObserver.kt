package com.example.testapp.ui.chat.adapter

import androidx.recyclerview.widget.RecyclerView

class MessageAdapterDataObserver(
    private val smoothScrollToEnd: () -> Unit,
) : RecyclerView.AdapterDataObserver() {

    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        super.onItemRangeInserted(positionStart, itemCount)
        smoothScrollToEnd()
    }
}
