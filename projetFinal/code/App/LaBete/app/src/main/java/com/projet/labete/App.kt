package com.projet.labete

import android.app.Application

open class App : Application() {

    // Déclaration et initialisation des variables globales a l'application
    // (accessibles à tout moment, peu importe l'activité en cours).
    // Variables publiques accessibles via : (this.application as App).variable

    var objects = BooleanArray(10) {false}  //mettre dans la bd locale
}