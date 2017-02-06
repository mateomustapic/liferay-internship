const addItems = document.querySelector('#addItems');
const foodList = document.querySelector('#food');
const items = JSON.parse(localStorage.getItem('items')) || [];

function addItem(evt) {
	evt.preventDefault();
	const text = (this.querySelector('[name=item]')).value;

	const item = {
		text,
		done: false,
	};

	items.push(item);

	populateList(items, foodList);

	localStorage.setItem('items', JSON.stringify(items));
	this.reset();
}

function populateList(food, foodList) {
	foodList.innerHTML = food.map((meal, i) => {
		return `
			<li>
				<input
					type="checkbox" data-index=${i} id="item${i}"
					${meal.done ? 'checked' : ''} />
				<label for="item${i}">${meal.text}</label>
			</li>`;
	}).join('');
}

function toggleDone(el) {
	if (!el.target.matches('input')) return;
	const target = el.target;
	const index = target.dataset.index;
	items[index].done = !items[index].done;
	localStorage.setItem('items', JSON.stringify(items));
	populateList(items, foodList);
}

addItems.addEventListener('submit', addItem);
foodList.addEventListener('click', toggleDone);
populateList(items, foodList);
