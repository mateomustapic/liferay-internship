/* global Modernizr */

AUI().use(
	'node',
	function(A) {
		if (!Modernizr.objectfit) {
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
	}
);