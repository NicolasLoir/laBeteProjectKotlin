package com.projet.labete

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.popup_enter, R.anim.fade_out)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_settings)

        val btnRetour = findViewById<Button>(R.id.btnRetour)
        val imgMusic = findViewById<ImageView>(R.id.imgMusic)
        val imgSFX = findViewById<ImageView>(R.id.imgSFX)
        val imgQuitter = findViewById<ImageView>(R.id.imgQuitter)
        val lblMusic = findViewById<TextView>(R.id.lblMusic)
        val lblSFX = findViewById<TextView>(R.id.lblSFX)

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        imgMusic.setOnClickListener() {
            editor.putBoolean(getString(R.string.prefMusic), !sharedPref.getBoolean(getString(R.string.prefMusic), true))
            editor.commit()
            if(sharedPref.getBoolean(getString(R.string.prefMusic), true)) {
                imgMusic.setImageResource(R.drawable.icon_music_on)
                lblMusic.text = "Musique : ON"
            } else {
                imgMusic.setImageResource(R.drawable.icon_music_off)
                lblMusic.text = "Musique : OFF"
            }
        }

        imgSFX.setOnClickListener() {
            editor.putBoolean(getString(R.string.prefSfx), !sharedPref.getBoolean(getString(R.string.prefSfx), true))
            editor.commit()
            if(sharedPref.getBoolean(getString(R.string.prefSfx), true)) {
                imgSFX.setImageResource(R.drawable.icon_sound_on)
                lblSFX.text = "Sons : ON"
            } else {
                imgSFX.setImageResource(R.drawable.icon_sound_off)
                lblSFX.text = "Sons : OFF"
            }
        }

        imgQuitter.setOnClickListener() {
            finish()
            exitProcess(0)
        }

        btnRetour.setOnClickListener() {
            finish()
        }

        if(sharedPref.getBoolean(getString(R.string.prefMusic), true)) {
            imgMusic.setImageResource(R.drawable.icon_music_on)
            lblMusic.text = "Musique : ON"
        } else {
            imgMusic.setImageResource(R.drawable.icon_music_off)
            lblMusic.text = "Musique : OFF"
        }
        if(sharedPref.getBoolean(getString(R.string.prefSfx), true)) {
            imgSFX.setImageResource(R.drawable.icon_sound_on)
            lblSFX.text = "Sons : ON"
        } else {
            imgSFX.setImageResource(R.drawable.icon_sound_off)
            lblSFX.text = "Sons : OFF"
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        finish()
    }

}
