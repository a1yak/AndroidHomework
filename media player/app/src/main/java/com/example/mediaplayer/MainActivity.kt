package com.example.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {
    lateinit var runnable: Runnable
     var handler: Handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_play: ImageButton = findViewById(R.id.btn_play)
        val btn_nextSong: ImageButton = findViewById(R.id.btn_next)
        val btn_prevSong :ImageButton = findViewById(R.id.btn_prev)
        var media: MediaPlayer? = MediaPlayer.create(this, R.raw.lada)
        val seekBar: SeekBar = findViewById(R.id.skBar_song)
        seekBar.max = media?.duration!!
        btn_play.setOnClickListener {
            if(media!!.isPlaying)
            {
                media?.start()
                btn_play.setImageResource(R.drawable.ic_baseline_pause_24)
            }
            else {
                media?.pause()
                btn_play.setImageResource(R.drawable.ic_play_arrow_24)
            }
        }

        btn_nextSong.setOnClickListener{

        }

        btn_prevSong.setOnClickListener {

        }

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser)
                {
                    media?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        media?.setOnCompletionListener {
        seekBar.progress = 0
            btn_play.setImageResource(R.drawable.ic_play_arrow_24)
        }

        runnable = Runnable {
            seekBar.progress = media!!?.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
        media?.release()
        media = null
    }

}