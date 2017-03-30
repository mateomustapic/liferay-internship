AUI().use(
	'node',
	'event',
	function(A) {
		var form = A.one('.fieldset');

		function labelFocused(e) {
			var target = e.currentTarget;

			target.siblings('label').addClass('label-active');
		}

		function labelBlurred(e) {
			var target = e.currentTarget;

			target.siblings('label').removeClass('label-active');
		}

		form.delegate('focus', labelFocused, '.field');
		form.delegate('blur', labelBlurred, '.field');
	}
);