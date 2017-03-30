AUI().use(
	'node',
	'event',
	function(A) {
		var form = A.one('.fieldset');

		function labelFocused(e) {
			var fieldInput = e.currentTarget;

			fieldInput.siblings('label').addClass('label-active');
		}

		function labelBlurred(e) {
			var fieldInput = e.currentTarget;

			fieldInput.siblings('label').removeClass('label-active');
		}

		form.delegate('focus', labelFocused, '.field');
		form.delegate('blur', labelBlurred, '.field');
	}
);