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

						var taskInput = instance.byId('task');

						taskInput.on('key', A.bind('_appendTodoList', instance), 'enter');

						instance._taskInput = taskInput;
					},

					_appendTodoList: function(event) {
						var instance = this;

						var taskInput = instance._taskInput;
						var todoList = instance._todoList;

						todoList.append('<li>' + taskInput.val() + ' ' + '<button class="delete-todo">X</button></li>');

						taskInput.val('');
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