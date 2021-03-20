angular.module('market', []).controller('indexController', function ($scope, $http) {

    $scope.fillTable = function() {
        $http({
            url: 'http://localhost:5555/cloud/front/js/market/products',
            method: 'GET',
        }).then(function (response) {
            $scope.productsList = response.data;
        });
    };

    $scope.fillTable();

});