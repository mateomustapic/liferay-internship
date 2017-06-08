'use strict';

import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './MonitorSingular.soy';

const wsUri = 'ws://localhost:8080/o/singularEndpoint';

let websocket = null;

class MonitorSingular extends Component {

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

			valueContainer.innerHTML = currentValue;

			if (currentValue === finalValue) {
				clearInterval(animationTimer);
			}
		}

		animationTimer = setInterval(runAnimation, animationStepTime);

		runAnimation();
	}

	created() {
		this._initWebSocket();
	};

	desposed() {
		this._stopWebSocket();
	};

	setOnlineServerCount() {
		return 147;
	};

	setServerCountDifference() {
		return -3;
	};

	_initWebSocket() {
		if (websocket && websocket.readyState === 1) {
			websocket.close();
		}

		websocket = new WebSocket(wsUri);

		websocket.onmessage = (evt) => {
			const serverMessageSpan = document.querySelector('.server-message');

			serverMessageSpan.innerHTML = evt.data;
		};
	};

	_stopWebSocket() {
		if (websocket) {
			websocket.close();
		}
	};
}

MonitorSingular.STATE = {
	onlineServerCount: {
		setter: 'setOnlineServerCount',
		value: 0
	},
	serverCountDifference: {
		setter: 'setServerCountDifference',
		value: 0
	}
};

Soy.register(MonitorSingular, templates);

export default MonitorSingular;