import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './Header.soy';

class Header extends Component {}

Soy.register(Header, templates);

export default Header;