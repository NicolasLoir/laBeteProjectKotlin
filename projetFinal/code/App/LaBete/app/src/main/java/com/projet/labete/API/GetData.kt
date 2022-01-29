package com.projet.labete.API

class GetChoix(val idChoix : Int, val texteChoix: String)
class GetCombat(val idCombat : Int, val adversaire : Int, val sceneSuivante: Int)
class GetComporte(val idRecit : Int, val idChoix : Int, val sceneSuivante : Int)
class GetLieu(val idLieu : Int, val nomLieu : String, val sonLieu : Int, val imageLieu : Int)
class GetObjet(val idObjet : Int, val nomObjet : String, val typeObjet : String, val usageObjet : String, val imageObjet : Int)
class GetPersonnage(val idPerso : Int, val nomPerso : String, val typePerso : String, val rolePerso : String, val imagePerso : Int)
class GetRecit(val idRecit : Int, val texteRecit : String)
class GetScene (val idScene : Int, val lieuScene : Int, val recitScene : Int, val chapitreScene : Int, val combatScene : Int)
