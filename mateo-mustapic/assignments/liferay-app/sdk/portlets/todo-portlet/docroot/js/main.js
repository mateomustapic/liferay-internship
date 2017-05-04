AUI.add(
	'todo',
	function(A) {
		var Todo = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'todo',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var newTask = A.one('.input-item');
						var todoList = A.one('.task-container ul');

						todoList.delegate(
							'click',
							function() {
								this.ancestor('li').remove();
							},
							'button'
						);

						instance._todoList = todoList;

						A.one('.add-item').on('click', A.bind('_appendTodoList', instance));

						newTask.on('key', A.bind('_appendTodoList', instance), 'enter');
					},

					_appendTodoList: function(event) {
						var instance = this;

						var todoList = instance._todoList;

						todoList.append('<li>' + newTask.get('value') + ' ' + '<button class="delete-todo">X</button></li>');

						newTask.set('value', '');
					}
				}
			}
		);

		Liferay.Portlet.Todo = Todo;
	},

	'',
	{
		requires: ['event-key', 'node-event-delegate']
	}
);