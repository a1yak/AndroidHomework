package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.databinding.FragmentLoginBinding


class FragmentLogin : Fragment() {

lateinit var  _binding: FragmentLoginBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val frg_default = FragmentDefault.newInstance()
        binding.btnConfirm.setOnClickListener{
            if (binding.etLogin.text.toString() == "admin" &&
                binding.etPassword.text.toString() == "password"
            ){
                this.activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.placeForFragments, frg_default)?.commit()
            } else {
                Toast.makeText(context,"Incorrect password or login, try again",Toast.LENGTH_SHORT).show()
            }
        }

    }
    companion object {
        fun newInstance() =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                }
            }
    }
}