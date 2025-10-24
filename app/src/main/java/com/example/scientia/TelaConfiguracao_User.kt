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
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TelaConfiguracao_User : Fragment() {
    private lateinit var btnBarranavUser: MaterialToolbar
    private lateinit var temaUser: Switch
    private lateinit var fonteSizeUser: SeekBar
    private lateinit var sairUser: LinearLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_configuracao__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBarranavUser = view.findViewById(R.id.BarraNavegacaoConfigLivro_User)
        temaUser = view.findViewById(R.id.switchTema_User)
        fonteSizeUser = view.findViewById(R.id.barraTamanhoFonte_User)
        sairUser = view.findViewById(R.id.sairLayout)

        btnBarranavUser.setNavigationOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        })

        temaUser.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                mudarTemaUser(isChecked)
            }
        })

        fonteSizeUser.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mudarTamFonteUser(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        sairUser.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                mostrarPopupSairUser()
            }
        })
    }
    private fun mudarTemaUser(isNoturno: Boolean) {
        if (isNoturno) {
            Toast.makeText(context, "Tema noturno ativado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Tema diario ativado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mudarTamFonteUser(progress: Int) {
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

    private fun mostrarPopupSairUser() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Sair do Scientia")
            .setMessage("Você deseja sair da sua conta?")
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
                acaoCanceladaUser()
            }
            .setPositiveButton("Sair") { dialog, _ ->
                dialog.dismiss()
                sairDaContaUser()
            }
            .show()
    }

    private fun sairDaContaUser() {
        Toast.makeText(context, "Saindo da conta", Toast.LENGTH_SHORT).show()
        val intencao = Intent(requireContext(), TelaInicialDiv::class.java)
        startActivity(intencao)
        requireActivity().finish()
    }
    private fun acaoCanceladaUser(){
        Toast.makeText(context, "Ação cancelada", Toast.LENGTH_SHORT).show()
    }
}