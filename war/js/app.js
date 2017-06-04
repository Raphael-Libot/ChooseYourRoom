//,'ngMaterial', 'ngMessages'
var app = angular.module('chooseYourRoom', ['ngRoute', 'angular-loading-bar']);

app.controller('MainCtrl', function($scope,$http) {
  
	this.myDate = new Date();
	  this.isOpen = false;
	
	$scope.name = 'world';
	$scope.infoO = "";
	$scope.sallesLibresF = "";
	$scope.infoLF="Test";
	
  
  $http({
		  url: 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleLibres/2017-06-06T12%3A30%3A00',
		  method: 'GET'
	}).then(function successCallback(response) {
		
		if(angular.isUndefined(response)){
			$scope.infoL =  "Pas de salle libres";
		}else{
			$scope.sallesLibres = response;
			$scope.infoL = "Il y a " +  response.data.items.length + " salles libres";
		}
		
	  }, function errorCallback(response) {
		  $scope.infoL = 'non !';
	  });
  /*
  $http({
	  url: 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleOccupees/2017-06-06T12%3A30%3A00',
	  method: 'GET'
	}).then(function successCallback(response) {
		
		if(angular.isUndefined(response)){
			$scope.infoO = "Toutes les salles sont libres";
		}else{
			$scope.salleOccupees = response;
			$scope.infoO = "Il y a " +  response.data.items.length + " salles occupées";
		}
		
	    
	  }, function errorCallback(response) {
		  $scope.infoO = 'non !';
	  });*/
  
  //var userNameInput = element(by.model('date'));
  
  $scope.rechercheSalle = function() {
	  
	 
		var url = 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleLibres/' + $scope.annee + "-" + $scope.mois + "-"+ $scope.jour + "T"
	  + $scope.heure + "%3A" + $scope.minute + "%3A00";
		
	  $http({
		  url: url,
		  method: 'GET'
	}).then(function successCallback(response) {
		//window.alert(response.data.items.length);
		if(angular.isUndefined(response)){
			$scope.sallesLibresF = "";
			$scope.infoLF = "Pas de salle libres";
		}else{
			$scope.sallesLibresF = response;
			$scope.infoLF = "Il y a " +  response.data.items.length + " salles libres";
		}
	  }, function errorCallback(response) {
		  
		  $scope.infoLF = "non !";
	  });
	  
	  /*
	  var url2 = 'https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/listeSalleOccupees/' + $scope.annee + "-" + $scope.mois + "-"+ $scope.jour + "T"
	  + $scope.heure + "%3A" + $scope.minute + "%3A00";
	 
	$http({
	  url: url2,
	  method: 'GET'
	}).then(function successCallback(response) {
		//$scope.infoO = 'test ! ' + angular.isUndefined(response) + response.data.items.length;
		if(angular.isUndefined(response)){
			$scope.salleOccupees = "";
			$scope.infoO = "Toutes les salles sont libres";
		}else{
			$scope.salleOccupees = response;
			$scope.infoO = "Il y a " +  response.data.items.length + " salles occupées";
		}
	  }, function errorCallback(response) {
		  
		  $scope.infoO = 'non !';
	  });*/
	  
  };

  //2017-06-06T12%3A30%3A00
  //2017-06-10T12%3A30%3A00
  // response.data.items.length
});
