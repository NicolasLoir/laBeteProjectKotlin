package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    //--------------------------------------DEBUT RECUP API---------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //récuperation des choix depuis la base de données
        val retrofitJson = Retrofit.Builder()
            .baseUrl("https://webdev.iut-orsay.fr/Projet_AS_2020/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val serviceJson = retrofitJson.create(HttpServiceJsonProjet::class.java)

        //--------------------------------------CHOIX---------------------------------------
        val callJsonAllChoix = serviceJson.getAllChoix()
        callJsonAllChoix.enqueue(object : Callback<List<GetChoix>> {
            override fun onFailure(call: Call<List<GetChoix>>, t: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call<List<GetChoix>>, response: Response<List<GetChoix>>) {
                val tousLesChoix = response.body()
                /*
                if (tousLesChoix != null) {
                    for (c in tousLesChoix)
                        Log.i(TAG, " un exemple de choix : ${c.idChoix} : ${c.texteChoix}")
                }
                */
            }
        })
        //--------------------------------------COMBATS---------------------------------------
        val callJsonAllCombats = serviceJson.getAllCombats()
        callJsonAllCombats.enqueue(object : Callback<List<GetCombat>>{
            override fun onFailure(call: Call<List<GetCombat>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetCombat>>, response: Response<List<GetCombat>>) {
                val tousLesCombats = response.body()
                /*
                if(tousLesCombats != null){
                    for( l in tousLesCombats){
                        Log.i(TAG,"${l.idCombat} : ${l.adversaire}")
                    }
                }
                 */
            }
        })

        //--------------------------------------LIEUX---------------------------------------
        val callJsonAllLieux = serviceJson.getAllLieux()
        callJsonAllLieux.enqueue(object : Callback<List<GetLieu>>{
            override fun onFailure(call: Call<List<GetLieu>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetLieu>>, response: Response<List<GetLieu>>) {
                val tousLesLieux = response.body()
                /*
                if(tousLesLieux != null){
                    for( l in tousLesLieux){
                        Log.i(TAG,"${l.idLieu} : ${l.nomLieu}")
                    }
                }
                 */
            }
        })
        //--------------------------------------OBJETS---------------------------------------
        val callJsonAllObjets = serviceJson.getAllObjets()
        callJsonAllObjets.enqueue(object : Callback<List<GetObjet>>{
            override fun onFailure(call: Call<List<GetObjet>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetObjet>>, response: Response<List<GetObjet>>) {
                val tousLesObjets = response.body()
                /*
                if(tousLesObjets != null){
                    for( l in tousLesObjets){
                        Log.i(TAG,"${l.idObjet} : ${l.nomObjet} : ${l.typeObjet}")
                    }
                }
                 */
            }
        })
        //--------------------------------------PERSONNAGES---------------------------------------
        val callJsonAllPersonnages = serviceJson.getAllPersonnages()
        callJsonAllPersonnages.enqueue(object : Callback<List<GetPersonnage>>{
            override fun onFailure(call: Call<List<GetPersonnage>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetPersonnage>>, response: Response<List<GetPersonnage>>) {
                val tousLesPersonnages = response.body()
                /*
                if(tousLesPersonnages != null){
                    for( l in tousLesPersonnages){
                        Log.i(TAG,"${l.idPerso} : ${l.nomPerso} : ${l.typePerso}")
                    }
                }
                 */
            }
        })
        //--------------------------------------RECITS---------------------------------------
        val callJsonAllRecit = serviceJson.getAllRecits()
        callJsonAllRecit.enqueue(object : Callback<List<GetRecit>>{
            override fun onFailure(call: Call<List<GetRecit>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetRecit>>, response: Response<List<GetRecit>>) {
                val tousLesRecits = response.body()
                /*
                if(tousLesRecits != null){
                    for( l in tousLesRecits){
                        Log.i(TAG,"${l.idRecit} : ${l.texteRecit} ")
                    }
                }
                */
            }
        })
        //--------------------------------------SCENE---------------------------------------
        val callJsonAllScenes = serviceJson.getAllScenes()
        callJsonAllScenes.enqueue(object : Callback<List<GetScene>>{
            override fun onFailure(call: Call<List<GetScene>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onResponse(call: Call<List<GetScene>>, response: Response<List<GetScene>>) {
                val tousLesRecits = response.body()
                /*
                if(tousLesRecits != null){
                    for( l in tousLesRecits){
                        Log.i(TAG,"${l.idScene} : ${l.lieuScene} : ${l.recitScene} ")
                    }
                }
                 */
            }
        })




    }

}




