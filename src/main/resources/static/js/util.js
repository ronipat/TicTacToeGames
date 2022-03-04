//misc
function showLoading($mdDialog, process) {
	var loading = {
		templateUrl : "misc/loadingPopup.html",
		onComplete  : process
	};

	$mdDialog.show(loading);
}

function hideLoading($mdDialog) {
	$mdDialog.hide();
}

function blurs(event, element) {
	if (event.keyCode == 13)
		element.blur();
}

function showAlert($mdDialog, title, content, html) {
	var alert = $mdDialog.alert().clickOutsideToClose(true).title(title)
			.textContent(content).ariaLabel('Alert Dialog').ok('OK');

	if (html)
		alert = $mdDialog.alert().clickOutsideToClose(true).title(title)
				.htmlContent(content).ariaLabel('Alert Dialog').ok('OK');

	$mdDialog.show(alert);
}

function execute($scope, $mdDialog, loading, Service, input, callback, errorcallback, parameter) {
	if ($scope.running == null)
		$scope.running = 0;

	var process = function() {
		if (parameter) {
			Service.execute(parameter, input, function(result) {
				callback(result);
				if (loading) {
					$scope.running--;
					if ($scope.running == 0)
						hideLoading($mdDialog);
				}
			}, function(error) {
				if (showLoading) {
					$scope.running--;
					if ($scope.running == 0)
						hideLoading($mdDialog);
				}

				if (errorcallback) {
					errorcallback(error);
				} else {
					if (error.data == null)
						showAlert($mdDialog, "", "There is no connection!");
					else if (error.data.message == null)
						showAlert($mdDialog, "", "Error occured on server");
				}
			});
		} else {
			Service.execute(input, function(result) {
				callback(result);
				if (loading) {
					$scope.running--;
					if ($scope.running == 0)
						hideLoading($mdDialog);
				}
			}, function(error) {
				if (showLoading) {
					$scope.running--;
					if ($scope.running == 0)
						hideLoading($mdDialog);
				}
				if (errorcallback) {
					errorcallback(error);
				} else {
					if (error.data == null)
						showAlert($mdDialog, "", "There is no connection!");
					else if (error.data.message == null)
						showAlert($mdDialog, "", "Error occured on server");
				}
			});
		}
	};

	if (loading) {
		$scope.running++;
		if ($scope.running == 1)
			showLoading($mdDialog, process);
		else
			process();
	} else {
		process();
	}
}


//colors
var colorPalette = {};

colorPalette['orange-50'] = '#FFF3E0';
colorPalette['orange-100'] = '#FFE0B2';
colorPalette['orange-200'] = '#FFCC80';
colorPalette['orange-300'] = '#FFB74D';
colorPalette['orange-400'] = '#FFA726';
colorPalette['orange-500'] = '#FF9800';
colorPalette['orange-600'] = '#FB8C00';
colorPalette['orange-700'] = '#F57C00';
colorPalette['orange-800'] = '#EF6C00';
colorPalette['orange-900'] = '#E65100';
colorPalette['orange-A100'] = '#FFD180';
colorPalette['orange-A200'] = '#FFAB40';
colorPalette['orange-A400'] = '#FF9100';
colorPalette['orange-A700'] = '#FF6D00';

colorPalette['deep-orange-50'] = '#FBE9E7';
colorPalette['deep-orange-100'] = '#FFCCBC';
colorPalette['deep-orange-200'] = '#FFAB91';
colorPalette['deep-orange-300'] = '#FF8A65';
colorPalette['deep-orange-400'] = '#FF7043';
colorPalette['deep-orange-500'] = '#FF5722';
colorPalette['deep-orange-600'] = '#F4511E';
colorPalette['deep-orange-700'] = '#E64A19';
colorPalette['deep-orange-800'] = '#D84315';
colorPalette['deep-orange-900'] = '#BF360C';
colorPalette['deep-orange-A100'] = '#FF9E80';
colorPalette['deep-orange-A200'] = '#FF6E40';
colorPalette['deep-orange-A400'] = '#FF3D00';
colorPalette['deep-orange-A700'] = '#DD2C00';

colorPalette['black'] = '#000000';
colorPalette['white'] = '#FFFFFF';