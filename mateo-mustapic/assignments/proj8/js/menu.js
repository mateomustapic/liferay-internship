function menuFunction() {
    var x = document.getElementById("topnav");
    if (x.className === "respNav") {
        x.className += " responsive";
    } else {
        x.className = "respNav";
    }
}