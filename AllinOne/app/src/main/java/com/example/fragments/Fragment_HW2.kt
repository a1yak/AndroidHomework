package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.fragments.databinding.FragmentHw2Binding
import java.util.*
import kotlin.random.Random


class Fragment_HW2 : Fragment() {

    private var _binding:FragmentHw2Binding? = null
    private val binding get()=_binding!!
    lateinit var animationText: Animation
    lateinit var animationButton:Animation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        animationText = AnimationUtils.loadAnimation(inflater.context, R.anim.flip_text)
        animationButton = AnimationUtils.loadAnimation(inflater.context, R.anim.button_bounce)
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
            binding.btnStarthw2cat.startAnimation(animationButton)
            this.activity?.supportFragmentManager?.beginTransaction()?.setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.fade_in, R.anim.fade_out)
                ?.replace(R.id.placeForFragments, frg_cat)
                ?.addToBackStack("Gucci")
                ?.commit()
        }

        binding.btnToScale.setOnClickListener {
            binding.tvSummOfNumbers.startAnimation(animationText)
            binding.tvSummOfValues.startAnimation(animationText)
            binding.tvRangeOfNumber.startAnimation(animationText)
            binding.introRange.startAnimation(animationText)
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
        val num = binding.etNumber.text.toString()
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
        fun newInstance() =
            Fragment_HW2().apply {
                arguments = Bundle().apply {
                }
            }
    }

}