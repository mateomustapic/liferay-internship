$(document).ready(function(){
	/* modal window 1 */
	var modal = document.getElementById('modal1');
	var btn = document.getElementById('btn1');
	var span = document.getElementsByClassName('close')[0]; 
	btn.onclick = function() {
	    modal.style.display = 'block';
	}
	span.onclick = function() {
		modal.style.display = 'none';
	}
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = 'none';
	    }
	}
	/* modal window 2 */
	var modal2 = document.getElementById('modal2');
	var btn2 = document.getElementById('btn2');
	var span2 = document.getElementsByClassName('close2')[0]; 
	btn2.onclick = function() {
	    modal2.style.display = 'block';
	}
	span2.onclick = function() {
	    modal2.style.display = 'none';
	}
	window.onclick = function(event) {
	    if (event.target == modal2) {
	        modal2.style.display = 'none';
	    }
	}
	/* modal window 3 */
	var modal3 = document.getElementById('modal3');
	var btn3 = document.getElementById('btn3');
	var span3 = document.getElementsByClassName('close3')[0]; 
	btn3.onclick = function() {
	    modal3.style.display = 'block';
	}
	span3.onclick = function() {
	    modal3.style.display = 'none';
	}
	window.onclick = function(event) {
	    if (event.target == modal3) {
	        modal3.style.display = 'none';
	    }
	}
})
