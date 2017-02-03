$(document).ready(function() {

  function addNewItem(itemText, list) {
       $(list).prepend('<li><input type ="checkbox"><span>' + itemText + '</span><span class = "close">&times</span></li>');
  }

  var newBtn = document.getElementById("addBtn");
  var input = document.getElementById("myInput");
  var list = document.getElementById("myUL");

  newBtn.onclick = function() {
    var itemText = input.value;
    if(itemText == "") {
      alert("come on! don't be lazy");
    }
    else {
      addNewItem(itemText, list);
    }
    input.value = "";
  };

  input.onkeyup = function(event) {
    if (event.which == 13) {
      var itemText = input.value;
      if(itemText == "") {
        alert("come on! don't be lazy");
      }
      else {
        addNewItem(itemText, list);
      }
      input.value = "";
    }
  };

  $('#myUL').on("click", "input[type='checkbox']",
                function(e) {
    ($(this).parent()).toggleClass('ab');
  });

  $('#myUL').on("click", ".close",
                function(e) {
     $(this).parent().hide();
   });

});
