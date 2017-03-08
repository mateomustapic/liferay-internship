'use strict';

const sidebar = document.querySelector('#sidebar');
const sidebarEnvironments = sidebar.querySelector('#sidebar-environments');

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
	const target = e.target;
	console.log(target);
	if (target.classList.contains('list-settings-icon')) {
		target.parentElement.parentElement.classList.toggle('settings-open');
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