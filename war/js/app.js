//,'ngMaterial', 'ngMessages'
var app = angular.module('chooseYourRoom', ['ngRoute', 'angular-loading-bar']);

app.controller('MainCtrl', function($scope, $http) {


    var creneau;
    var moisPropre;
    var jourPropre;
    var creneau;

    this.myDate = new Date();
    this.isOpen = false;

    $scope.name = 'world';
    $scope.infoO = "";
    $scope.sallesLibresF = "";
    $scope.infoLF = "Test";

    var ladate = new Date();

    var creneau;
    var heureActuelle = ladate.getHours();
    var minuteActuelle = ladate.getMinutes();
    minuteActuelle = minuteActuelle / 100;
    heureActuelle = heureActuelle + minuteActuelle;

    if (heureActuelle >= 8 && heureActuelle <= 9.29)
        creneau = 1;
    else if (heureActuelle >= 9.30 && heureActuelle <= 10.59)
        creneau = 2;
    else if (heureActuelle >= 11 && heureActuelle <= 12.29)
        creneau = 3;
    else if (heureActuelle >= 12.30 && heureActuelle <= 13.59)
        creneau = 4;
    else if (heureActuelle >= 14 && heureActuelle <= 15.29)
        creneau = 5;
    else if (heureActuelle >= 15.30 && heureActuelle <= 16.59)
        creneau = 6;
    else if (heureActuelle >= 17 && heureActuelle <= 18.29)
        creneau = 7;
    else if (heureActuelle >= 18.30 && heureActuelle <= 20)
        creneau = 8;

    $http({
        url: 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleLibrescreneau/' + ladate.getFullYear() + "_" + (ladate.getMonth() + 1) + "_" + ladate.getDate() + '/' + creneau,
        method: 'GET'
    }).then(function successCallback(response) {

        if (angular.isUndefined(response)) {
            $scope.infoL = "Pas de salle libres";
        } else {
            $scope.sallesLibres = response;
            $scope.infoL = "Il y a " + response.data.items.length + " salles libres";
        }

    }, function errorCallback(response) {
        $scope.infoL = 'non !';
    });


    $scope.rechercheSalle = function() {
    	document.getElementById('res').style.display = "block";
    	document.getElementById('reponse').style.display = "none";
    	
        creneau = $scope.creneau;
        creneau = creneau.charAt(0);
        moisPropre = $scope.mois;
        moisPropre = moisPropre.replace("0", "");
        jourPropre = $scope.jour;
        jourPropre = jourPropre.replace("0", "");

        var url = 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleLibrescreneau/' + $scope.annee + "_" + moisPropre + "_" + jourPropre + "/" + creneau;
        $http({
            url: url,
            method: 'GET'
        }).then(function successCallback(response) {
            if (angular.isUndefined(response)) {
                $scope.sallesLibresF = "";
                $scope.infoLF = "Pas de salle libres";
            } else {
                $scope.sallesLibresF = response;
                $scope.infoLF = "Il y a " + response.data.items.length + " salles libres";
            }
        }, function errorCallback(response) {

            $scope.infoLF = "non !";
        });
    };

 

    $scope.reserver = function(salle) {
    	
        moisPropre = $scope.mois;
        jourPropre = $scope.jour;

        creneau = document.getElementById('creneau');
        creneau = creneau.options[creneau.selectedIndex].text;
        creneau = creneau.charAt(0);

        profile = document.getElementById('email').innerHTML;


        date = $scope.annee + "_" + moisPropre + "_" + jourPropre;

        capacite = document.getElementById('capacite'); 
        capacite = capacite.options[capacite.selectedIndex].text;
        
        
        urlinsert =  'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/insertCreneau/' + date + '/' + salle + '/' + creneau + '/' + profile + '/' + capacite ;
        alert(urlinsert);
        
        $http({
            url: urlinsert,
            method: 'GET'
        }).then(function successCallback(response) {

            if (angular.isUndefined(response)) {
            	document.getElementById('res').style.display = "none";
            	document.getElementById('reponse').style.display = "block";
            	document.getElementById('reponse').innerHTML = "Problème lors de la réservation";
            } else {
            	document.getElementById('res').style.display = "none";
            	document.getElementById('reponse').style.display = "block";
            	document.getElementById('reponse').innerHTML = "Reservation enregistré";
            }

        }, function errorCallback(response) {
        	document.getElementById('res').style.display = "none";
        	document.getElementById('reponse').style.display = "block";
        	document.getElementById('reponse').innerHTML = "Problème lors de la réservation";
        });

    };
    
    $scope.mesReservation = function(){
    	
    	document.getElementById('mesReservation').style.display = "block";
    	
    	var email = document.getElementById('email').innerHTML;
    	email = email.replace("@","%40");
        $http({
            url: 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/mesReservation/' + email,
            method: 'GET'
        }).then(function successCallback(response) {
            if (angular.isUndefined(response)) {
                $scope.mesResas = "Vous n'avez pas de réservation";
            } else {
            	$scope.mesResas = response;
            }
        }, function errorCallback(response) {
        	$scope.mesResas = "Vous n'avez pas de réservation - BUG";
        });
    	
    };

    
    $scope.supprimer  = function(id){
    	id = id.replace(/@/, '%40');
    	id = id.replace(/ /, '%20');
    	
    	$http({
            url: 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/creneauentity/' + id,
            method: 'DELETE'
        }).then(function successCallback(response) {
            if (angular.isUndefined(response)) {
                alert("problème lors de la suppression")
            } else {
            	$scope.mesReservation();
            }
        }, function errorCallback(response) {
        	alert("problème lors de la suppression")
        });
    };
});