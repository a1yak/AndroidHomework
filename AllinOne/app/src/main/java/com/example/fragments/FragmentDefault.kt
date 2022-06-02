package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.fragments.databinding.FragmentDefaultBinding


class FragmentDefault : Fragment() {

    var _binding:FragmentDefaultBinding?=null
    val binding get() = _binding

    val frg_Crop = FragmentCrops()
    val frg_HW1 = FragmentHW1()
    val frg_HW2 = Fragment_HW2()
    val frg_Flags = Fragment_flags()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDefaultBinding.inflate(inflater, container, false)
       return binding?.root
    }

    override fun onStart() {
        super.onStart()

    binding?.btnCrops?.setOnClickListener {
        this.activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.placeForFragments, frg_Crop)
            ?.addToBackStack("Name")
            ?.commit()
    }

        binding?.btnFlags?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.placeForFragments, frg_Flags)
                ?.addToBackStack("Name")
                ?.commit()
        }

        binding?.btnHW1?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.placeForFragments, frg_HW1)
                ?.addToBackStack("Name")
                ?.commit()
        }

        binding?.btnHW2?.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.placeForFragments, frg_HW2)
                ?.addToBackStack("Name")
                ?.commit()
        }
    }
    companion object {

        fun newInstance() =
            FragmentDefault().apply {
                arguments = Bundle().apply {
                }
            }
    }
}