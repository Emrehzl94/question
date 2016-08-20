
var questionApp = angular.module("questionApp",['ngRoute']);
questionApp.controller('UserController', UserController);
questionApp.controller('QuestionController', QuestionController);


questionApp.config(
  ['$routeProvider',
     function($routeProvider) {
     $routeProvider.
	     when('/signup',{
	         templateUrl:"/app/templates/user/userform.html",
	         controller: 'UserController as uc'
	      }).
         when('/userList',{
           templateUrl:"/app/templates/user/userlist.html",
           controller: 'UserController as uc'
           }).
           when('/askQuestion',{
            templateUrl:"/app/templates/question/questionform.html",
            controller: 'QuestionController as qc'
           }).
           when('/questionList',{
               templateUrl:"/app/templates/question/questionlist.html",
               controller: 'QuestionController as qc'
              }).
         otherwise({
           redirectTo: '/questionList'
           });
      }]);