package com.projet.labete


import androidx.core.animation.*
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.*
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.projet.labete.dataBase.DatabaseHandler2
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnRepeat
import com.projet.labete.dataBase.*
import com.projet.labete.dataBase.Scene
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences(getString(R.string.prefName),Context.MODE_PRIVATE)


        //      /!\Plus besoin de passer par findViewById/!\

        //val btnChoixA = findViewById<Button>(R.id.btnChoixA)
        //val btnChoixB = findViewById<Button>(R.id.btnChoixB)
        //val btnChoixC = findViewById<Button>(R.id.btnChoixC)
        //val btnChoixD = findViewById<Button>(R.id.btnChoixD)
        val icoInventaire = findViewById<ImageView>(R.id.imgInventaire)
        val icoOptions = findViewById<ImageView>(R.id.imgOptions)

        val animatorTxt = ObjectAnimator.ofFloat(txtRecit, View.TRANSLATION_Y, -1000f).apply { duration = 1000 }
        val animatorA = ObjectAnimator.ofFloat(btnChoixA, View.TRANSLATION_X, -1000f).apply { duration = 1000 }
        val animatorB = ObjectAnimator.ofFloat(btnChoixB, View.TRANSLATION_X, 1000f).apply { duration = 1000 }
        val animatorC = ObjectAnimator.ofFloat(btnChoixC, View.TRANSLATION_Y, 1000f).apply { duration = 1000 }
        val fadeAnim = ObjectAnimator.ofFloat(fondNoir, View.ALPHA, 0.0f, 1.0f).setDuration(1000)

        fadeAnim.repeatCount = 1
        fadeAnim.repeatMode = ObjectAnimator.REVERSE
        animatorTxt.repeatCount = 1
        animatorTxt.repeatMode = ObjectAnimator.REVERSE
        animatorA.repeatCount = 1
        animatorA.repeatMode = ObjectAnimator.REVERSE
        animatorB.repeatCount = 1
        animatorB.repeatMode = ObjectAnimator.REVERSE
        animatorC.repeatCount = 1
        animatorC.repeatMode = ObjectAnimator.REVERSE

        //variable pour la base de donne
        val context = this
        var db = DatabaseHandler2(context)

        var laScene : Scene = db.readData(sharedPref.getInt(getString(R.string.prefScene),11))
        refresh(laScene)

        btnChoixA.setOnClickListener() {
            val editor = sharedPref.edit()
            editor.putInt(getString(R.string.prefScene), laScene.sceneSuivante1)
            editor.commit()

            laScene = db.readData(sharedPref.getInt(getString(R.string.prefScene), laScene.sceneSuivante1))

            animatorA.doOnRepeat {
                refresh(laScene)
            }

            fadeAnim.start()
            animatorTxt.start()
            animatorA.start()
            animatorB.start()
            animatorC.start()
        }

        btnChoixB.setOnClickListener() {
            val editor = sharedPref.edit()
            editor.putInt(getString(R.string.prefScene), laScene.sceneSuivante2)
            editor.commit()

            laScene = db.readData(sharedPref.getInt(getString(R.string.prefScene), laScene.sceneSuivante2))

            animatorA.doOnRepeat {
                refresh(laScene)
            }

            fadeAnim.start()
            animatorTxt.start()
            animatorA.start()
            animatorB.start()
            animatorC.start()
        }

        btnChoixC.setOnClickListener() {
            val editor = sharedPref.edit()
            editor.putInt(getString(R.string.prefScene), laScene.sceneSuivante3)
            editor.commit()

            laScene = db.readData(sharedPref.getInt(getString(R.string.prefScene), laScene.sceneSuivante3))

            animatorA.doOnRepeat {
                refresh(laScene)
            }

            fadeAnim.start()
            animatorTxt.start()
            animatorA.start()
            animatorB.start()
            animatorC.start()
        }

        icoOptions.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        icoInventaire.setOnClickListener {
            val intent = Intent(this, Inventory::class.java)
            startActivity(intent)
        }

    }

    private fun refresh(laScene: Scene){
        txtRecit.text = laScene.recitTexte
        btnChoixA.text = laScene.texteChoix1
        btnChoixB.text = laScene.texteChoix2
        btnChoixC.text = laScene.texteChoix3
        btnChoixD.text = ""

        val cl = findViewById<ConstraintLayout>(R.id.ConstraintLayout)
        if(laScene.idScene % 3 == 0) {
            cl.setBackgroundResource(R.drawable.bg_hallway_a)
        } else if(laScene.idScene % 3 == 1) {
            cl.setBackgroundResource(R.drawable.bg_hallway_b)
        } else {
            cl.setBackgroundResource(R.drawable.bg_cell)
        }

        if(btnChoixB.text == "") {
            btnChoixB.visibility = View.INVISIBLE
            // TODO : Déplacer bouton A sous la textView
        } else {
            btnChoixB.visibility = View.VISIBLE
            // TODO : Remettre le bouton A à sa position initiale
        }

        if(btnChoixC.text == "") {
            btnChoixC.visibility = View.INVISIBLE
        } else {
            btnChoixC.visibility = View.VISIBLE
        }

        if(btnChoixD.text == "") {
            btnChoixD.visibility = View.INVISIBLE
        } else {
            btnChoixD.visibility = View.VISIBLE
        }
        if(btnChoixB.text == "") {
            btnChoixB.visibility = View.INVISIBLE
        } else {
            btnChoixB.visibility = View.VISIBLE
        }
    }

}
