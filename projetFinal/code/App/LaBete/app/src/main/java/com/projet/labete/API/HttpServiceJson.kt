package com.projet.labete.API

import com.projet.labete.API.*
import retrofit2.Call
import retrofit2.http.GET

interface HttpServiceJsonProjet {
    @GET("choix.php")
    fun getAllChoix() : Call<List<GetChoix>>

    @GET("combat.php")
    fun getAllCombats() : Call<List<GetCombat>>

    @GET("comporte.php")
    fun getAllComportes() : Call<List<GetComporte>>

    @GET("lieu.php")
    fun getAllLieux() : Call<List<GetLieu>>

    @GET("objet.php")
    fun getAllObjets() : Call<List<GetObjet>>

    @GET("personnage.php")
    fun getAllPersonnages() : Call<List<GetPersonnage>>

    @GET("recit.php")
    fun getAllRecits() : Call<List<GetRecit>>

    @GET("scene.php")
    fun getAllScenes() : Call<List<GetScene>>









}