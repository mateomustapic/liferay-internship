'use strict';

import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './MonitorSingular.soy';

const wsUri = 'ws://localhost:8080/o/singularEndpoint';

let websocket = null;

class MonitorSingular extends Component {
	created() {
		if (websocket && websocket.readyState === 1) {
			websocket.close();
		}

		websocket = new WebSocket(wsUri);

		websocket.onmessage = (evt) => {
			const serverMessageSpan = document.querySelector('.server-message');

			serverMessageSpan.innerHTML = evt.data;
		};
	};

	desposed() {
		if (websocket) {
			websocket.close();
		}
	};
}

MonitorSingular.STATE = {
	onlineServerCount: {
		value: 147
	},
	serverCountDifference: {
		value: -3
	}
};

Soy.register(MonitorSingular, templates);

export default MonitorSingular;