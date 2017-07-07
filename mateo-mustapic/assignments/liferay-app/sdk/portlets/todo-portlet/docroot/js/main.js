AUI.add(
	'todo',
	function(A) {
		var EVENT_CLICK = 'click';

		var TPL_FINISHED_TASK = '<li>' +
				'{taskFinished}' +
				'<button>' +
					'<i class="icon-trash"></i>' +
				'</button>' +
			'</li>';

		var TPL_TASK = '<li>' +
				'{taskContent} ' +
				'<button class="btn delete-task">' +
					'<i class="icon-remove"></i>' +
				'</button>' +
			'</li>';

		var Todo = A.Component.create(
			{
				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'todo',

				prototype: {
					initializer: function(config) {
						var instance = this;

						new A.CharCounter(
							{
								counter: '.counter',
								input: '.input-item',
								maxLength: 35
							}
						);

						var todoList = instance.byId('todo-list');

						instance._todoList = todoList;

						var finishedTask = instance.byId('finished-task');

						var taskInput = instance.byId('task');

						var taskListItems = todoList.all('li');

						var taskHistory = instance.byId('history-list');

						instance._taskHistory = taskHistory;

						var emptyTaskHistory = instance.byId('empty-task-history');

						instance._emptyTaskHistory = emptyTaskHistory;

						var remainingDiv = instance.byId('remaining-tasks-count');

						instance._remainingDiv = remainingDiv;

						if (todoList) {
							todoList.delegate(
								EVENT_CLICK,
								function(event) {
									var currentTarget = event.currentTarget;

									var listItem = currentTarget.ancestor('li');

									listItem.remove();

									if (finishedTask) {
										var taskFinished = config.taskFinished;

										instance._taskFinished = taskFinished;

										var finishedHtml = A.Lang.sub(
											TPL_FINISHED_TASK,
											{
												taskFinished: instance._taskFinished
											}
										);

										finishedTask.append(finishedHtml);

										instance._updateTaskCounts();

										var taskHistory = instance._taskHistory;

										var emptyTaskHistory = instance._emptyTaskHistory;

										if (taskListItems) {
											emptyTaskHistory.hide();

											taskHistory.setStyle('visibility', 'visible');

											taskHistory.append(listItem);
										}
									}
								},
								'button'
							);

							instance._todoList = todoList;
						}

						if (finishedTask) {
							finishedTask.delegate(
								EVENT_CLICK,
								function(event) {
									var currentTarget = event.currentTarget;

									var finishedItem = currentTarget.ancestor('li');

									finishedItem.remove();
								},
								'button'
							);

							instance._finishedTask = finishedTask;
						}

						var addButton = instance.byId('add');

						if (addButton) {
							addButton.on(EVENT_CLICK, A.bind('_appendTodoList', instance));
						}

						if (taskInput) {
							taskInput.on('key', A.bind('_appendTodoList', instance), 'enter');

							instance._taskInput = taskInput;
						}
					},

					_appendTodoList: function(event) {
						var instance = this;

						var taskInput = instance._taskInput;

						var todoList = instance._todoList;

						if (taskInput && todoList) {
							var taskHtml = A.Lang.sub(
								TPL_TASK,
								{
									taskContent: taskInput.val()
								}
							);

							todoList.append(taskHtml);

							taskInput.val('');

							instance._updateTaskCounts();
						}
					},

					_updateTaskCounts: function() {
						var instance = this;

						var todoList = instance._todoList;

						var taskListItems = todoList.all('li');

						var remainingCount = taskListItems.size();

						var remainingDiv = instance._remainingDiv;

						if (remainingDiv) {
							remainingDiv.html(remainingCount);
						}
					}
				}
			}
		);

		Liferay.Portlet.Todo = Todo;
	},

	'',
	{
		requires: ['aui-char-counter', 'event-key', 'liferay-portlet-base', 'node-event-delegate']
	}
);