var fields = document.querySelectorAll('.field');

function labelFocused(e) {
	var label = e.target.previousSibling.previousSibling;

	label.classList.add('label-active');
}

function labelBlurred(e) {
	var label = e.target.previousSibling.previousSibling;

	label.classList.remove('label-active');
}

for (var i = 0; i < fields.length; i++) {
	fields[i].addEventListener('focus', labelFocused);
	fields[i].addEventListener('blur', labelBlurred);
}