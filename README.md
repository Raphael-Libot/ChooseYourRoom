# ChooseYourRoom
Projet Etudiant Master 1 


| Nom du endpoint|     Entête HTTP     |  Parametres     |  Description    |
| ------------- | -------------   | ---------       | ---------      |
| listeSalleLibrescreneau | GET   | année, mois, jour, creneau       | Permet de récupérer les créneaux de libre pour une date et un créneau donné.      |
|insertCreneau|GET|date, salle, creneau, email, nbplace|Permet d'ajouter la réservation au datastore.|
|mesReservation|GET|email|Permet de récupére les créneau associés à l'adresse email passée en parametre.|
|removeCreneauEntity|DELETE|Identitfiant du créneau|Permet de supprimer un des créneaux.|
