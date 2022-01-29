package com.example.testapplication

class GetChoix(val idChoix : Int, val texteChoix: String)
class GetCombat(val idCombat : Int, val adversaire : String)
class GetLieu(val idLieu : Int, val nomLieu : String, sonLieu : Int, imageLieu : Int)
class GetObjet(val idObjet : Int, val nomObjet : String, val typeObjet : String, usageObjet : String, imageObjet : Int)
class GetPersonnage(val idPerso : Int, val nomPerso : String, val typePerso : String, rolePerso : String, imagePerso : Int)
class GetRecit(val idRecit : Int, val texteRecit : String)
class GetScene (val idScene : Int, val lieuScene : Int, val recitScene : Int, chapitreScene : Int, combatScene : Int)