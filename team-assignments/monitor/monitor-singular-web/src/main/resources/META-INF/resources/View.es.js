import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';

let websocket = null;

const wsUri = 'ws://localhost:8080/o/echo';

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
		return 147;
	};

	setServerCountDifference() {
		return -3;
	};

	sendMessage(message) {
		const msg = document.querySelector('#msgInput');

		if (websocket != null) {
			document.querySelector('#msgInput').value = '';

			websocket.send(msg);

			console.log('Message sent: ' + msg);
		}
		else {
			console.log('Cant send message, the connection is not open');
		}
	};

	initWebSocket() {
		try {
			if (websocket && websocket.readyState == 1) {
				websocket.close();
			}

			websocket = new WebSocket(wsUri);

			websocket.onopen = function(evt) {
				console.log('CONNECTED');
			};

			websocket.onclose = function(evt) {
				console.log('DISCONNECTED');
			};

			websocket.onmessage = function(evt) {
				console.log('Message received: ' + evt.data);
			};

			websocket.onerror = function(evt) {
				console.log('ERROR: ' + evt.data);
			};
		}
		catch (exception) {
			this.debugWebSockets('Error: ' + exception);
		}
	};

	stopWebSocket() {
		if (websocket) {
			websocket.close();
		}
	};

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