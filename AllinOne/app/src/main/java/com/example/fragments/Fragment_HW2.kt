package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.FragmentHw2Binding
import java.util.*
import kotlin.random.Random


class Fragment_HW2 : Fragment() {

    private var _binding:FragmentHw2Binding? = null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHw2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnStarthw2.setOnClickListener {
            fromOnetoHundred()
            summOfnumbers()
            rangeOfNumber()
        }
        val frg_cat:Fragment = FragmentCat.newInstance()
        binding.btnStarthw2cat.setOnClickListener {
            this.activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.placeForFragments, frg_cat)
                ?.addToBackStack("Gucci")
                ?.commit()
        }
    }

    fun fromOnetoHundred()
    {
        val number=100
        var summfromOnetoHundred: Int =0
        summfromOnetoHundred = (number*(number+1))/2
        binding.tvSummOfValues.setText("Summ of all natural numbers from 1 to 100 is: $summfromOnetoHundred" )
    }

    fun summOfnumbers(){
        var num = binding.etNumber.getText().toString()
        var number:Int = Integer.parseInt(num)
        var result:Int=0
        var tempnumber:Int=0
        while(number>=1)
        {
            tempnumber=number%10
            result+=tempnumber
            number/=10
        }
        binding.tvSummOfNumbers.setText("Summ of all separate numbers in your number is: $result ...")
    }

    fun rangeOfNumber()
    {
        var numToCheck = rand(5, 155)
            binding.introRange.setText("Computer generated random number, it is: "+numToCheck)
            Thread.sleep(500)
            if(check(numToCheck))
            {
               binding.tvRangeOfNumber.setText("This number belongs to (25;100) interval")
            }
            else
            {
                binding.tvRangeOfNumber.setText("This number doesen't belong to (25;100) interval")
            }
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return Random(System.nanoTime()).nextInt(start, end + 1)
    }

    fun check(toCheck:Int):Boolean
    {
        if(toCheck>25&&toCheck<100)
        {
            return true
        }
        else {return false}
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_HW2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            Fragment_HW2().apply {
                arguments = Bundle().apply {
                }
            }
    }
}