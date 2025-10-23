package com.example.scientia

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class TelaBarraFixa_Adm : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_barra_fixa_adm)

        fm = supportFragmentManager
        bottomNavigation = findViewById(R.id.bottomNavigation)

        fm.beginTransaction().replace(R.id.containerFrameLayout, TelaHome_Adm::class.java, null)
            .commit()

    }

    override fun onStart() {
        super.onStart()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_home -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaHome_Adm::class.java, null)
                    .addToBackStack(null)
                    .commit()

                R.id.nav_events -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaEventos_Adm::class.java, null)
                    .addToBackStack(null)
                    .commit()

                R.id.nav_profile -> fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, TelaPerfil_Adm::class.java, null)
                    .addToBackStack(null)
                    .commit()
            }
            true
        }
    }
}