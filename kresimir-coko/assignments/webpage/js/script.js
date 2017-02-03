$(document).ready(function() {
  var toggleClass = function(event) {
    $(event.currentTarget).children('.tech-stack').toggleClass('active');
  }

  $('#work-section').on('mouseenter', '.work-example', toggleClass);
  $('#work-section').on('mouseleave', '.work-example', toggleClass);
});
