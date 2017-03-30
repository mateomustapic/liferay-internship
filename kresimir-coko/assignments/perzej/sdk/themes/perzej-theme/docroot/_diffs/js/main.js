AUI().use(
	'node',
	'event',
	function(A) {
		function toggleActive(event) {
			var fieldInput = event.currentTarget;

			var fieldLabels = fieldInput.siblings('label');

			fieldLabels.toggleClass('label-active', event.type == 'focus');
		}

		var form = A.one('.fieldset');

		form.delegate('focus', toggleActive, '.field');
		form.delegate('blur', toggleActive, '.field');
	}
);