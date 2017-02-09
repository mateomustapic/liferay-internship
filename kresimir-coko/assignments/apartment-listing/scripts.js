/* jshint esversion: 6 */

const apartmentsContainer = document.querySelector('#app-content_apartments-container');
const filterContainer = document.querySelector('#app-content_filter-container');
const filterSlider = filterContainer.querySelectorAll('.filter-slider');
let filters = {
	price: 100,
	rating: 3,
	beds: 1,
	people: 1
};

const requestApartments = new Promise((resolve, reject) => {
	const xhr = new XMLHttpRequest();
	xhr.onload = function() {
		try {
			resolve(JSON.parse(this.responseText));
		} catch (e) {
			reject(e);
		}
	};
	xhr.onerror = reject;
	xhr.open('GET', 'https://api.myjson.com/bins/16wiy5');
	xhr.send();
});

function handleFilter() {
	const filterOutput = this.parentNode.querySelector('.filter-output');
	const value = this.value;
	const type = this.getAttribute('name');

	if (type === 'price') {
		filters.price = value;
	}	else if (type === 'rating') {
		filters.rating = value;
	}	else if (type === 'beds') {
		filters.beds = value;
	} else {
		filters.people = value;
	}

	const min = this.getAttribute('min');
	const max = this.getAttribute('max');

	const positionX = (value - min) / (max - min);

	const currentX = this.offsetWidth * positionX - (16 * positionX);

	if (type == 'price') {
		filterOutput.innerText = `${value - 100} - ${value}`;
		filterOutput.style.transform = `translateX(${currentX - 30}px)`;
	} else {
		filterOutput.innerText = value;
		filterOutput.style.transform = `translateX(${currentX}px)`;
	}

	filterOutput.classList.add('active');

	requestApartments
		.then(apartments => {
			apartments = apartments.filter(apartment => {
				if (typeof apartment.price == 'string') {
					apartment.price = apartment.price.replace( /^\D+/g, '');
				}

				if (apartment.price <= (filters.price - 100) ||
					apartment.price >= filters.price) {
						return false;
				}
				if (apartment.rating != filters.rating)
					return false;
				if (apartment.beds != filters.beds)
					return false;
				if (apartment.people != filters.people)
					return false;
				else
					return true;
			});

			apartmentsContainer.innerHTML = apartments.map(apartment => {
				return `
					<div id="apartment-${apartment.id}" class="apartment">
						<h3>${apartment.title}</h3>
						<p>${apartment.description}</p>
						<div class="metadata">
							<span class="metadata-date">
								<i class="fa fa-calendar"></i> ${apartment.date}
							</span>
							<span class="metadata-price">
								<i class="fa fa-money"></i> ${apartment.price}
							</span>
							<span class="metadata-rating">
								<i class="fa fa-star"></i> ${apartment.rating}
							</span>
							<span class="metadata-address">
								<i class="fa fa-location-arrow"></i> ${apartment.address}
							</span>
							<span class="metadata-beds">
								<i class="fa fa-bed"></i> ${apartment.beds}
							</span>
							<span class="metadata-people">
								<i class="fa fa-user"></i>${apartment.people}
							</span>
						</div>
					</div>
				`;
			}).join('');
		});
}

filterSlider.forEach(filter => {
	filter.addEventListener('input', handleFilter);
});
