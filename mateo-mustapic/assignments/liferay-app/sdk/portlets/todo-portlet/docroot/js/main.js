AUI.add(
	'todo-list-add-remove',
	function(A) {
		var addRemove = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'addRemove',

				prototype: {
					initializer: function(config) {
						var instance = this;
						var newTask = A.one('.input-item');
						var todoList = A.one('.task-container ul');

						// button's containing <li> to be removed
						todoList.delegate('click', function() {
							this.ancestor('li').remove();
						}, 'button');

						// Adding a new task is only appending a list item
						function addTodo() {
							todoList.append('<li>' + newTask.get('value') + ' ' + '<button class="delete-todo">X</button></li>');
							newTask.set('value', '');
						}

						A.one('.add-item').on('click', addTodo);
						newTask.on('key', addTodo, 'enter');
					}
				}
			}
		);

		Liferay.Portlet.addRemove = addRemove;
	},

	'',
	{
		requires: ['event-key', 'node-event-delegate']
	}
);
