AUI().use(
	'aui-char-counter',
	'aui-modal',
	function(A) {

		/* Modal window */
		var modal = new A.Modal(
			{
				bodyContent: 'In this portlet you can add new and delete finished tasks',
				centered: true,
				headerContent: '<h3>TO DO LIST <span class="icon-check" aria-hidden="true"></span></h3>',
				modal: true,
				render: '#modal',
				width: 400
			}
		).render();

		/* Input character count */
		new A.CharCounter(
			{
				counter: '.myCounter',
				input: '.myInput',
				maxLength: 40,
				on: {
					maxLength: function(event) {
						alert('The max length has been reached');
					}
				}
			}
		);
	}
);