package com.example.adapterviewhomework

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val picture: ImageView? = view.findViewById(R.id.picture)
    val model: TextView? = view.findViewById(R.id.carModel)
    val price: TextView? = view.findViewById(R.id.carPrice)

    fun bind(car: Car) {
    picture?.setImageResource(car.picture)
    model?.text = car.model
    price?.text = car.price

}

}