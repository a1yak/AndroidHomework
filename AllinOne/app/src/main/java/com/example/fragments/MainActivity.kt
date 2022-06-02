package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frg_login = FragmentLogin.newInstance("admin", "password")

        supportFragmentManager.beginTransaction()
            .replace(R.id.placeForFragments, frg_login)
            .addToBackStack("Name")
            .commit()
    }
}