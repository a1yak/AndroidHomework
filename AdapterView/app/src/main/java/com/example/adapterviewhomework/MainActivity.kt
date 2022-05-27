package com.example.adapterviewhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list=findViewById<RecyclerView>(R.id.lv_carList)
         list.adapter = CarListAdapter(this, setListOfCars())
    }

    fun setListOfCars():List<Car>{
        return listOf(
            Car("Kia Sorrento", "30400$",R.drawable.kiasorrento),
            Car("2019 Ford Focus", "20000$", R.drawable.ford),
            Car("Audi A4", "40000$", R.drawable.audia4),
            Car("BMW Series 2", "37000$", R.drawable.bmw2series),
            Car("Chevrolet Blazer", "34000$", R.drawable.chevrolet_blazer_angularfront),
            Car("Hyundai Accent","18000$",R.drawable.hyundai_accent_angularfront),
            Car("Volkswagen Tiguan","27000$",R.drawable.volkswagen_tiguan_angularfront),
            Car("Volkswagen Jetta","16000$",R.drawable.volkswagen_jetta_angularfront),
            Car("Mercedes Benz A-class","34000$",R.drawable.mercedes_benz_a_class_sedan_angularfront),
            Car("Mazda CX30","21000$",R.drawable.mazda_cx_30_angularfront),
        )
    }
}