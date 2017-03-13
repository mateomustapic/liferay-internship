'use strict';

const sidebar = document.querySelector('#sidebar');
const content = document.querySelector('#content');
const sidebarEnvironments = sidebar.querySelector('#sidebar-environments');
const contentDashboard = content.querySelector('#content-dashboard');

// Header Menu
const headerMenuIcon = document.querySelector('#header-menu-icon');

function handleHeaderMenuIcon () {
	this.classList.toggle('menu-icon-open');
	sidebar.parentElement.classList.toggle('sidebar-open');
}

headerMenuIcon.addEventListener('click', handleHeaderMenuIcon);

// Environments Heading Tooltip
const envTooltipIcon = sidebarEnvironments.querySelector('#environments-info-icon');
const envTooltip = sidebarEnvironments.querySelector('#environments-info-tooltip');

function handleEnvironmentsTooltip () {
	envTooltip.classList.toggle('tooltip-active');
}

envTooltipIcon.addEventListener('click', handleEnvironmentsTooltip);

// Environments Settings
const envSettingsIcons = sidebarEnvironments.querySelectorAll('.list-settings-icon');
const envSettings = sidebarEnvironments.querySelectorAll('.environments-list-settings');

function handleEnvironmentsSettings (e) {
	if (e.target.classList.contains('list-settings-icon')) {
		const parent = e.target.parentElement.parentElement;
		const settings = parent.lastChild.previousSibling;

		parent.classList.toggle('settings-open');
	}
}

sidebarEnvironments.addEventListener('click', handleEnvironmentsSettings);

// Collapsed Sidebar Tooltips
const collapsedSidebarList = document.querySelector('#collapsed-sidebar-list');

function showCollapsedSidebarListTooltips (e) {
	if (e.target.dataset.tooltip) {
		const tooltip = e.target.dataset.tooltip;
		const target = e.target.lastChild;
		target.innerText = tooltip;
		target.classList.add('tooltip-open');
	} else if (e.target.classList.contains('material-icons')) {
		const tooltip = e.target.parentElement.dataset.tooltip;
		const target = e.target.parentElement.lastChild;
		target.innerText = tooltip;
		target.classList.add('tooltip-open');
	}
}

function hideCollapsedSidebarListTooltips (e) {
	if (e.target.dataset.tooltip) {
		e.target.lastChild.classList.remove('tooltip-open');
	} else if (e.target.classList.contains('material-icons')) {
		e.target.parentElement.lastChild.classList.remove('tooltip-open');
	}
}

collapsedSidebarList.addEventListener('mouseover', showCollapsedSidebarListTooltips);
collapsedSidebarList.addEventListener('mouseout', hideCollapsedSidebarListTooltips);

// Add new Environment

const addEnvironmentComponent = content.querySelector('#add-environment');
const addEnvironmentBtn = sidebar.querySelector('#sidebar-environments-list-new');
const closeAddEnvironmentBtn = content.querySelector('#add-environment-close');
const addEnvironmentBtnCollapsed = collapsedSidebarList.querySelector('li[data-tooltip="Add Environment"]');

function handleNewEnvironmentComponent () {
	const el = addEnvironmentComponent;

	const first = el.getBoundingClientRect();

	el.classList.add('add-environment-open');
	const last = el.getBoundingClientRect();

	const invert = first.top - last.top;

	el.style.transform = `translateY(${invert}px)`;
	dashboardNav.style.borderTop = '1px solid #ECECEC';

	content.style.willChange = 'transform';
}

function closeAddEnvironment () {
	addEnvironmentComponent.classList.remove('add-environment-open');
	dashboardNav.style.borderTopWidth = '0';
	content.style.willChange = '';
}

addEnvironmentBtn.addEventListener('click', handleNewEnvironmentComponent);
addEnvironmentBtnCollapsed.addEventListener('click', handleNewEnvironmentComponent);
closeAddEnvironmentBtn.addEventListener('click', closeAddEnvironment);

// Dynamically fetch environments from environments.json
const environmentsPromise = new Promise((resolve, reject) => {
	const xhr = new XMLHttpRequest();
	xhr.onload = function() {
		try {
			resolve(JSON.parse(this.responseText));
		} catch (e) {
			reject(e);
		}
	};
	xhr.onerror = reject;
	xhr.open('GET', 'https://api.myjson.com/bins/9vlpz');
	xhr.send();
});

const activeEnvironments = [];
const inactiveEnvironments = [];

const environmentsListActive = sidebar.querySelector('#sidebar-environments-list-active');
const environmentsListInactive = sidebar.querySelector('#sidebar-environments-list-inactive');

environmentsPromise.then(environments => {
	environments.map(environment => {
		if (environment.name.length > 18) {
			environment.name = environment.name.substring(0, 18) + '...';
		}
		if (environment.status) {
			let output = `
				<li dataset-id='${environment.id}'>
					<div>
						<i class="material-icons">cloud</i>
						${environment.name}
						<i class="material-icons list-settings-icon">settings</i>
					</div>
					<section class="environments-list-settings">
						<i data-status='${environment.status}' class="material-icons toggle-status">power_settings_new</i>
						<i class="material-icons edit-environment">edit</i>
						<i class="material-icons delete-environment">delete_forever</i>
					</section>
				</li>
			`;
			environmentsListActive.innerHTML += output;
		} else {
			let output = `
				<li>
					<div>
						<i class="material-icons">cloud_queue</i>
						${environment.name}
						<i class="material-icons list-settings-icon">settings</i>
					</div>
					<section class="environments-list-settings">
						<i data-status='${environment.status}' class="material-icons toggle-status">power_settings_new</i>
						<i class="material-icons edit-environment">edit</i>
						<i class="material-icons delete-environment">delete_forever</i>
					</section>
				</li>
			`;
			environmentsListInactive.innerHTML += output;
		}
	});
});


// Display Environments On Dashboard

const dashboardNav = content.querySelector('#dashboard-nav');

function handleContentNavigation (e) {
	const linkData = e.target.dataset.link;

	if (linkData) {
		// Change content depending on link
		const currentLink = e.target;
		const contentTemplates = content.querySelectorAll('.content-dashboard-content');
		
		currentLink.parentElement.querySelectorAll('li').forEach(_ => {
			if (_.classList.contains('active') && _ !== currentLink) {
				_.classList.remove('active');
			} else {
				currentLink.classList.add('active');
			}
		});

		switch (linkData) {
			case 'summary':
				contentTemplates.forEach(_ => { _.classList.remove('active') });
				content.querySelector('#content-dashboard-summary').classList.add('active');
				break;
			case 'environments':
				contentTemplates.forEach(_ => { _.classList.remove('active') });
				content.querySelector('#content-dashboard-environments').classList.add('active');
				break;
			case 'activity':
				contentTemplates.forEach(_ => { _.classList.remove('active') });
				content.querySelector('#content-dashboard-activity').classList.add('active');
				break;
			case 'placeholder':
				contentTemplates.forEach(_ => { _.classList.remove('active') });
				content.querySelector('#content-dashboard-placeholder').classList.add('active');
				break;
			default:
				console.log(link + 'has failed');
				break;
		}
	}
}

dashboardNav.addEventListener('click', handleContentNavigation);