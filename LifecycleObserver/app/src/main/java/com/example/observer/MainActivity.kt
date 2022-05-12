package com.example.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private val server = MyServer()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(server)
    }
}