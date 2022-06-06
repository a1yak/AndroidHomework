package com.example.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import java.util.*
import kotlinx.android.synthetic.main.fragment_hw1.*
import com.example.fragments.databinding.FragmentHw1Binding
import kotlin.random.Random


class FragmentHW1 : Fragment() {

    private val randomed = rand(1, 9)
    private val riddles = hashMapOf("Что это такое: синий, большой, с усами и полностью набит зайцами?" to "Троллейбус", "Вспушит она свои бока, Свои четыре уголка, И тебя, как ночь настанет, Все равно к себе притянет." to "Подушка",
        "Не ездок, а со шпорами, Не будильник, а всех будит." to "Петух", "Сижу верхом, Не ведаю на ком." to "Шапка","Ношу их много лет, не знаю им счета" to "Волосы",
        "Три глаза - три приказа,Красный - самый опасный." to "Светофор", "Кто приходит, кто уходит, Все ее за ручку водят." to "Дверь", "Кто меня сделал, не сказывает. Кто меня не знает, принимает. А кто знает, на двор не пускает." to "Фальшивая монета"
        , "Если б не было его, Не сказал бы ничего." to "Язык", "Кругом вода, а с питьем беда." to "Море")
    private var _binding: FragmentHw1Binding? = null
    private val binding get () = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHw1Binding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance() =
            FragmentHW1().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onStart() {
        super.onStart()
        binding.tvRiddle.setText("Riddle: " + riddles.keys.elementAt(randomed))
        binding.btnStarthw1.setOnClickListener {
            letters()
            magicBall()
            riddles()
            }
        }

    //for task summ letters
    fun letters() {
        var result: Int = 0
        val word2 = binding.etWordsSum2.text.toString().lowercase()
        val word1 = binding.etWordsSum1.text.toString().lowercase()

        result += convertWordToNumber(word1)
        result += convertWordToNumber(word2)
        binding.tvSumm.setText("Your words are add up to: ${result}")
    }

    //for task summ letters
    fun convertWordToNumber(word:String):Int
    {
        var number:Int=0
        val tempArray: CharArray = word.toCharArray()
        for(i in tempArray)
        {
            if(i.toInt()<1077){
                number += i.toInt() - 1071
            }
            else {number += i.toInt() - 1070}
        }
        return number
    }

//magic ball task
    fun magicBall() {
        var wish:Boolean=true
        val start = 1
        val end = 7
            when (rand(start, end))
            {
                1-> binding.tvBallAnswer.setText("Definitely yes")
                2-> binding.tvBallAnswer.setText("Definitely no")
                3-> binding.tvBallAnswer.setText("Probably yes")
                4-> binding.tvBallAnswer.setText("Probably no")
                5-> binding.tvBallAnswer.setText("There is a possibility")
                6-> binding.tvBallAnswer.setText("There is a chance")
                7-> binding.tvBallAnswer.setText("Incorrect question")
            }
        }

    //riddles task
    fun riddles()
    {
        var answer: String
            answer=binding.etRiddles.text.toString().lowercase()

                if (answer == riddles.values.elementAt(randomed).lowercase())
                {
                   binding.tvRiddleAnswer.setText("Correct!!!")
                }
                else
                {
                    binding.tvRiddleAnswer.setText("Incorrect,it's "+riddles.values.elementAt(randomed))
                }
            }


    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return Random(System.nanoTime()).nextInt(start, end + 1)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
