/**
 * Created by Mateo on 3/21/2017.
 */
$(document).ready(function(){
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}
$('[data-toggle="tooltip"]').tooltip();
});