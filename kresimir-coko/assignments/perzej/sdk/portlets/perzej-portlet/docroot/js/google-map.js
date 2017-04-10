AUI().use(
	'event',
	'node',
	'node-event-simulate',
	function(A) {
		var footer = A.one('#footer');

		var mapAddressInputField = A.one('#column-2 .field');

		var mapAddressSubmitBtn = A.one('#column-2 .btn');

		function switchAddress(event) {
			var target = event.currentTarget;

			var dataAddress = target.attr('data-address');

			mapAddressInputField.val(dataAddress + ', Zagreb');

			mapAddressSubmitBtn.simulate('click');

			event.preventDefault();
		}

		footer.delegate('click', switchAddress, '.location');
	}
);