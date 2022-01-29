package com.projet.labete.API

import android.content.ContentValues.TAG
import android.util.Log
import com.projet.labete.dataBase.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun loadDataFromAPI(db : DatabaseHandler2){


    //pour le faire qu'une fois
    if (db.doitEtreTelecharger(1)) {
        //--------------------------------------DEBUT RECUP API---------------------------------------

        /*
        création du client retrofit / configuration
        ajout de l'url sur lequel le client fait son appel
        on ajoute le converter(Gson) qui permet de traduire le JSON
         */
        val retrofitJson = Retrofit.Builder()
            .baseUrl("https://webdev.iut-orsay.fr/Projet_AS_2020/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // genere une implementation de l'interface HttpServiceJson
        val serviceJson = retrofitJson.create(HttpServiceJsonProjet::class.java)

        //--------------------------------------CHOIX---------------------------------------
        val callJsonAllChoix = serviceJson.getAllChoix()
        //on utilise enqueue pour que l'appel se fasse en asynchrone, pour ne pas bloquer l'application
        callJsonAllChoix.enqueue(object : Callback<List<GetChoix>> {
            override fun onFailure(call: Call<List<GetChoix>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<GetChoix>>,
                response: Response<List<GetChoix>>
            ) {
                val tousLesChoix = response.body()

                if (tousLesChoix != null) {
                    for (c in tousLesChoix) {
                        db.insertChoix(c.idChoix, c.texteChoix)
                        Log.i(TAG, " un exemple de choix : ${c.idChoix} : ${c.texteChoix}")
                    }
                }

            }
        })
        //--------------------------------------COMBATS---------------------------------------
        val callJsonAllCombats = serviceJson.getAllCombats()
        callJsonAllCombats.enqueue(object : Callback<List<GetCombat>> {
            override fun onFailure(call: Call<List<GetCombat>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetCombat>>,
                response: Response<List<GetCombat>>
            ) {
                val tousLesCombats = response.body()
                if(tousLesCombats != null){
                    for( l in tousLesCombats){
                        db.insertCombat(l.idCombat, l.adversaire, l.sceneSuivante)
                        Log.i(TAG,"${l.idCombat} : ${l.adversaire}")
                    }
                }

            }
        })
        //--------------------------------------COMPORTE---------------------------------------
        val callJsonAllComportes = serviceJson.getAllComportes()
        callJsonAllComportes.enqueue(object : Callback<List<GetComporte>> {
            override fun onFailure(call: Call<List<GetComporte>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetComporte>>,
                response: Response<List<GetComporte>>
            ) {
                val tousLesComporte = response.body()

                if(tousLesComporte != null){
                    for( l in tousLesComporte){
                        db.insertComporte(l.idRecit, l.idChoix, l.sceneSuivante)
                        Log.i(TAG,"${l.idRecit} : ${l.idChoix} : ${l.sceneSuivante}")
                    }
                }



            }
        })

        //--------------------------------------LIEUX---------------------------------------
        //récuperation des choix depuis la base de données
        val callJsonAllLieux = serviceJson.getAllLieux()
        callJsonAllLieux.enqueue(object : Callback<List<GetLieu>> {
            override fun onFailure(call: Call<List<GetLieu>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<GetLieu>>, response: Response<List<GetLieu>>) {
                val tousLesLieux = response.body()

                if (tousLesLieux != null) {
                    Log.i(
                        TAG,
                        "Def dans API/appelServeur. Utilisation de la fonction dans WelcomeActivity"
                    )
                    for (l in tousLesLieux) {
                        db.insertLieu(l.idLieu, l.nomLieu, l.sonLieu, l.imageLieu)
                        Log.i(TAG, "${l.idLieu} : ${l.nomLieu}")
                    }
                }

            }
        })
        //-------------------------------------- ?? OBJETS ??---------------------------------------
        val callJsonAllObjets = serviceJson.getAllObjets()
        callJsonAllObjets.enqueue(object : Callback<List<GetObjet>> {
            override fun onFailure(call: Call<List<GetObjet>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetObjet>>,
                response: Response<List<GetObjet>>
            ) {
                val tousLesObjets = response.body()

                if(tousLesObjets != null){
                    for( l in tousLesObjets){
                        //Log.i(TAG,"${l.idObjet} : ${l.nomObjet} : ${l.typeObjet}")
                        //db.insert
                    }
                }

            }
        })
        //--------------------------------------PERSONNAGES---------------------------------------
        val callJsonAllPersonnages = serviceJson.getAllPersonnages()
        callJsonAllPersonnages.enqueue(object : Callback<List<GetPersonnage>> {
            override fun onFailure(call: Call<List<GetPersonnage>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetPersonnage>>,
                response: Response<List<GetPersonnage>>
            ) {
                val tousLesPersonnages = response.body()

                if(tousLesPersonnages != null){
                    for( l in tousLesPersonnages){
                        Log.i(TAG,"${l.idPerso} : ${l.nomPerso} : ${l.typePerso}")
                        db.insertPersonnage(l.idPerso, l.nomPerso, l.typePerso, l.rolePerso, l.imagePerso)
                    }
                }

            }
        })
        //--------------------------------------RECITS---------------------------------------
        val callJsonAllRecit = serviceJson.getAllRecits()
        callJsonAllRecit.enqueue(object : Callback<List<GetRecit>> {
            override fun onFailure(call: Call<List<GetRecit>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetRecit>>,
                response: Response<List<GetRecit>>
            ) {
                val tousLesRecits = response.body()

                if(tousLesRecits != null){
                    for( l in tousLesRecits){
                        db.insertRecit(l.idRecit, l.texteRecit)
                        Log.i(TAG,"${l.idRecit} : ${l.texteRecit} ")
                    }
                }

            }
        })
        //--------------------------------------SCENE---------------------------------------
        val callJsonAllScenes = serviceJson.getAllScenes()
        callJsonAllScenes.enqueue(object : Callback<List<GetScene>> {
            override fun onFailure(call: Call<List<GetScene>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<GetScene>>,
                response: Response<List<GetScene>>
            ) {
                val tousLesScene = response.body()

                if(tousLesScene != null){
                    for( l in tousLesScene){
                        db.insertScene(l.idScene, l.lieuScene, l.recitScene, l.chapitreScene, l.combatScene)
                        Log.i(TAG,"${l.idScene} : ${l.lieuScene} : ${l.recitScene} ")
                    }
                }

            }
        })

        db.setEtatChapitre(1, 0) //desormais on ne charge plus le chapitre 1
    }

}
