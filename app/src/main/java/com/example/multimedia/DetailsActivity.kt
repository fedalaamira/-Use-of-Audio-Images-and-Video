package com.example.multimedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    private var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val extras = intent.extras
        val mot=findViewById<TextView>(R.id.mot)
        val description=findViewById<TextView>(R.id.description)
        val img=findViewById<ImageView>(R.id.imageView)
        val audio=findViewById<Button>(R.id.audio)
        val desc= arrayListOf<String>("a1","b1","c1")
        mot.setText("mot")
        description.setText(desc[extras.getInt("pos")])
        audio.setOnClickListener { lireAudio(R.raw.idir) }


    }
    fun lireAudio(resId: Int) {
        if (mp == null) {        //set up MediaPlayer
            mp = MediaPlayer.create(this, resId)

            try {
                mp!!.prepare()

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        if (!mp!!.isPlaying())
            mp!!.start()
        else
            mp!!.pause()
    }

}




