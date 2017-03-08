'use strict';

var sidebarEnvironments = document.querySelector('#sidebar-environments');

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

function handleEnvironmentsSettingsTooltip(e) {
	var target = e.target;
	if (target.classList.contains('environments-list-settings')) {
		target.classList.add('tooltip-active');
	}
}

sidebarEnvironments.addEventListener('click', handleEnvironmentsSettingsTooltip);