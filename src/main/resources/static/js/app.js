var haApp = angular.module('haApp', [ 'ngMessages', 'ngAnimate', 'ngAria', 'ngMaterial',
        'ngRoute', 'haControllers', 'haServices', 'md.data.table', 'ngSanitize']);

haApp.config([
        '$routeProvider',
        '$mdThemingProvider',
        function ($routeProvider, $mdThemingProvider) {
            $mdThemingProvider.theme('default').primaryPalette('deep-orange');

            $routeProvider.when('/gameboard', {
                templateUrl : 'misc/gameBoard.html', controller : 'GameboardCtrl'
            }).otherwise({
                redirectTo : '/gameboard'
            });
        } ]);