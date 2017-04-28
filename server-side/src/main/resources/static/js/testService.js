/**
 * Created by E-M on 3/4/2017.
 */
var app = angular.module('hello')
    .service("testService", function ($http) {
        this.getQuestions = function (testId, callback) {
            console.log("in js service")
            $http.get('/tests/' + testId)
                .success(function (data) {
                    callback(data);
                });

        }


        this.getHelperQuestions = function (testId, answeredQuestions, callback) {
            console.log("in js service");

            var answerMap = processAnswerList(answeredQuestions);

            var url = "/tests/" + testId + "/submit?qs=";

            var ids = answeredQuestions.map(function (obj) {
                return obj.id;
            });

            console.log(ids.toString());

            url = url + ids.toString();


            console.log(url);
            $http.post("/tests/" + testId + "/submit", {answerMap: answerMap})
                .success(function (data) {
                    callback(data);
                });

        }


        function processAnswerList(list) {

            var map = [];

            for (var i = 0; i < list.length; i++) {
                var item = new Object();

                item.q = list[i].id;
                item.a = list[i].selectedChoice.id;

                map.push(item);
            }

            console.log(map);

            return map;

        }


    });