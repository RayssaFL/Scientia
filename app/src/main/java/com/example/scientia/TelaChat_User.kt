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
    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var buttonSend: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_chat_user, container, false)

        // componentes UI
        recyclerView = view.findViewById(R.id.recyclerViewChat)
        editText = view.findViewById<EditText>(R.id.editTextText)
        buttonSend = view.findViewById<Button>(R.id.buttonSend)

        // adapter e recyclerview
        adapter = MessageAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val welcomeMessage = Message(
            text = "Olá sou o assistente de estudos, o que gostaria de fazer?",
            isUser = false
        )

        messages.add(welcomeMessage)
        adapter.notifyItemInserted(messages.size-1)
        recyclerView.scrollToPosition(messages.size-1)

        // botao de enviar mensagem
        buttonSend.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isNotEmpty()) {
                // mensagem usuario
                messages.add(Message(text, true))
                adapter.notifyItemInserted(messages.size - 1)
                recyclerView.scrollToPosition(messages.size - 1)
                editText.text.clear()

                // resposta com delay
                recyclerView.postDelayed({
                    val botReply = Message("Resposta: $text", false)
                    messages.add(botReply)
                    adapter.notifyItemInserted(messages.size - 1)
                    recyclerView.scrollToPosition(messages.size - 1)
                }, 1000)
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(
            R.id.barraNavegacaoChatBot
        )

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
