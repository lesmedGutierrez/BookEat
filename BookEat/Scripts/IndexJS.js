

document.getElementById("bookBtn").onclick = function () {
    var people = document.getElementById("peopleSlt").value
    var time = document.getElementById("timeSlt").value
    alert(people+", "+time)
};
$("#datepicker").datepicker();