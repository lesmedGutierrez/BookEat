/// <reference path="../Views/Restaurant/Create.cshtml" />


document.getElementById("bookBtn").onclick = function () {
    var people = document.getElementById("peopleSlt").value
    var time = document.getElementById("timeSlt").value

    alert(people+", "+time)
};

$( "#bookBtn" ).submit(function( event ) {
}


$("#datepicker").datepicker();