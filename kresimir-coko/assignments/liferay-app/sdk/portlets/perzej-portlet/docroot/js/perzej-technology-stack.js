/* global Modernizr */

AUI().add(
	'perzej-technology-stack',
	function(A) {
		var PerzejTechnologyStack = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'perzej-technology-stack',

				prototype: {
					initializer: function(config) {
						var instance = this;

						if (!Modernizr.objectfit) {
							var techStackContainer = instance.byId('tech-stack');

							if (techStackContainer) {
								var technologyImages = techStackContainer.all('.technology-image');

								technologyImages.each(
									function(item) {
										var technologyImage = item.one('img');

										if (technologyImage) {
											var imageUrl = technologyImage.attr('src');

											if (imageUrl) {
												item.setStyle('backgroundImage', 'url(' + imageUrl + ')');

												item.addClass('compat-object-fit');
											}
										}
									}
								);
							}
						}
					}
				}
			}
		);

		Liferay.Portlet.PerzejTechnologyStack = PerzejTechnologyStack;
	},
	'',
	{
		requires: ['aui-node', 'liferay-portlet-base']
	}
);