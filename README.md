# ChooseYourRoom  
  
## Contexte  
Projet Etudiant réalisé dans le cadre du module de "Architecture et développement des applications WEB".  
Mmebre de l'équipe :   
* Chesneau Vincent  
* Léthoré Antoine  
* Libot Raphaël  
  
## Le projet  
Le site permet la consultation des salle libre au sein de l'université de Nantes.  
Il permet une fois connecter de réserver une salle et de consulter ses réservations.  
  
## Endpoints  
| Nom du endpoint|     Entête HTTP     |  Parametres     |  Description    |
| ------------- | -------------   | ---------       | ---------      |
| listeSalleLibrescreneau | GET   | année, mois, jour, creneau       | Permet de récupérer les créneaux de libre pour une date et un créneau donné.      |
|insertCreneau|GET|date, salle, creneau, email, nbplace|Permet d'ajouter la réservation au datastore.|
|mesReservation|GET|email|Permet de récupére les créneau associés à l'adresse email passée en parametre.|
|removeCreneauEntity|DELETE|Identitfiant du créneau|Permet de supprimer un des créneaux.|
