package com.projet.labete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class Inventory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.popup_enter, R.anim.fade_out)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_inventory)

        val btnRetour = findViewById<Button>(R.id.btnRetour)

        btnRetour.setOnClickListener(){
            finish()
        }
    }
}
