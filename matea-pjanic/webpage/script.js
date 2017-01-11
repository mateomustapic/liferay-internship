$(document).ready(function() {
  $('.icon-menu').click(function() {
    $(this).hide();
    });
  $('.icon-close').click(function() {
    $('.icon-menu').show();
  });
  $('.icon-menu').click(function() {
    $('.menu').animate({right: "0px"}, 200);
    $('body').animate({right: "160px"}, 200);
    });
  $('.icon-close').click(function() {
    $('.menu').animate({right: "-160px"}, 200);
    $('body').animate({right: "0px"}, 200);
    });
  $('.blok1_2').mouseenter(function() {
    $('.blok1_2_text').text("shoot what it feels like");
  });
  $('.blok1_2').mouseleave(function() {
    $('.blok1_2_text').text("don't shoot what it looks like...");
  });
  $('.blok3_2').mouseenter(function() {
    $('.blok3_2_text').text("...altering life by holding it still");
  });
  $('.blok3_2').mouseleave(function() {
    $('.blok3_2_text').text("take an instant of time");
  });
  $('#list').accordion();
});
