package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_crops:Button = findViewById(R.id.btn_crops)
        val btn_flags:Button = findViewById(R.id.btn_flags)
        val btn_hw1:Button = findViewById(R.id.btn_HW1)
        val btn_hw2:Button = findViewById(R.id.btn_HW2)
        val frg_Crop = FragmentCrops.newInstance()
        val frg_HW1 = FragmentHW1.newInstance()
        val frg_HW2 = Fragment_HW2.newInstance()
        val frg_Flags = Fragment_flags.newInstance()

       btn_crops.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeForFragments, frg_Crop)
                .addToBackStack("Name")
                .commit()
        }

        btn_flags.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeForFragments, frg_Flags)
                .addToBackStack("Gucci")
                .commit()
        }

        btn_hw1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeForFragments, frg_HW1)
                .addToBackStack("Gucci")
                    .commit()
        }

        btn_hw2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeForFragments, frg_HW2)
                .addToBackStack("Gucci")
                    .commit()
        }
    }
}