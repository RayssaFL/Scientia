package com.example.scientia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class TelaMenu_User : AppCompatActivity() {

    private lateinit var binding: ActivityTelaMenu_User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTelaMenu_User.inflate(layoutInflater)
        setContentView(R.layout.activity_tela_menu_user)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){
                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_events -> replaceFragment(Eventos())ss
                R.id.nav_contato -> replaceFragment(Contato())
                R.id.nav_profile -> replaceFragment(Profile())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}