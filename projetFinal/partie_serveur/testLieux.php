<?php
  //les informations d'identification du base de données
  $host = 'localhost';
  $user = 'prj-as-2020';
  $pass = 'bdpAoc2w3rKKc8Hy';
  $db = 'prj-as-2020';
  //Créer une connexion à la base de données
  $conn = new mysqli($host, $user, $pass, $db);
  $conn->set_charset("utf8");
  //Vérifier la connexion
  if ($conn->connect_errno) {
     printf("Échec de la connexion à la base de données");
     exit();
  }
  //Récupérer les lignes de la table users
  $res = $conn->query("SELECT * FROM Lieu");
  //Initialiser un tableau
  $data = array();
  //Récupérer les lignes
  while ( $row = $res->fetch_assoc())  {
     $data[] = $row;
  }
  //Afficher le tableau au format JSON
  echo json_encode($data);
 
?>