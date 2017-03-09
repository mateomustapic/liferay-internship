'use strict';

var sidebar = document.querySelector('#sidebar');
var sidebarEnvironments = sidebar.querySelector('#sidebar-environments');

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
	var target = e.target;
	console.log(target);
	if (target.classList.contains('list-settings-icon')) {
		target.parentElement.parentElement.classList.toggle('settings-open');
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

// My Clock Component

var MyClock = Object.assign({}, Component, {

	tagName: 'clock',

	attributes: {
		date: new Date()
	},

	addEvents: function addEvents(clock) {
		clock._timer = setInterval(function () {
			clock.date = new Date();
		}, 1000);
	},
	uninit: function uninit(clock) {
		clearInterval(clock._timer);
	},
	__date: function __date(clock, newVal) {
		clock.textContent = newVal.toLocaleTimeString();
	}
});

MyClock.register();
document.sidebar.appendChild(document.createElement('clock'));