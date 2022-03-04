var site = "";
var haServices = angular.module('haServices', [ 'ngResource' ]);

function createResource($resource, url, method, isArray) {
    return $resource(wsurl + url, {}, {
        execute : {
            method : method,
            params : {},
            isArray : isArray,
        }
    });
}

haServices.factory("TicTacToeGames", [ "$resource", function ($resource) {
    return {
        begin : function () {
            return createResource($resource, "/game/begin", "POST", false);
        },
        move : function () {
            return createResource($resource, "/game/move", "PUT", false);
        },
        get : function () {
            return createResource($resource, "/game", "GET", false);
        }
    };
} ]);