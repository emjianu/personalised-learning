var app = angular.module('hello', ["ngRoute"])
    .controller('home', function ($scope, $http) {

        $scope.btnText = "Yes, take the test";

        $scope.startBtnText = "Start";


        $http.get('/resource').success(function (data) {
            console.log(data);
        })
    });


app.config(function($routeProvider){
    $routeProvider
    /*    .when('/',{
            templateUrl:  '/index.html'
        })*/
        .when('/second',{
            templateUrl: '/views/secondPage.html',
            controller: 'testCtrl'
        })
        .when('/lesson/:lessonId',{
            templateUrl:  '/views/lesson.html',
            controller: 'lessonCtrl'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});