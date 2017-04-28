/**
 * Created by E-M on 4/1/2017.
 */
var app = angular.module('hello')
    .controller('lessonCtrl', function ($scope, testService) {
        console.log("in js ctrl")

        $scope.showHelpers = false;
        testService.getQuestions(2, function (response) {
            $scope.questions = response;
        });

        /*  $scope.q.selectedChoice = {};*/

        $scope.submit = function () {
            $scope.myTxt = "You clicked submit!";


            for (var i = 0; i < $scope.questions.length; i++) {
                console.log($scope.questions[i].selectedChoice);


            }
            if ($scope.questions[0].selectedChoice.choiceText != "correct: 4") {
                console.log("wrong!");

                testService.getHelperQuestions(2, $scope.questions, function (response) {
                    $scope.helperQuestions = response;
                    $scope.showHelpers = true;

                });

            }


        };

        $scope.check = function (q) {
            console.log("changed!");

            console.log(q.selectedChoice);
        };


        console.log("in js ctrl " + $scope.questions)
    });