AUI().use(
	'event',
	'node',
	function(A) {
		var EVENT_FOCUS = 'focus';

		var SELECTOR_FIELD = '.field';

		function toggleActive(event) {
			var fieldInput = event.currentTarget;

			var fieldLabels = fieldInput.siblings('label');

			fieldLabels.toggleClass('label-active', event.type == EVENT_FOCUS);
		}

		var form = A.one('.fieldset');

		if (form) {
			form.delegate('blur', toggleActive, SELECTOR_FIELD);
			form.delegate(EVENT_FOCUS, toggleActive, SELECTOR_FIELD);
		}

		var languageCroatian = A.one('.language-picker .portlet-body span:first-child a');

		var languageEnglish = A.one('.language-picker .portlet-body span:last-child a');

		if (languageCroatian) {
			languageCroatian.text('hr');
		}

		if (languageEnglish) {
			languageEnglish.text('en');
		}
	}
);