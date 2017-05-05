AUI.add(
	'todo',
	function(A) {
		var EVENT_CLICK = 'click';

		var TPL_TASK = '<li>' +
				'{task}' +
				'<button class="delete-todo">X</button>' +
			'</li>';

		var Todo = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'todo',

				prototype: {
					initializer: function(config) {
						var instance = this;

						var todoList = instance.one('.task-container ul');

						if (todoList) {
							todoList.delegate(
								EVENT_CLICK,
								function(event) {
									var currentTarget = event.currentTarget;

									var listItem = currentTarget.ancestor('li');

									listItem.remove();
								},
								'button'
							);

							instance._todoList = todoList;
						}

						var addButton = instance.byId('add');

						if (addButton) {
							addButton.on(EVENT_CLICK, A.bind('_appendTodoList', instance));
						}

						var taskInput = instance.byId('task');

						if (taskInput) {
							taskInput.on('key', A.bind('_appendTodoList', instance), 'enter');

							instance._taskInput = taskInput;
						}
					},

					_appendTodoList: function(event) {
						var instance = this;

						var taskInput = instance._taskInput;
						var todoList = instance._todoList;

						if (taskInput.val() !== '' && todoList) {
							var taskHtml = A.Lang.sub(
								TPL_TASK,
								{
									task: taskInput.val()
								}
							);

							todoList.append(taskHtml);

							taskInput.val('');
						}
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