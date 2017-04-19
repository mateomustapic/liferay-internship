/* global $ */

$(document).ready(
	function() {
		function addNewItem(itemText, list) {
			$(list).prepend('<li><input type ="checkbox"><span>' + itemText + '</span><span class = "close">&times</span></li>');
		}

		var input = document.getElementById('myInput');

		var list = document.getElementById('myUL');

		var newBtn = document.getElementById('addBtn');

		newBtn.onclick = function() {
			var itemText = input.value;

			if (itemText == '') {
				alert('come on! dont be lazy');
			}
			else {
				addNewItem(itemText, list);
			}
			input.value = '';
		};

		input.onkeyup = function(event) {
			if (event.which == 13) {
				var itemText = input.value;

				if (itemText == '') {
					alert('come on! dont be lazy');
				}
				else {
					addNewItem(itemText, list);
				}
				input.value = '';
			}
		};

		var ul = $('#myUL');

		ul.on(
			'click',
			'input[type="checkbox"]',
			function(event) {
				var target = $(event.target);

				var parent = target.parent();

				parent.toggleClass('ab');
			}
		);

		ul.on(
			'click',
			'.close',
			function(event) {
				var target = $(event.target);

				var parent = target.parent();

				parent.hide();
			}
		);
	}
);
