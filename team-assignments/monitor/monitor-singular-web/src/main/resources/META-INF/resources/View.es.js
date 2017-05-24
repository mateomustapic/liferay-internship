import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';

class View extends Component {
	animateValue(valueContainerDOM, startingValue, finalValue, animationDuration) {
		const valueContainer = document.querySelector(valueContainerDOM);

		const valueRange = finalValue - startingValue;

		const minAnimationDuration = 50;

		let animationStepTime = Math.abs(Math.floor(animationDuration / valueRange));

		animationStepTime = Math.max(animationStepTime, minAnimationDuration);

		const animationStartTime = new Date().getTime();

		const animationEndTime = animationStartTime + animationDuration;

		let animationTimer;

		function runAnimation() {
			const currentTime = new Date().getTime();

			const remainingTime = Math.max((animationEndTime - currentTime) / animationDuration, 0);

			const currentValue = Math.round(finalValue - (remainingTime * valueRange));

			//TODO: Instead of doing it by changing the DOM, change and update the state

			valueContainer.innerHTML = currentValue;

			if (currentValue === finalValue) {
				clearInterval(animationTimer);
			}
		}

		animationTimer = setInterval(runAnimation, animationStepTime);

		runAnimation();
	}

	setOnlineServerCount() {
		//TODO: startingValue and finalValue are retrieved from the API

		this.animateValue('.online-server-count', startingValue, finalValue, 200);

		return 147;
	};

	setServerCountDifference() {
		return -3;
	}
}

View.STATE = {
	onlineServerCount: {
		setter: 'setOnlineServerCount',
		value: 0
	},
	serverCountDifference: {
		setter: 'setServerCountDifference',
		value: 0
	}
};

Soy.register(View, templates);

export default View;