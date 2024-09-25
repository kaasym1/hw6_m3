package com.example.hw6_m3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, FirstFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.container, SecondFragment()).commit()
    }
}