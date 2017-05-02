/**
 * Created by kresimircoko on 27/02/2017.
 */
const burgerOpen = document.querySelector('#burger-open');
const burgerClose = document.querySelector('#burger-close');
const navigation = document.querySelector('#site-nav');

function toggleNav() {
	if (!navigation.classList.contains('open')) {
		navigation.classList.add('open');
		burgerOpen.style.display = 'none';
		burgerClose.style.display = 'flex';
	} else {
		navigation.classList.remove('open');
		burgerOpen.style.display = 'flex';
		burgerClose.style.display = 'none';
	}
}

burgerOpen.addEventListener('click', toggleNav);
burgerClose.addEventListener('click', toggleNav);