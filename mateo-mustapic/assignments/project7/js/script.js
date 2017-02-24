var main = function() {
	/* New post to the list */
	$('.btn').click(function(){
		var post = $('.status-box').val();
		var user = prompt("Enter your username : ");
		$('<li>').text(post + ' /by ' + user + getCurrentTime()).prependTo('.posts');
		$('.status-box').val('') + span;
		$('.counter').text('140');
		$('.btn').addClass('disabled');
	});
	/*Append close button only to default posts*/
	var myNodeList = document.getElementsByTagName("LI");
	var i;
	for (i = 3; i < 5; i++){
	  var span = document.createElement("SPAN");
	  var txt = document.createTextNode("\u00D7");
	  span.className = "close";
	  span.appendChild(txt);
	  myNodeList[i].appendChild(span);
	}
	/*Adding click to close button for removing listed items*/
	var close = document.getElementsByClassName("close");
	var i;
	for(i = 0; i < close.length; i++){
	  close[i].onclick = function(){
	    var div = this.parentElement;
	    div.style.display = "none";
	  }
	}
	/* Post length counter */
	$('.status-box').keyup(function(){
		var postLength = $(this).val().length;
		var charactersLeft = 140 - postLength;
		$('.counter').text(charactersLeft);
		if(charactersLeft < 0) {
		$('.btn').addClass('disabled');
		$('.counter').text('too many characters');
		}
		else if(charactersLeft === 140) {
			$('.btn').addClass('disabled');
		}
		else {
			$('.btn').removeClass('disabled');
		}
	});
	$('.btn').addClass('disabled');
};
$(document).ready(main);
/* Current Date and time */
var today = new Date();
var day = today.getDay();
var dayList = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
var hour = today.getHours();
/*Adding zero to get double digit minutes*/
function addZero(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
var minute = addZero(today.getMinutes());
var second = today.getSeconds();
var prepand = (hour >= 12? ' PM ' : ' AM ');
/*function for getting current time*/
var getCurrentTime = function(){
	return ' (at ' + hour + ':' + minute + prepand + ' )'; 
}
/*function for getting current date and time*/
var getCurrentDateTime = function(){
	return'Today is: ' + dayList[day] + '\n Current time is ' + hour + prepand + minute + ' minutes : ' + second + ' seconds';
}
