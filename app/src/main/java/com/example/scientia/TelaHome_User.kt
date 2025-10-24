package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class TelaHome_User : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var searchBar: EditText
    private lateinit var btnNotificacao: ImageButton

    private lateinit var rvRecentes: RecyclerView
    private lateinit var rvRecomendados: RecyclerView
    private lateinit var recentesAdapter: BookAdapter
    private lateinit var recomendadosAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_tela_home__user, container, false)

        drawerLayout = v.findViewById(R.id.drawerLayoutHomeUser)
        navigationView = v.findViewById(R.id.navigationViewUser)
        toolbar = v.findViewById(R.id.toolbarUser)
        searchBar = v.findViewById(R.id.searchBarUser)
        btnNotificacao = v.findViewById(R.id.btnNotificacao)

        rvRecentes = v.findViewById(R.id.rvLivrosRecentes)
        rvRecomendados = v.findViewById(R.id.rvLivrosRecomendados)

        (activity as? androidx.appcompat.app.AppCompatActivity)?.setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            activity, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val btnChat = v.findViewById<ImageButton>(R.id.floatingActionButton)

        btnChat.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, TelaChat_User())
                .addToBackStack(null)
                .commit()
        }


        btnNotificacao.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, TelaEventos_User())
                .addToBackStack(null)
                .commit()
        }

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_hist_livros -> parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaHistoricoLivro_User())
                    .addToBackStack(null).commit()
                R.id.nav_autores -> parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaAutores_User())
                    .addToBackStack(null).commit()
                R.id.nav_emp_abertos -> parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaEmpAberto_User())
                    .addToBackStack(null).commit()
                R.id.nav_avaliacoes -> parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaAvaliacoes_User())
                    .addToBackStack(null).commit()
                R.id.nav_config -> parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaChat_User())
                    .addToBackStack(null).commit()
            }
            drawerLayout.closeDrawers()
            true
        }

        recentesAdapter = BookAdapter(this)
        recomendadosAdapter = BookAdapter(this)
        setupHorizontalRecycler(rvRecentes, recentesAdapter)
        setupHorizontalRecycler(rvRecomendados, recomendadosAdapter)

        recentesAdapter.submitList(mockRecentes())
        recomendadosAdapter.submitList(mockRecomendados())

        return v
    }

    private fun setupHorizontalRecycler(rv: RecyclerView, adapter: BookAdapter) {
        rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        rv.adapter = adapter
        LinearSnapHelper().attachToRecyclerView(rv)
    }

    private fun mockRecentes(): List<BookFull> = listOf(
        BookFull(1, "Computação em Nuvem", "Autor A", 2020, "Descrição do livro A", R.drawable.capa_computacao_nuvem),
        BookFull(2, "Matemática Discreta", "Autor B", 2018, "Descrição do livro B", R.drawable.capa_matematica_discreta),
        BookFull(3, "Ciência da Computação", "Autor C", 2021, "Descrição do livro C", R.drawable.capa_ciencia_computacao)
    )

    private fun mockRecomendados(): List<BookFull> = listOf(
        BookFull(4, "Algoritmos", "Autor D", 2019, "Descrição do livro D", R.drawable.capa_computacao_nuvem),
        BookFull(5, "Programação Java", "Autor E", 2020, "Descrição do livro E", R.drawable.capa_matematica_discreta)
    )
}