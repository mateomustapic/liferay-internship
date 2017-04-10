AUI().use(
	'aui-node',
	'aui-modal',
	'aui-char-counter',
	'aui-datatable',
	function(A) {

		/* Adding Close button */
		var i;
		var myNodeList = document.getElementById('myUL').getElementsByTagName('LI');

		for (i = 0; i < myNodeList.length; i++) {
			var span = document.createElement('SPAN');
			var txt = document.createTextNode('\u00D7');

			span.className = 'close';
			span.appendChild(txt);
			myNodeList[i].appendChild(span);
		}

		/* Adding click to close button for removing listed items */
		var close = document.getElementsByClassName('close');
		var i;

		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;

				div.style.display = 'none';
			};
		}

		/* Create a new list item when clicking on the "Add" button*/
		function addItem() {
			var inputValue = document.getElementById('myInput').value;
			var li = document.createElement('li');
			var t = document.createTextNode(inputValue);

			li.appendChild(t);
			if (inputValue === '') {
				alert('write something');
			}
			else if (inputValue) {
				document.getElementById('myUL').appendChild(li);
			}
			document.getElementById('myInput').value = '';
			var span = document.createElement('SPAN');
			var txt = document.createTextNode('\u00D7');

			span.className = 'close';
			span.appendChild(txt);
			li.appendChild(span);

			for (i = 0; i < close.length; i++) {
				close[i].onclick = function() {
					var div = this.parentElement;

					div.style.display = 'none';
				};
			}
		}

		A.one('#addItem').on('click', addItem);

		/* Modal window */
		var modal = new A.Modal(
			{
				bodyContent: 'In this portlet you can add or delete your tasks',
				centered: true,
				headerContent: '<h3>TO DO LIST <span class="icon-check" aria-hidden="true"></span></h3>',
				modal: true,
				render: '#modal',
				width: 450
			}
			).render();

		/* Input character count */
		new A.CharCounter(
			{
				counter: '#myCounter',
				input: '#myInput',
				maxLength: 50,
				on: {
						maxLength: function(event) {
						alert('The max length limit was reached');
					}
				}
			}
		);

		/* creating columns of the table */
		var columns = ['ID', 'Task', 'description'];


		/* data for columns */
		for(i = 0; i < myNodeList.length; i++){
			var len = i + 1;
			var len2 = 'Task ' + (i+1);
			var desc = myNodeList[i].textContent;
			var data = [{
					ID: len, Task: len2, description: desc
				}];
			alert(desc);
		}

		/* Creating new table */
		new A.DataTable.Base(
			{
				columnset: columns,
				recordset: data
			}
		).render('#tasksTable');
	}
);
