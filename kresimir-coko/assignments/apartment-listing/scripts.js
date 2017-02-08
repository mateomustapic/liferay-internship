const apartmentsContainer = document.querySelector('#app-content_apartments-container');
const filterContainer = document.querySelector('#app-content_filter-container');
const priceSelect = filterContainer.querySelector('[name=price]');
const ratingSelect = filterContainer.querySelector('[name=rating]');
const bedsSelect = filterContainer.querySelector('[name=beds]');
const peopleSelect = filterContainer.querySelector('[name=people]');

const requestApartments =
	new Promise((resolve, reject) => {
		const xhr = new XMLHttpRequest();
		xhr.onload = function() {
			try {
				resolve(JSON.parse(this.responseText));
			}
			catch (e) {
				reject(e);
			}
		};
		xhr.onerror = reject;
		xhr.open('GET', 'https://api.myjson.com/bins/16wiy5');
		xhr.send();
	});

requestApartments
	.then(apartments => {
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
	})

function handleFilter(evt) {
	const target = evt.target;
	console.log(target);
}

filterContainer.addEventListener('submit', handleFilter);
