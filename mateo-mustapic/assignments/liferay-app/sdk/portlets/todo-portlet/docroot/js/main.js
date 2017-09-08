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

		var TPL_FORM_FAILURE_MESSAGE = '<div class="alert alert-error">' +
				'{taskSubmissionFailed} ' +
			'</div>';

		var TPL_FORM_SUCCESS_MESSAGE = '<div class="alert alert-success">' +
				'<i class="icon-ok"></i> ' +
				'{taskSuccessfullySubmitted}' +
			'</div>';

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

						var remainingDiv = instance.byId('remaining-tasks-count');

						instance._remainingDiv = remainingDiv;

						var taskSuccessfullySubmitted = config.taskSuccessfullySubmitted;

						instance._taskSuccessfullySubmitted = taskSuccessfullySubmitted;

						var taskSubmissionFailed = config.taskSubmissionFailed;

						instance._taskSubmissionFailed = taskSubmissionFailed;

						var taskListResourceURL = config.taskListResourceURL;

						instance._taskListResourceURL = taskListResourceURL;

						var emptyTaskHistory = instance.byId('empty-task-history');
						var finishedTask = instance.byId('finished-task');
						var taskHistory = instance.byId('history-list');
						var todoList = instance.byId('todo-list');

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

										var taskListItems = todoList.all('li');

										if (emptyTaskHistory && taskHistory && taskListItems) {
											emptyTaskHistory.hide();

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

						if (taskInput && todoList) {
							var taskHtml = A.Lang.sub(
								TPL_TASK,
								{
									taskContent: taskInput.val()
								}
							);

							todoList.append(taskHtml);

							var taskInputValue = taskInput.val();

							var taskListResourceURL = instance._taskListResourceURL;

							var requestStatus = instance.byId('request-status');

							A.io.request(
								taskListResourceURL,
								{
									method: 'post',

									data: {
										taskInputValue: taskInputValue
									},

									on: {
										failure: function() {
											var failureHtml = A.Lang.sub(
												TPL_FORM_FAILURE_MESSAGE,
												{
													taskSubmissionFailed: instance._taskSubmissionFailed
												}
											);

											requestStatus.html(failureHtml);
										},

										success: function() {
											var successHtml = A.Lang.sub(
												TPL_FORM_SUCCESS_MESSAGE,
												{
													taskSuccessfullySubmitted: instance._taskSuccessfullySubmitted
												}
											);

											requestStatus.html(successHtml);
										}
									}
								}
							);

							taskInput.val('');

							instance._updateTaskCounts();
						}
					},

					_updateTaskCounts: function() {
						var instance = this;

						var remainingDiv = instance._remainingDiv;
						var todoList = instance._todoList;

						if (remainingDiv && todoList) {
							var taskListItems = todoList.all('li');

							remainingDiv.html(taskListItems.size());
						}
					}
				}
			}
		);

		Liferay.Portlet.Todo = Todo;
	},

	'',
	{
		requires: ['aui-base', 'aui-char-counter', 'aui-io-request', 'event-key', 'liferay-portlet-base', 'node-event-delegate']
	}
);