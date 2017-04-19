alert("Welcome to travel site!");

$(document).ready(function(){
    $('#menu').accordion();
});

$(document).on('click', 'a', function(event){
    event.preventDefault();
    $('html, body').animate({
        scrollTop: $( $.attr(this, 'href') ).offset().top
    }, 500);
});

