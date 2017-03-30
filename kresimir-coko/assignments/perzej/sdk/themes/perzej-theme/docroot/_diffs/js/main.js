AUI().use(
	'node',
	'event',
	function(A) {
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

		var form = A.one('.fieldset');

		form.delegate('focus', labelFocused, '.field');
		form.delegate('blur', labelBlurred, '.field');
	}
);