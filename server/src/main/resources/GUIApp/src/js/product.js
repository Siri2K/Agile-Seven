var app = angular.module('products', []);

app.controller('list', function($scope, $http){
	$scope.test = "WA Sales Products";
	$http.get("products.php").then(function(response){$scope.products = response.data.productList;});

});