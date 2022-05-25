package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.databinding.FragmentCatBinding

class FragmentCat : Fragment() {

    private var _binding: FragmentCatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnCalculateJump.setOnClickListener {
            catsdata()
        }
    }
    companion object {
        fun newInstance() =
            FragmentCat().apply {
                arguments = Bundle().apply {
                }
            }
    }
    fun abilityToJump(cat: Cat, table: Table):Boolean
    {
        cat.getStrength()
        if(cat.jumpHeight()>table.seeHeight())
        {
            return true
        }
        else
        {
            return false
        }
    }

    fun catsdata()
    {
        var name:String
        var weight:Float
        var height:Float=0.0f
        var length:Int
        var tempCheck = true
        var material = ""
            name=binding.etCatName.text.toString()
            weight=binding.etCatWeight.text.toString().toFloat()
            length=Integer.parseInt(binding.etCatLenght.text.toString())
            val cat= Cat(name, weight, height, length)
            height=binding.etTableHeight.text.toString().toFloat()
            length=Integer.parseInt(binding.etTableLenght.text.toString())

            material = binding.etTableMaterial.text.toString()

            val table= Table(height, length, material.lowercase())
            tempCheck=table.isStable(material)
            if(abilityToJump(cat, table) && tempCheck)
            {
               Toast.makeText(context,"${cat.getName()} can jump up this table", Toast.LENGTH_LONG).show()
            }
            else {Toast.makeText(context,"${cat.getName()} can't jump up this table, it's too high for it", Toast.LENGTH_LONG).show()}

        }
    }

