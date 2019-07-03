angular.module("registration_form",[])
    .controller("AppCtrl", function ($scope, $http) {
        $scope.auth = {};
        let resultMessageEl = document.getElementById('resultMessage');
        let inputFirstNameEl = document.getElementById('exampleInputFirstName');
        let inputLastNameEl = document.getElementById('exampleInputLastName');
        let inputEmailEl = document.getElementById('exampleInputEmail');
        let inputLoginEl = document.getElementById('exampleInputLogin');
        let inputPasswordEl = document.getElementById('exampleInputPassword');


        let inputNameLabel = document.getElementById('inputFirstNameLabel');
        let inputLoginLabel = document.getElementById('inputLoginLabel');

        inputLoginEl.addEventListener('input', () => {
            inputNameLabel.style.color = 'black';
        inputLoginLabel.style.color = 'black';
        $scope.message = '';
    });
        $scope.sendForm = function(auth){
            $http({
                method: "POST",
                url: "/api/registration",
                data: $.param(auth),
                headers: { "Content-Type" : "application/x-www-form-urlencoded" }
            }).then(
                (data) => {
                resultMessageEl.style.color = 'green';
            $scope.message = 'Registration complete!';
            inputFirstNameEl.value = '';
            inputLastNameEl.value = '';
            inputEmailEl.value = '';
            inputLoginEl.value = '';
            inputPasswordEl.value = '';

            inputLoginLabel.style.color = 'black';
        },
            (error) => {
                console.log(error.data);
                resultMessageEl.style.color = 'red';
                inputLoginLabel.style.color = 'red';
                $scope.message = error.data.message;
            }
        );
        }
    });