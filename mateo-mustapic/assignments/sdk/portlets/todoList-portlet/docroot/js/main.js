YUI().use(
	'aui-node',
	function(Y) {
		Y.one('#addItem').on('click', addItem);

		/*Adding Close button*/
		var myNodeList = document.getElementById("myUL").getElementsByTagName("LI");
		var i;
		for (i = 0; i < myNodeList.length; i++) {
			var span = document.createElement("SPAN");
			var txt = document.createTextNode("\u00D7");
			span.className = "close";
			span.appendChild(txt);
			myNodeList[i].appendChild(span);
		}
		/*Adding click to close button for removing listed items*/
		var close = document.getElementsByClassName("close");
		var i;
		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;
				div.style.display = "none";
			}
		}
		/* Create a new list item when clicking on the "Add" button*/
		function addItem() {
		var li = document.createElement("li");
		var inputValue = document.getElementById("myInput").value;
		var t = document.createTextNode(inputValue);

		li.appendChild(t);
		if (inputValue === '') {
			alert("write something");
		}
		else if (inputValue) {
			document.getElementById("myUL").appendChild(li);
		}
		document.getElementById("myInput").value = "";
		var span = document.createElement("SPAN");
		var txt = document.createTextNode("\u00D7");
		span.className = "close";
		span.appendChild(txt);
		myNodeList[i].appendChild(span);

		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;
				div.style.display = "none";
			}
		}
	}
}
);

/* modal window */
YUI().use(
'aui-modal',
	function(Y) {
		var modal = new Y.Modal(
			{
				bodyContent: 'In this portlet you can add or delete tasks',
				centered: true,
				headerContent: '<h3>TO DO LIST <span class="icon-check" aria-hidden="true"></span></h3>',
				modal: true,
				render: '#modal',
				width: 450
			}
		).render();
});

/* counter of task characters */
YUI().use(
	'aui-char-counter',
	function(Y) {
		new Y.CharCounter(
			{
				counter: '#myCounter',
				input: '#myInput',
				maxLength: 50
			}
		);
	}
);