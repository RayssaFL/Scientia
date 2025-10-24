package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class TelaDevolucao_Adm : Fragment() {

    private lateinit var idLivro: EditText
    private lateinit var idUser: EditText
    private lateinit var dataDev: EditText
    private lateinit var btn1: Button
    private lateinit var btn2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_devolucao__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        idLivro = view.findViewById(R.id.editTextIdLivro)
        idUser = view.findViewById(R.id.editTextIdUsuario)
        dataDev = view.findViewById(R.id.editTextDataDevolucao)
        btn1 = view.findViewById(R.id.btnSalvarDev)
        btn2 = view.findViewById(R.id.btnCancelarDev)

        btn1.setOnClickListener {
            validarCampos()
        }
        btn2.setOnClickListener {
            Toast.makeText(requireContext(), "Ação cancelada", Toast.LENGTH_SHORT).show()

        }
    }
    private fun validarCampos(){
        if(idLivro.text.isEmpty() || idUser.text.isEmpty() || dataDev.text.isEmpty()){
            Toast.makeText(requireContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "Livro devolvido com sucesso!", Toast.LENGTH_SHORT).show()
            val intencao2 = Intent(requireContext(), TelaHome_Adm::class.java)
            startActivity(intencao2)
            requireActivity().finish()
        }
    }
}