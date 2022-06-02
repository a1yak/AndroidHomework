package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fragments.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : Fragment() {

    private var _LOGIN: String?=null
    private var _PASSWORD: String?=null
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

            when {
                binding.etLogin.text.toString() == "" ->Toast.makeText(context, "Some required fields are empty",Toast.LENGTH_SHORT).show()
                binding.etPassword.text.toString() == "" ->Toast.makeText(context, "Some required fields are empty",Toast.LENGTH_SHORT).show()
            }

            if (binding.etLogin.text.toString() == _LOGIN &&
                binding.etPassword.text.toString() == _PASSWORD){
                this.activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.placeForFragments, frg_default)?.commit()
                }
            else {
                Toast.makeText(context,"Incorrect password or login, try again",Toast.LENGTH_SHORT).show()
            }
        }

    }
    companion object {
        fun newInstance(login: String, password: String) =
            FragmentLogin().apply {
               _LOGIN = login
                _PASSWORD=password
            }
    }
}