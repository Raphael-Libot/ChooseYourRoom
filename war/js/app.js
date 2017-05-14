var app = angular.module('chooseYourRoom', ['ngRoute']);

app.controller('MainCtrl', function($scope) {
  $scope.name = 'world';
  
  
  function httpGet(theUrl)
  {
      var xmlHttp = new XMLHttpRequest();
      xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
      xmlHttp.send( null );
      return xmlHttp.responseText;
  }
  //$scope.data = httpGet("https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/creneauentity");

  data = httpGet("https://proweb-158114.appspot.com/_ah/api/creneauentityendpoint/v1/creneauentity");
  //document.getElementById('demo').innerHTML = data;

  $scope.items = data;
  
});
