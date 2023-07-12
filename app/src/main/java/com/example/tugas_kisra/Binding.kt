package com.example.tugas_kisra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugas_kisra.databinding.ActivityMainBinding



class Binding : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navView.setOnClickListener {
            Toast.makeText(this, "sudah pakai binding ya pak", Toast.LENGTH_LONG).show()
        }
    }
}