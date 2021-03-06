import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './MonitorSingular.soy';

const WS_URI = 'ws://localhost:8080/o/singularEndpoint';

class MonitorSingular extends Component {
	created() {
		let websocket = this.websocket;

		if (websocket && websocket.readyState === 1) {
			websocket.close();
		}

		websocket = new WebSocket(WS_URI);

		websocket.onmessage = (event) => {
			const serverMessageSpan = document.querySelector('.server-message');

			serverMessageSpan.classList.add('enhanced');

			serverMessageSpan.innerHTML = event.data;
		};
	};

	desposed() {
		let websocket = this.websocket;

		if (websocket) {
			websocket.close();
		}
	};
}

MonitorSingular.STATE = {
	serverCount: {
		value: 147
	},
	serverCountDifference: {
		value: -3
	},
	websocket: {
		value: null
	}
};

Soy.register(MonitorSingular, templates);

export default MonitorSingular;