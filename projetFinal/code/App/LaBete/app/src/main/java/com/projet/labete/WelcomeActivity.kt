package com.projet.labete

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.projet.labete.API.loadDataFromAPI
import com.projet.labete.dataBase.DatabaseHandler2


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnStart = findViewById<Button>(R.id.btnStart)

        val sharedPref = getSharedPreferences(getString(R.string.prefName),Context.MODE_PRIVATE)
        setSharedPref(sharedPref)

        if(sharedPref.getInt(getString(R.string.prefScene), 0) != 11) {
            btnStart.text = getString(R.string.welcome11)
        }

        btnStart.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //if(sharedPref.getInt(getString(R.string.prefChapter), -1) == 0)

        //variable pour la base de donne
        val context = this
        var db = DatabaseHandler2(context)


        //db.deletete()
        //db.majBaseDonne() //a executer une seule fois
        //if (db.doitEtreTelecharger(1)) println("coucou")
        loadDataFromAPI(db) //voir appelServeur.kt dans le dossier API

    }

    private fun setSharedPref(sharedPref: SharedPreferences){
        if(sharedPref.getInt(getString(R.string.prefChapter), -1) == -1){
            val editor = sharedPref.edit()
            editor.putBoolean(getString(R.string.prefMusic), true)
            editor.putBoolean(getString(R.string.prefSfx), true)
            editor.putInt(getString(R.string.prefScene), 11)
            editor.putInt(getString(R.string.prefChapter), 0)
            editor.commit()
        }
    }


}
