'use strict';

var sidebar = document.querySelector('#sidebar');
var content = document.querySelector('#content');
var sidebarEnvironments = sidebar.querySelector('#sidebar-environments');
var contentDashboard = content.querySelector('#content-dashboard');

// Header Menu
var headerMenuIcon = document.querySelector('#header-menu-icon');

function handleHeaderMenuIcon() {
	this.classList.toggle('menu-icon-open');
	sidebar.parentElement.classList.toggle('sidebar-open');
}

headerMenuIcon.addEventListener('click', handleHeaderMenuIcon);

// Environments Heading Tooltip
var envTooltipIcon = sidebarEnvironments.querySelector('#environments-info-icon');
var envTooltip = sidebarEnvironments.querySelector('#environments-info-tooltip');

function handleEnvironmentsTooltip() {
	envTooltip.classList.toggle('tooltip-active');
}

envTooltipIcon.addEventListener('click', handleEnvironmentsTooltip);

// Environments Settings
var envSettingsIcons = sidebarEnvironments.querySelectorAll('.list-settings-icon');
var envSettings = sidebarEnvironments.querySelectorAll('.environments-list-settings');

function handleEnvironmentsSettings(e) {
	if (e.target.classList.contains('list-settings-icon')) {
		var parent = e.target.parentElement.parentElement;
		var settings = parent.lastChild.previousSibling;

		parent.classList.toggle('settings-open');
	}
}

sidebarEnvironments.addEventListener('click', handleEnvironmentsSettings);

// Collapsed Sidebar Tooltips
var collapsedSidebarList = document.querySelector('#collapsed-sidebar-list');

function showCollapsedSidebarListTooltips(e) {
	if (e.target.dataset.tooltip) {
		var tooltip = e.target.dataset.tooltip;
		var target = e.target.lastChild;
		target.innerText = tooltip;
		target.classList.add('tooltip-open');
	} else if (e.target.classList.contains('material-icons')) {
		var _tooltip = e.target.parentElement.dataset.tooltip;
		var _target = e.target.parentElement.lastChild;
		_target.innerText = _tooltip;
		_target.classList.add('tooltip-open');
	}
}

function hideCollapsedSidebarListTooltips(e) {
	if (e.target.dataset.tooltip) {
		e.target.lastChild.classList.remove('tooltip-open');
	} else if (e.target.classList.contains('material-icons')) {
		e.target.parentElement.lastChild.classList.remove('tooltip-open');
	}
}

collapsedSidebarList.addEventListener('mouseover', showCollapsedSidebarListTooltips);
collapsedSidebarList.addEventListener('mouseout', hideCollapsedSidebarListTooltips);

// Add new Environment

var addEnvironmentComponent = content.querySelector('#add-environment');
var addEnvironmentBtn = sidebar.querySelector('#sidebar-environments-list-new');
var closeAddEnvironmentBtn = content.querySelector('#add-environment-close');
var addEnvironmentBtnCollapsed = collapsedSidebarList.querySelector('li[data-tooltip="Add Environment"]');

function handleNewEnvironmentComponent() {
	var el = addEnvironmentComponent;

	var first = el.getBoundingClientRect();

	el.classList.add('add-environment-open');
	var last = el.getBoundingClientRect();

	var invert = first.top - last.top;

	el.style.transform = 'translateY(' + invert + 'px)';

	content.style.willChange = 'transform';
}

function closeAddEnvironment() {
	addEnvironmentComponent.classList.remove('add-environment-open');
	content.style.willChange = '';
}

addEnvironmentBtn.addEventListener('click', handleNewEnvironmentComponent);
addEnvironmentBtnCollapsed.addEventListener('click', handleNewEnvironmentComponent);
closeAddEnvironmentBtn.addEventListener('click', closeAddEnvironment);

// Dynamically fetch environments from environments.json
var environmentsPromise = new Promise(function (resolve, reject) {
	var xhr = new XMLHttpRequest();
	xhr.onload = function () {
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

var activeEnvironments = [];
var inactiveEnvironments = [];

var environmentsListActive = sidebar.querySelector('#sidebar-environments-list-active');
var environmentsListInactive = sidebar.querySelector('#sidebar-environments-list-inactive');

environmentsPromise.then(function (environments) {
	environments.map(function (environment) {
		if (environment.name.length > 18) {
			environment.name = environment.name.substring(0, 18) + '...';
		}
		if (environment.status) {
			var output = '\n\t\t\t\t<li dataset-id=\'' + environment.id + '\'>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<i class="material-icons">cloud</i>\n\t\t\t\t\t\t' + environment.name + '\n\t\t\t\t\t\t<i class="material-icons list-settings-icon">settings</i>\n\t\t\t\t\t</div>\n\t\t\t\t\t<section class="environments-list-settings">\n\t\t\t\t\t\t<i data-status=\'' + environment.status + '\' class="material-icons toggle-status">power_settings_new</i>\n\t\t\t\t\t\t<i class="material-icons edit-environment">edit</i>\n\t\t\t\t\t\t<i class="material-icons delete-environment">delete_forever</i>\n\t\t\t\t\t</section>\n\t\t\t\t</li>\n\t\t\t';
			environmentsListActive.innerHTML += output;
		} else {
			var _output = '\n\t\t\t\t<li>\n\t\t\t\t\t<div>\n\t\t\t\t\t\t<i class="material-icons">cloud_queue</i>\n\t\t\t\t\t\t' + environment.name + '\n\t\t\t\t\t\t<i class="material-icons list-settings-icon">settings</i>\n\t\t\t\t\t</div>\n\t\t\t\t\t<section class="environments-list-settings">\n\t\t\t\t\t\t<i data-status=\'' + environment.status + '\' class="material-icons toggle-status">power_settings_new</i>\n\t\t\t\t\t\t<i class="material-icons edit-environment">edit</i>\n\t\t\t\t\t\t<i class="material-icons delete-environment">delete_forever</i>\n\t\t\t\t\t</section>\n\t\t\t\t</li>\n\t\t\t';
			environmentsListInactive.innerHTML += _output;
		}
	});
});

// Display Environments On Dashboard

var dashboardNav = content.querySelector('#content-dashboard-nav');

function handleContentNavigation(e) {
	var target = e.target;
	console.log(target);

	if (target.dataset.link.length > 0) {
		console.log(target);
	}
}

dashboardNav.addEventListener('click', handleContentNavigation);