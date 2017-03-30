AUI().use(
	'node',
	'event',
	function(A) {
		var form = A.one('.fieldset');

		function labelFocused(e) {
			var fieldInput = e.currentTarget;

			var fieldLabels = fieldInput.siblings('label');

			fieldLabels.addClass('label-active');
		}

		function labelBlurred(e) {
			var fieldInput = e.currentTarget;

			var fieldLabels = fieldInput.siblings('label');

			fieldLabels.removeClass('label-active');
		}

		form.delegate('focus', labelFocused, '.field');
		form.delegate('blur', labelBlurred, '.field');
	}
);