package com.example.coach

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_ID = "id"
val COL_AGE = "age"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR, " +
                COL_AGE + " INTEGER) "

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        //cv.put(COL_ID,user.id)
        cv.put(COL_AGE,user.age)
        var result = db.insert(TABLE_NAME,null,cv)
       if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()

    }

    fun insertDataB(){
        Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
    }
    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do{
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name =  result.getString(result.getColumnIndex(COL_NAME))
                user.age =  result.getString(result.getColumnIndex(COL_AGE)).toInt()
                list.add(user)
            } while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

}