AUI().use(
	'event',
	'node',
	function(A) {
		function toggleActive(event) {
			var fieldInput = event.currentTarget;

			var fieldLabels = fieldInput.siblings('label');

			fieldLabels.toggleClass('label-active', event.type == 'focus');
		}

		var form = A.one('.fieldset');

		form.delegate('blur', toggleActive, '.field');
		form.delegate('focus', toggleActive, '.field');
	}
);