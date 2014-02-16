'use strict';

angular.module('webApp').controller('MainCtrl', function($scope, Restangular) {
	$scope.words = [];
	$scope.text = "";

	var data = function() {
		Restangular.all("hello").getList().then(function(words) {
			$scope.words = words
		});
	}

	$scope.createWord = function() {
		Restangular.all("hello").post($scope.text).then(function() {
			$scope.text = "";
			data();
		});
	}

	data();

});
