
var questionApp = angular.module("questionApp",['ngRoute']);
questionApp.controller('UserController', UserController);


questionApp.config(
  ['$routeProvider',
     function($routeProvider) {
     $routeProvider.
	     when('/signup',{
	         templateUrl:"/app/templates/userform.html",
	         controller: 'UserController as uc'
	      }).
         when('/list', {
           templateUrl:"/app/templates/userlist.html",
           controller: 'UserController as uc'
           }).
         otherwise({
           redirectTo: '/list'
           });
      }]);