var haControllers = angular.module('haControllers', []);

haControllers.controller('GameboardCtrl', [
        '$scope',
        '$mdDialog',
        'TicTacToeGames',
        '$interval',
        function ($scope, $mdDialog, service, $interval) {
            $scope.$emit("load", "gameboard");

            $scope.boardDimension = 3;
            
            function get() {
                execute($scope, $mdDialog, true, service.get(), {}, function (
                        result) {
                    $scope.game = result;
                });
            }

            $scope.begin = function () {
                execute($scope, $mdDialog, true, service.begin(), {
                    boardDimension : $scope.boardDimension
                }, function (result) {
                    $scope.game = result;
                });
            }

            $scope.move = function (x, y) {
                execute($scope, $mdDialog, true, service.move(), {
                    x : x,
                    y : y
                }, function (result) {
                    $scope.game = result;
                });
            }

            get();
        } ]);
