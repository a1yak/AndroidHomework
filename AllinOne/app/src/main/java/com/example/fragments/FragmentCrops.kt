package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.fragments.databinding.FragmentCropsBinding
import kotlinx.coroutines.*


class FragmentCrops : Fragment() {

    private var _binding: FragmentCropsBinding? = null
    private val binding get() = _binding!!
    private val MAX_VALUE_BAR = 110
    private var listofparts: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCropsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() =
            FragmentCrops().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onStart() {
        super.onStart()
        //init()
        GlobalScope.async { completeCompetition()
            Toast.makeText(context, "The winner is: ${listofparts[0]}", Toast.LENGTH_LONG).show()
        }
    }


    fun winner(region: String): String {
        listofparts.add(region)
        return region
    }

    suspend fun completeCompetition() = coroutineScope {

        val mn: Deferred<String> = async {
            //MINSK
            while (binding.prgBarMinskPotato.progress != MAX_VALUE_BAR && binding.prgBarMinskCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarMinskBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarMinskPotato,
                    binding.prgBarMinskCauliflower,
                    binding.prgBarMinskBeet
                )
                if (binding.prgBarMinskPotato.progress == 100 && binding.prgBarMinskCauliflower.progress == 100
                    && binding.prgBarMinskBeet.progress == 100
                )
                    break
            }
            winner("Minsk region")
        }

        val bt: Deferred<String> = async {
            //BREST

            while (binding.prgBarBrestPotato.progress != MAX_VALUE_BAR && binding.prgBarBrestCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarBrestBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarBrestPotato,
                    binding.prgBarBrestCauliflower,
                    binding.prgBarBrestBeet
                )
                if (binding.prgBarBrestPotato.progress == 100 && binding.prgBarBrestCauliflower.progress == 100
                    && binding.prgBarBrestBeet.progress == 100
                )
                    break
            }
            winner("Brest region")
        }


        val gm: Deferred<String> = async {
            //GOMEL


            while (binding.prgBarGomelPotato.progress != MAX_VALUE_BAR && binding.prgBarGomelCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarGomelBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarGomelPotato,
                    binding.prgBarGomelCauliflower,
                    binding.prgBarGomelBeet
                )
                if (binding.prgBarGomelPotato.progress == 100 && binding.prgBarGomelCauliflower.progress == 100
                    && binding.prgBarGomelBeet.progress == 100
                )
                    break
            }
            winner("Gomel region")
        }

        val gn: Deferred<String> = async {
            //HRODNO
            while (binding.prgBarGrodnoPotato.progress != MAX_VALUE_BAR && binding.prgBarGrodnoCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarGrodnoBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarGrodnoPotato,
                    binding.prgBarGrodnoCauliflower,
                    binding.prgBarGrodnoBeet
                )
                if (binding.prgBarGrodnoPotato.progress == 100 && binding.prgBarGrodnoCauliflower.progress == 100
                    && binding.prgBarGrodnoBeet.progress == 100
                )
                    break
            }
            winner("Hrodno region")
        }


        val mog: Deferred<String> = async {
            //MOHILEV

            while (binding.prgBarMohilevPotato.progress != MAX_VALUE_BAR && binding.prgBarMohilevCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarMohilevBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarMohilevPotato,
                    binding.prgBarMohilevCauliflower,
                    binding.prgBarMohilevBeet
                )
                if (binding.prgBarMohilevPotato.progress == 100 && binding.prgBarMohilevCauliflower.progress == 100 && binding.prgBarMohilevBeet.progress == 100)
                    break
            }
            winner("Mohilev region")
        }


        val vt: Deferred<String> = async {
            //VITEBSK

            while (binding.prgBarVitebskPotato.progress != MAX_VALUE_BAR && binding.prgBarVitebskCauliflower.progress != MAX_VALUE_BAR
                && binding.prgBarVitebskBeet.progress != MAX_VALUE_BAR
            ) {
                delay(100)
                toAddToBar(
                    binding.prgBarVitebskPotato,
                    binding.prgBarVitebskCauliflower,
                    binding.prgBarVitebskBeet
                )
                if (binding.prgBarVitebskPotato.progress == 100 && binding.prgBarVitebskCauliflower.progress == 100
                    && binding.prgBarVitebskBeet.progress == 100
                )
                    break
            }
            winner("Vitebsk region")
        }
        mog.await()
        vt.await()
        mn.await()
        bt.await()
        gm.await()
        gn.await()
    }


    fun toAddToBar(barPotato: ProgressBar, barCauliflower: ProgressBar, barBeetroot: ProgressBar) {
        var toAddP: Int = 0
        var toAddC: Int = 0
        var toAddB: Int = 0

        toAddP = rand()
        toAddC = rand()
        toAddB = rand()

        barPotato.incrementProgressBy(toAddP)
        barCauliflower.incrementProgressBy(toAddC)
        barBeetroot.incrementProgressBy(toAddB)

    }

    fun rand(start: Int = 1, end: Int = 10): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
}