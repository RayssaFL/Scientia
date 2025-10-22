package com.example.scientia

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar

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

        val cardsLayout = findViewById<LinearLayout>(R.id.linearLayout3)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    cardsLayout.visibility = View.VISIBLE
                    toolbar.visibility = View.VISIBLE
                    val fragment = supportFragmentManager.findFragmentById(R.id.container)
                    if (fragment != null) {
                        supportFragmentManager.beginTransaction().remove(fragment).commit()
                    }
                    true
                }
                R.id.nav_events -> {
                    cardsLayout.visibility = View.GONE
                    toolbar.visibility = View.GONE
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, TelaEmpAndamento_Adm())
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    cardsLayout.visibility = View.GONE
                    toolbar.visibility = View.GONE
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, TelaTodosLivros_Adm())
                        .commit()
                    true
                }
                else -> false
            }
        }

        searchBar.setOnEditorActionListener { v, _, _ ->
            Toast.makeText(this, "Pesquisando: ${v.text}", Toast.LENGTH_SHORT).show()
            true
        }
    }
}
