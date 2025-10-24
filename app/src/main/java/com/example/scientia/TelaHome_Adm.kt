package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class TelaHome_Adm : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var searchBar: EditText
    private lateinit var cardTotalLiv: CardView
    private lateinit var cardLivEmp: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_home__adm, container, false)

        drawerLayout = view.findViewById(R.id.drawerLayoutHome)
        navigationView = view.findViewById(R.id.navigationView)
        toolbar = view.findViewById(R.id.toolbar)
        searchBar = view.findViewById(R.id.searchBar)
        cardTotalLiv = view.findViewById(R.id.cardTotalLiv)
        cardLivEmp = view.findViewById(R.id.cardLivEmp)

        val menu = navigationView.menu
        val consultarItem = menu.findItem(R.id.nav_consultar_emprestimo)
        val groupConsultar = menu.findItem(R.id.group_consultar)

        (activity as? androidx.appcompat.app.AppCompatActivity)?.setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            activity,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_consultar_emprestimo -> {
                    val isVisible = !(groupConsultar?.isVisible ?: false)
                    groupConsultar?.isVisible = isVisible
                    consultarItem.setIcon(if (isVisible) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down)
                    return@setNavigationItemSelectedListener false
                }
                R.id.nav_em_andamento -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaEmpAndamento_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_realizado -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaEmpRealizados_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_adicionar_livro -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaAdicionarLivro_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_autorizar_emprestimo -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaAutorizarEmp_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_devolucao_livro -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaDevolucao_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_users -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaListaUsuarios_Adm())
                        .addToBackStack(null)
                        .commit()
                }
                R.id.nav_settings -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.containerFrameLayout, TelaConfiguracao_Adm())
                        .addToBackStack(null)
                        .commit()
                }
            }
            drawerLayout.closeDrawers()
            true
        }

        cardTotalLiv.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, TelaTodosLivros_Adm())
                .addToBackStack(null)
                .commit()
        }

        cardLivEmp.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, TelaEmpAndamento_Adm())
                .addToBackStack(null)
                .commit()
        }

        searchBar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, TelaTodosLivros_Adm())
                .addToBackStack(null)
                .commit()
        }

        searchBar.setOnEditorActionListener { v, _, _ ->
            Toast.makeText(activity, "Pesquisando: ${v.text}", Toast.LENGTH_SHORT).show()
            true
        }

        return view
    }
}
