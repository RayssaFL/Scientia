package com.example.scientia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class TelaBarraFixa_User : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_barra_fixa_user)

        fm = supportFragmentManager
        bottomNavigation = findViewById(R.id.bottomNavigation)

        fm.beginTransaction()
            .replace(R.id.containerFrameLayout, TelaHome_User::class.java, null)
            .commit()
    }

    override fun onStart() {
        super.onStart()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaHome_User::class.java, null)
                    .addToBackStack(null)
                    .commit()

                R.id.nav_events -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaEventos_User::class.java, null)
                    .addToBackStack(null)
                    .commit()

                R.id.nav_profile -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaPerfil_User::class.java, null)
                    .addToBackStack(null)
                    .commit()

                R.id.nav_contato -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaContato_User::class.java, null)
                    .addToBackStack(null)
                    .commit()
            }
            true
        }
    }
}
