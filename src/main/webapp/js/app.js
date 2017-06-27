var app = angular.module('bloggyApp', [ 'ngRoute', 'ui.bootstrap' ]);

app.config(function($routeProvider) {
	$routeProvider.when("/all", {
		templateUrl : "partials/list-users.html",
		controller : "ShowAllController"

	}).when("/add", {
		templateUrl : "partials/add-user.html",
		controller : "AddUserController"
	}).when("/find", {
		templateUrl : "partials/find-user.html",
		controller : "FindUserController"
	}).when("/view/:id", {
		templateUrl : "partials/view-user.html",
		controller : "ViewUserController"
	}).otherwise({
		redirectTo : '/all'
	})
});

app.controller('AddUserController', function($scope, $http) {

	$scope.add = function() {
		$http.post("/bloggy/api/user", $scope.user).then(function(response) {
			$scope.status = response.data + ' has got created successfully.';
		});
	};

});

app.controller('ShowAllController', function($scope, $http) {
	$http.get("/bloggy/api/user").then(function(response) {
		$scope.users = response.data;
		console.log(response.data.length);
		if(response.data.length == 0) {
			$scope.status = 'No bloggers registered yet...';
		}
	});	
	
	$scope.deleteUser = function(id) {
		$http.delete("/bloggy/api/user/" + id).then(
				function(response) {
					if(response.data == true) {
						$scope.status = id + ' has been deleted successfully.';
						
						$http.get("/bloggy/api/user").then(function(response) {
							$scope.users = response.data;
						});
					}
				});
	};
});

app.controller('FindUserController', function($scope, $http) {
	$scope.find = function() {
		$http.get("/bloggy/api/user/" + $scope.id).then(
				function(response) {
					$scope.user = response.data;
				});
	};
	
	$scope.deleteUser = function(id) {
		$http.delete("/bloggy/api/user/" + id).then(
				function(response) {
					if(response.data == true) {
						$scope.status = id + ' has been deleted successfully.';						
						$scope.user = null;
					}
				});
	};
});

app.controller('ViewUserController', function($scope, $http, $routeParams) {
	$http.get('/bloggy/api/user/' + $routeParams.id).then(function(response) {
		$scope.user = response.data;
	});
	
	$scope.update = function() {
		$http.post("/bloggy/api/user", $scope.user).then(function(response) {
			$scope.status = response.data + ' has got updated successfully.';
		});
	};
});
