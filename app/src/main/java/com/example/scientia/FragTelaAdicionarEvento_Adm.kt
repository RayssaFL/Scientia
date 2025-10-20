package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragTelaAdicionarEvento_Adm.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragTelaAdicionarEvento_Adm : Fragment() {

    lateinit var btnCancelar: Button
    lateinit var btnSalvar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_tela_adicionar_evento__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCancelar = view.findViewById(R.id.btnCancelarEvt)
        btnSalvar = view.findViewById(R.id.btnSalvarEvt)


    }
    override fun onStart() {
        super.onStart()

        btnSalvar.setOnClickListener {
            Toast.makeText(btnSalvar.context, "Evento Salvo Com Sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(btnCancelar.context, "Adição De Evento Cancelado", Toast.LENGTH_SHORT).show()
        }

    }


}