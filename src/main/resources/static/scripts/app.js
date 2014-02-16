'use strict';

angular.module('webApp',
		[ 'ngCookies', 'ngResource', 'ngSanitize', 'ngRoute', 'restangular' ])
		.config(function($routeProvider) {
			$routeProvider.when('/', {
				templateUrl : 'views/main.html',
				controller : 'MainCtrl'
			}).otherwise({
				redirectTo : '/'
			});
		}).config(function(RestangularProvider) {
			RestangularProvider.setBaseUrl(window.location.pathname);
		});
