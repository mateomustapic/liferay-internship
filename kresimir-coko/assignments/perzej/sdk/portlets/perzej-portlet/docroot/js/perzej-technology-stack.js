/* global Modernizr */

AUI().add(
	'perzej-technology-stack',
	function(A) {
		var mediaQuery = window.matchMedia('(max-width: 768px)');

		if (!Modernizr.objectfit && mediaQuery.matches) {
			var techStackContainer = A.one('#tech-stack');

			var technologyImages = techStackContainer.all('.technology-image');

			technologyImages.each(
				function(technologyImageNode) {
					var technologyImage = technologyImageNode.one('img');

					var imageUrl = technologyImage.getAttribute('src');

					if (imageUrl) {
						technologyImageNode.setStyle('backgroundImage', 'url(' + imageUrl + ')');
						technologyImageNode.addClass('compat-object-fit');
					}
				}
			);
		}
	},
	'',
	{
		requires: ['aui-node']
	}
);