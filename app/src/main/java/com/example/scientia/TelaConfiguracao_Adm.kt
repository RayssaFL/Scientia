package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TelaConfiguracao_Adm : Fragment() {
    private lateinit var btnBarranav: MaterialToolbar
    private lateinit var tema: Switch
    private lateinit var fonteSize: SeekBar
    private lateinit var sair: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_configuracao__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBarranav = view.findViewById(R.id.BarraNavegacaoConfigLivro)
        tema = view.findViewById(R.id.switchTema)
        fonteSize = view.findViewById(R.id.barraTamanhoFonte)
        sair = view.findViewById(R.id.sairAdm)

        btnBarranav.setNavigationOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        })

        tema.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                mudarTema(isChecked)
            }
        })

        fonteSize.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mudarTamFonte(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sair.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                mostrarPopupSair()
            }
        })
    }

    private fun mudarTema(isNoturno: Boolean) {
        if (isNoturno) {
            Toast.makeText(context, "Tema noturno ativado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Tema diario ativado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mudarTamFonte(progress: Int) {
        val tamanho: String
        if (progress == 0) {
            tamanho = "Pequeno"
        } else if (progress == 1) {
            tamanho = "Normal"
        } else if (progress == 2) {
            tamanho = "Grande"
        } else {
            tamanho = "Normal"
        }
        Toast.makeText(context, "Tamanho da fonte: $tamanho", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarPopupSair() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Sair do Scientia")
            .setMessage("Você deseja sair da sua conta?")
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
                acaoCancelada()
            }
            .setPositiveButton("Sair") { dialog, _ ->
                dialog.dismiss()
                sairDaConta()
            }
            .show()
    }

    private fun sairDaConta() {
        Toast.makeText(context, "Saindo da conta", Toast.LENGTH_SHORT).show()
        val intencao = Intent(requireContext(), TelaLogin_Adm::class.java)
        startActivity(intencao)
        requireActivity().finish()
    }
    private fun acaoCancelada(){
        Toast.makeText(context, "Ação cancelada", Toast.LENGTH_SHORT).show()
    }
}