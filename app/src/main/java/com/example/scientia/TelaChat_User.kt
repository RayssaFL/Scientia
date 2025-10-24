package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaChat_User : Fragment() {

    private val messages = mutableListOf<Message>()
    private lateinit var adapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_chat_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(
            R.id.barraNavegacaoChatBot
        )

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewChat)
        val editText = view.findViewById<EditText>(R.id.editTextText)
        val buttonSend = view.findViewById<Button>(R.id.buttonSend)

        adapter = MessageAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        buttonSend.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isNotEmpty()) {
                // User message
                messages.add(Message(text, true))
                adapter.notifyItemInserted(messages.size - 1)
                recyclerView.scrollToPosition(messages.size - 1)
                editText.text.clear()

                // Fake bot reply
                recyclerView.postDelayed({
                    val botReply = Message("Resposta automática: $text", false)
                    messages.add(botReply)
                    adapter.notifyItemInserted(messages.size - 1)
                    recyclerView.scrollToPosition(messages.size - 1)
                }, 1000)
            }
        }
    }
}
