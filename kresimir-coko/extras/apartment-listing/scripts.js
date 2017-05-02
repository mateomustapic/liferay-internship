/* jshint esversion: 6 */

const apartmentsContainer = document.querySelector('#app-content_apartments-container');
const filterContainer = document.querySelector('#app-content_filter-container');
const filterSlider = filterContainer.querySelectorAll('.filter-slider');
const filteringBy = document.querySelector('#app-content_filtering-by .container');
const activeFilters = filteringBy.querySelectorAll('span');
const filters = {};

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

requestApartments
	.then(apartments => {
		apartments = apartments.filter(apartment => {
			return apartment.rating == 5;
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

	const minValue = this.getAttribute('min');
	const maxValue = this.getAttribute('max');

	const positionX = (value - minValue) / (maxValue - minValue);

	const currentX = this.offsetWidth * positionX - (16 * positionX);

	if (type == 'price') {
		filterOutput.innerText = `${value - 100} - ${value}`;
		filterOutput.style.transform = `translateX(${currentX - 30}px)`;
	} else {
		filterOutput.innerText = value;
		filterOutput.style.transform = `translateX(${currentX}px)`;
	}

	filterOutput.classList.add('active');
	const filterKeys = Object.keys(filters);
	let output = '';

	filterKeys.forEach(key => {
		output += `
			<span data-filter-type="${key}">
				${filters[key]}
				<i class="clear-filter fa fa-close"></i>
			</span>
		`;
		return output;
	});

	filteringBy.parentNode.classList.add('active');
	filteringBy.innerHTML = output;

	renderFilteredApartments();

	filteringBy.addEventListener('click', _ => {
		const target = _.target;

		const currentFilter = target.parentNode.dataset.filterType;
		const index = filterKeys.indexOf(currentFilter);

		if (!target.classList.contains('fa-close') || index < 0)
		return;

		const clearedFilter = filterKeys.splice(index, 1);

		const matchingSlider = [...filterSlider].find(_ => {
			return _.getAttribute('name') === currentFilter;
		});

		matchingSlider.value = 0;
		matchingSlider.nextSibling.nextSibling.classList.remove('active');
		delete filters[clearedFilter];
		target.parentNode.remove();

		renderFilteredApartments();

		if (!filteringBy.hasChildNodes()) {
			filteringBy.parentNode.classList.remove('active');
		}
	});
}

function renderFilteredApartments() {
	const propertyFilter = (prop) => {
		return (apartment) => {
			if (filters[prop] != undefined) {
				return filters[prop] == apartment[prop];
			}
			return true;
		}
	}

	const parsePrice = (price) => {
		if (typeof price == 'string') {
			price = price.replace( /^\D+/g, '');
		}
		return price;
	};

	requestApartments
		.then(apartments => {
			apartments = apartments
				.filter(propertyFilter('rating'))
				.filter(propertyFilter('beds'))
				.filter(propertyFilter('people'))
				.filter(apartment => {
					if (apartment.price != undefined) {
						const price = parsePrice(apartment.price);
						if (price <= (filters.price - 100) || price >= filters.price) {
							return false;
						}
					}
					return true;
				});

			if (apartments.length < 1) {
				apartmentsContainer.innerHTML =
					'<span class="error">No apartments match your criteria</span>';
			} else {
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
		}
	});
}

filterSlider.forEach(filter => {
	filter.addEventListener('input', handleFilter);
});
