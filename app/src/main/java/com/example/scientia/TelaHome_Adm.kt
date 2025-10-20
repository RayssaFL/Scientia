package com.example.scientia

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import android.widget.EditText
import android.widget.Toast

class TelaHome_Adm : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var searchBar: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_home_adm)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        toolbar = findViewById(R.id.toolbar)
        searchBar = findViewById(R.id.searchBar)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_users -> Toast.makeText(this, "Usuários", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawers()
            true
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.nav_events -> Toast.makeText(this, "Eventos", Toast.LENGTH_SHORT).show()
                R.id.nav_profile -> Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
            }
            true
        }

        searchBar.setOnEditorActionListener { v, _, _ ->
            Toast.makeText(this, "Pesquisando: ${v.text}", Toast.LENGTH_SHORT).show()
            true
        }
    }
}