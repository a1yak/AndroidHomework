package com.example.crops

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.*
import org.w3c.dom.Text
import java.util.Collections.list

class CompetitionActivity : AppCompatActivity() {
    private val MAX_VALUE_BAR = 110
    private var listofparts:MutableList<String> = mutableListOf()

    lateinit var vtPotato: ProgressBar
    lateinit var vtCauli: ProgressBar
    lateinit var vtBeet: ProgressBar
    lateinit var btPotato: ProgressBar
    lateinit var btCauli: ProgressBar
    lateinit var btBeet: ProgressBar
    lateinit var mnPotato: ProgressBar
    lateinit var mnCauli: ProgressBar
    lateinit var mnBeet: ProgressBar
    lateinit var gmlPotato: ProgressBar
    lateinit var gmlCauli: ProgressBar
    lateinit var gmlBeet: ProgressBar
    lateinit var hdnPotato: ProgressBar
    lateinit var hdnCauli: ProgressBar
    lateinit var hdnBeet: ProgressBar
    lateinit var mgPotato: ProgressBar
    lateinit var mgCauli: ProgressBar
    lateinit var mgBeet: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition)

        GlobalScope.async {
            completeCompetition()
        }
    }


     fun winner(region: String):String
    {
        listofparts.add(region)
        return region
    }

suspend fun completeCompetition() = coroutineScope {


 val mn:Deferred<String> = async{
        //MINSK
       init("prgBar_minskPotato","prgBar_minskCauliflower","prgBar_minskBeet",mnPotato,mnCauli,mnBeet)

        while (mnPotato.progress != MAX_VALUE_BAR && mnCauli.progress != MAX_VALUE_BAR
            && mnBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(mnPotato, mnCauli, mnBeet)
            if(mnPotato.progress==100 && mnCauli.progress==100 && mnBeet.progress==100 )
                break
        }
        winner("Minsk region")

    }

 val bt:Deferred<String> = async {
        //BREST
     init("prgBar_brestPotato","prgBar_brestCauliflower","prgBar_brestBeet",btPotato,btCauli,btBeet)
        while (btPotato.progress != MAX_VALUE_BAR && btCauli.progress != MAX_VALUE_BAR
            && btBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(btPotato, btCauli, btBeet)
            if(btPotato.progress==100 && btCauli.progress==100 && btBeet.progress==100 )
                break
        }
        winner("Brest region")

    }


    val gm:Deferred<String> = async {
        //GOMEL
        init("prgBar_gomelPotato","prgBar_gomelCauliflower","prgBar_gomelBeet",gmlPotato,gmlCauli,gmlBeet)

        while (gmlPotato.progress != MAX_VALUE_BAR && gmlCauli.progress != MAX_VALUE_BAR
            && gmlBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(gmlPotato, gmlCauli, gmlBeet)
            if(gmlPotato.progress==100 && gmlCauli.progress==100 && gmlBeet.progress==100 )
                break
        }
        winner("Gomel region")

    }

val gn:Deferred<String> = async {
        //HRODNO
    init("prgBar_grodnoPotato","prgBar_grodnoCauliflower","prgBar_grodnoBeet",hdnPotato,hdnCauli,hdnBeet)

        while (hdnPotato.progress != MAX_VALUE_BAR && hdnCauli.progress != MAX_VALUE_BAR
            && hdnBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(hdnPotato, hdnCauli, hdnBeet)
            if(hdnPotato.progress==100 && hdnCauli.progress==100 && hdnBeet.progress==100 )
                break
        }
        winner("Hrodno region")

    }


val mog:Deferred<String> = async {
        //MOHILEV
        init("prgBar_mohilevPotato","prgBar_mohilevCauliflower","prgBar_mohilevBeet",mgPotato,mgCauli,mgBeet)
        while (mgPotato.progress != MAX_VALUE_BAR && mgCauli.progress != MAX_VALUE_BAR
            && mgBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(mgPotato, mgCauli, mgBeet)
            if(mgPotato.progress==100 && mgCauli.progress==100 && mgBeet.progress==100 )
                break
        }
        winner("Mohilev region")

    }


 val vt:Deferred<String> = async {
        //VITEBSK
       init("prgBar_vitebskPotato", "prgBar_vitebskCauliflower", "prgBar_vitebskBeet", vtPotato, vtCauli, vtBeet)

        while (vtPotato.progress != MAX_VALUE_BAR && vtCauli.progress != MAX_VALUE_BAR
            && vtBeet.progress != MAX_VALUE_BAR
        ) {
            delay(100)
            toAddToBar(vtPotato, vtCauli, vtBeet)
            if(vtPotato.progress==100 && vtCauli.progress==100 && vtBeet.progress==100 )
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
    val textViewWin:TextView = findViewById(R.id.textView_winners)
    textViewWin.setText("The winner is: ${listofparts[0]}")

}
}

fun init(nameP:String,nameC:String,nameB:String, prgPotato: ProgressBar, prgCauli: ProgressBar, prgBeet: ProgressBar)
{
     prgPotato = findViewById(R.id.nameP)
     prgCauli = findViewById(R.id.nameC)
     prgBeet = findViewById(R.id.nameB)

}

    fun toAddToBar(barPotato: ProgressBar, barCauliflower: ProgressBar, barBeetroot: ProgressBar)
    {
        var toAddP:Int =0
        var toAddC:Int =0
        var toAddB:Int =0

            toAddP = rand()
            toAddC = rand()
            toAddB = rand()

            barPotato.incrementProgressBy(toAddP)
            barCauliflower.incrementProgressBy(toAddC)
            barBeetroot.incrementProgressBy(toAddB)

    }



    fun rand(start: Int=1, end: Int=10): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
