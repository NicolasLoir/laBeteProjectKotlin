package com.example.labete

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "bd"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        //===== METHODES DE CREATION DE TABLE (si non existante) =====
        //TABLE SCENE
        val createTableScene = " CREATE TABLE IF NOT EXISTS Scene ( " +
                "idScene INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lieuScene INTEGER DEFAULT NULL, " +
                "recitScene INTEGER DEFAULT NULL, " +
                "chapitreScene INTEGER NOT NULL, " +
                "combatScene INTEGER DEFAULT NULL, " +
                "FOREIGN KEY recitScene REFERENCES Recit(idRecit) )"

        db?.execSQL(createTableScene)

        //TABLE RECIT
        val createTableRecit = " CREATE TABLE IF NOT EXISTS Recit ( " +
                "idRecit INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "texteRecit VARCHAR DEFAULT NULL) "


        db?.execSQL(createTableRecit)

        //TABLE CHOIX
        val createTableChoix = " CREATE TABLE IF NOT EXISTS Choix ( " +
                "idChoix INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "texteChoix VARCHAR DEFAULT NULL)"

        db?.execSQL(createTableChoix)

        //TABLE COMPORTE
        val createTableComporte =  " CREATE TABLE IF NOT EXISTS Comporte ( " +
                "idRecit INTEGER NOT NULL, " +
                "idChoix INTEGER NOT NULL, " +
                "sceneSuivante INTEGER NOT NULL, " +
                "PRIMARY KEY (idRecit,idChoix), " +
                "FOREIGN KEY idRecit REFERENCES Recit(idRecit), " +
                "FOREIGN KEY idChoix REFERENCES Choix(idChoix) ) "

        db?.execSQL(createTableComporte)

        //TABLE LIEU
        val createTableLieu =  " CREATE TABLE IF NOT EXISTS Lieu ( " +
                "idLieu INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomLieu VARCHAR NULL, " +
                "sonLieu INTEGER DEFAULT NULL," +
                "imageLieu INTEGER DEFAULT NULL)"

        db?.execSQL(createTableLieu)

        //TABLE PERSONNAGE
        val createTablePersonnage =  " CREATE TABLE IF NOT EXISTS Personnage ( " +
                "idPerso INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomPerso VARCHAR DEFAULT NULL, " +
                "typePerso VARCHAR DEFAULT NULL," + //foe or ally ?
                "rolePerso VARCHAR DEFAULT NULL," +
                "imagePerso INTEGER DEFAULT NULL)"

        db?.execSQL(createTablePersonnage)

        //TABLE INTERVIENT
        val createTableIntervient =  " CREATE TABLE IF NOT EXISTS Intervient ( " +
                "idPerso INTEGER NOT NULL, " +
                "idScene INTEGER NOT NULL" +
                "PRIMARY KEY (idPerso,idScene)"

        db?.execSQL(createTableIntervient)

        //TABLE COMBAT
        val createTableCombat =  " CREATE TABLE IF NOT EXISTS Combat ( " +
                "idCombat INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "adversaire INTEGER NOT NULL, " +
                "sceneSuivante INTEGER NOT NULL)"

        db?.execSQL(createTableCombat)

        //TABLE SANTE

        val createTableSante =  " CREATE TABLE IF NOT EXISTS Sante ( " +
                "idSante INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "brasG INTEGER NOT NULL, " +
                "brasD INTEGER NOT NULL, " +
                "jambeG INTEGER NOT NULL, " +
                "jambeD INTEGER NOT NULL, " +
                "teteTronc INTEGER NOT NULL)"

        db?.execSQL(createTableSante)


    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    //===== METHODES D'INSERTION =====
    fun insertScene(idScene : Int, lieuScene : Int, recitScene : Int, chapitreScene : Int, combatScene : Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idScene",idScene)
        cv.put("lieuScene",lieuScene)
        cv.put("recitScene", recitScene)
        cv.put("chapitreScene", chapitreScene)
        cv.put("combatScene", combatScene)
        var result = db.insert("Scene",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }


    fun insertRecit(idRecit : Int, texteRecit : String){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idRecit",idRecit)
        cv.put("texteRecit",texteRecit)

        var result = db.insert("Recit",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun insertChoix(idChoix : Int, texteChoix : String){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idChoix",idChoix)
        cv.put("texteChoix",texteChoix)

        var result = db.insert("Choix",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun insertComporte(idRecit : Int, idChoix : Int, sceneSuivante : Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idRecit",idRecit)
        cv.put("idChoix",idChoix)
        cv.put("sceneSuivante",sceneSuivante)

        var result = db.insert("Comporte",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }


    fun insertLieu(idLieu : Int, nomLieu : String, sonLieu : Int, imageLieu : Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idLieu",idLieu)
        cv.put("nomLieu",nomLieu)
        cv.put("sonLieu", sonLieu)
        cv.put("imageLieu", imageLieu)
        var result = db.insert("Lieu",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun insertPersonnage(idPerso : Int, nomPerso : String, typePerso : String, rolePerso : String, imagePerso : String){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idPerso",idPerso)
        cv.put("nomPerso",nomPerso)
        cv.put("typePerso", typePerso)
        cv.put("rolePerso", rolePerso)
        cv.put("imagePerso", imagePerso)

        var result = db.insert("Personnage",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }
//manque insert , Sante, Combat

    fun insertIntervient(idPerso : Int, idScene : Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idPerso",idPerso)
        cv.put("idScene",idScene)

        var result = db.insert("Intervient",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun insertCombat(idCombat : Int, adversaire : Int, sceneSuivante: Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idCombat",idCombat)
        cv.put("adversaire",adversaire)
        cv.put("sceneSuivante",sceneSuivante)

        var result = db.insert("Combat",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun insertSante(idSante : Int, brasG : Int, brasD: Int, jambeG : Int, jambeD: Int, teteTronc : Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("idSante",idSante)
        cv.put("brasG",brasG)
        cv.put("brasD",brasD)
        cv.put("jambeG",jambeG)
        cv.put("jambeD",jambeD)
        cv.put("teteTronc",teteTronc)

        var result = db.insert("Sante",null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }


    //===== METHODES DE RECUPERATION =====

    fun readData(indiceScene : Int) : Scene{
        var laScene = Scene()

        val db = this.readableDatabase
        var query = "SELECT combatScene, idRecit, texteRecit " +
                "FROM Scene s, Recit r NATURAL JOIN Comporte NATURAL JOIN Choix " +
                "WHERE s.recitScene = r.idRecit " +
                "AND s.idScene = " + indiceScene
        var result = db.rawQuery(query,null)

        if(result.moveToFirst()){
            laScene.idScene = indiceScene
            //laScene.chapitre = result.getString(result.getColumnIndex("chapitreScene")).toInt()
            laScene.idRecit = result.getString(result.getColumnIndex("idRecit")).toInt()
            laScene.recitTexte =  result.getString(result.getColumnIndex("recitTexte"))
            laScene.combatScene = result.getString(result.getColumnIndex("combatScene")).toInt()

            query = "SELECT texteChoix, sceneSuivante " +
                    "FROM Recit r NATURAL JOIN Comporte NATURAL JOIN Choix " +
                    "WHERE r.idRecit = " + laScene.idRecit

            result = db.rawQuery(query,null)

            if(result.moveToFirst()){
                laScene.sceneSuivante1 = result.getString(result.getColumnIndex("sceneSuivante")).toInt()
                laScene.texteChoix1 =  result.getString(result.getColumnIndex("texteChoix"))

                if(result.moveToNext()){
                    laScene.sceneSuivante2 = result.getString(result.getColumnIndex("sceneSuivante")).toInt()
                    laScene.texteChoix2 =  result.getString(result.getColumnIndex("texteChoix"))

                    if(result.moveToNext()){
                        laScene.sceneSuivante3 = result.getString(result.getColumnIndex("sceneSuivante")).toInt()
                        laScene.texteChoix3 =  result.getString(result.getColumnIndex("texteChoix"))
                    }
                }
            }
        }
        result.close()
        db.close()
        return laScene
    }
}