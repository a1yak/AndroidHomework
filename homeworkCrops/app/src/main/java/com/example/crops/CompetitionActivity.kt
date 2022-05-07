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
        val mnPotato: ProgressBar = findViewById(R.id.prgBar_minskPotato)
        val mnCauli: ProgressBar = findViewById(R.id.prgBar_minskCauliflower)
        val mnBeet: ProgressBar = findViewById(R.id.prgBar_minskBeet)

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
        val btPotato: ProgressBar = findViewById(R.id.prgBar_brestPotato)
        val btCauli: ProgressBar = findViewById(R.id.prgBar_brestCauliflower)
        val btBeet: ProgressBar = findViewById(R.id.prgBar_brestBeet)

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
        val gmlPotato: ProgressBar = findViewById(R.id.prgBar_gomelPotato)
        val gmlCauli: ProgressBar = findViewById(R.id.prgBar_gomelcauliflower)
        val gmlBeet: ProgressBar = findViewById(R.id.prgBar_gomelBeet)

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
        val hdnPotato: ProgressBar = findViewById(R.id.prgBar_grodnoPotato)
        val hdnCauli: ProgressBar = findViewById(R.id.prgBar_grodnoCauliflower)
        val hdnBeet: ProgressBar = findViewById(R.id.prgBar_grodnoBeet)

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
        val mgPotato: ProgressBar = findViewById(R.id.prgBar_mohilevPotato)
        val mgCauli: ProgressBar = findViewById(R.id.prgBar_mohilevCauliflower)
        val mgBeet: ProgressBar = findViewById(R.id.prgBar_mohilevBeet)

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
        val vtPotato: ProgressBar = findViewById(R.id.prgBar_vitebskPotato)
        val vtCauli: ProgressBar = findViewById(R.id.prgBar_vitebskCauliflower)
        val vtBeet: ProgressBar = findViewById(R.id.prgBar_vitebskBeet)

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
