package com.example.tugas_kisra

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tugas_kisra.databinding.ActivityMainBinding
import com.example.tugas_kisra.util.Pref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {
            if (it.itemId==R.id.navigation_notifications){
                val s = Pref(this)
                if (s.getIslogin()){
                    Log.d("Tag","Sudah Login")

                }else {
                    startActivity(Intent(this,Activity_login::class.java))
                    Log.d("Tag","Belum Login Pindah ke Hal Login" )
                }
            }else{
                Log.d("Tag","OnCreate yg lain"+it.itemId)
                navController.navigate(it.itemId)
            }
            return@setOnItemSelectedListener true
        }
        val btnprofile = findViewById<Button>(R.id.btn_profile)

        btnprofile.setOnClickListener {
            val intent = Intent(this, Profil::class.java)
            startActivity(intent)



        }
    }

}



