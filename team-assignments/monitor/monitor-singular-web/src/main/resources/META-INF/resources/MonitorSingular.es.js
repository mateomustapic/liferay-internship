'use strict';

import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './MonitorSingular.soy';

const wsUri = 'ws://localhost:8080/o/singularEndpoint';

let websocket = null;

class MonitorSingular extends Component {
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