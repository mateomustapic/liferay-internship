const foodList = document.querySelector('#food');
const foodForm = document.querySelector('#addFood');
const food = JSON.parse(localStorage.getItem('food')) || [];

function handleForm(evt) {
	evt.preventDefault();
	const mealName = (this.querySelector('[name=meal]')).value;

	const meal = {
		name: mealName,
		done: false,
	};

	food.push(meal);

	displayFood(food, foodList);

	// set LocalStorage
	localStorage.setItem('food', JSON.stringify(food));
	this.reset();
}

function displayFood(arr, el) {
	el.innerHTML = arr.map((item, i) => {
		return `<li>
			<input data-index=${i} type="checkbox" id="item${i}"
			${item.done ? 'checked' : ''}/>
			<label for="item${i}">${item.name}</label>
		</li>`;
	}).join('');
}

function handleChecked(el) {
	const target = el.target;

	if(!target.matches('input')) return;

	const index = target.dataset.index;

	food[index].done = !food[index].done;

	// Change LocalStorage
	localStorage.setItem('food', JSON.stringify(food));

	displayFood(food, foodList);
}

foodForm.addEventListener('submit', handleForm);
foodList.addEventListener('click', handleChecked);

displayFood(food, foodList);
