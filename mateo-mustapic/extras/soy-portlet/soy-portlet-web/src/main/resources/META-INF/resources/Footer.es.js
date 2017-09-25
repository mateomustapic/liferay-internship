import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './Footer.soy';

class Footer extends Component {}

Soy.register(Footer, templates);

export default Footer;