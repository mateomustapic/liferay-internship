const sidebarEnvironments = document.querySelector('#sidebar-environments');

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

function handleEnvironmentsSettingsTooltip (e) {
	const target = e.target;
	if (target.classList.contains('environments-list-settings')) {
		target.classList.add('tooltip-active');
	}
}

sidebarEnvironments.addEventListener('click', handleEnvironmentsSettingsTooltip);
