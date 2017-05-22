import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';

class View extends Component {
	setOnlineServerCount() {
		return 147;
	};

	setServerCountDifference() {
		return 3;
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