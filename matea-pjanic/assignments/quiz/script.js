/* global $ */

$(document).ready(
	function() {

		var allQuestions = [
			{choices: ['Sword', 'Gun', 'Kalashnikov'], correctAnswer: 'Sword', name: 'weapon', question: 'What kind of weapon is a falchion?'},
			{choices: ['Softly', 'With deep feeling', 'Calm, peacefull'], correctAnswer: 'Softly', name: 'piano', question: 'What does the term \'piano\' mean?'},
			{choices: ['Morgan Freeman', 'John Wayne', 'Harrison Ford'], correctAnswer: 'John Wayne', name: 'actor', question: 'Name the actor who starred in 142 films including The Quiet Man, The Shootist, The Searchers and Stagecoach?'},
			{choices: ['Football', 'Basketball', 'Golf'], correctAnswer: 'Golf', name: 'sport', question: 'Which sport does Constantino Rocca play?'},
			{choices: ['Girl with Pearl Earring', 'The Artist\'s Mother', 'The Mona Lisa'], correctAnswer: 'The Mona Lisa', name: 'painting', question: 'What is the painting \'La Gioconda\' more usually known as??'},
			{choices: ['1st January 1999', '1st January 1997', '15th January 1999'], correctAnswer: '1st January 1999', name: 'euro', question: 'When was the euro introduced as legal currency on the world market?'},
			{choices: ['Gutenberg Bible', 'The Diamond Sutra', 'Madrid Codex'], correctAnswer: 'The Diamond Sutra', name: 'book', question: 'What is the oldest surviving printed book in the world?'},
			{choices: ['David Cameron', 'Theresa May', 'Tony Blair'], correctAnswer: 'Theresa May', name: 'minister', question: 'Who is Prime Minister of the United Kingdom?'},
			{choices: ['Wine', 'Cheese', 'Steak'], correctAnswer: 'Wine', name: 'food', question: 'If you had Lafite-Rothschild on your dinner table, what would it be?'},
			{choices: ['George Lucas', 'Peter Jackson', 'Steven King'], correctAnswer: 'Peter Jackson', name: 'lor', question: 'Name the director of the Lord of the Rings trilogy.'}
			];
		var i = 0;
		var score = 0;

		$('.answer').click(
			function() {
				$('.answer').hide();
				$('.next').show();
				$('.result').show();
				var checked = $('input[type="radio"]:checked');

				var answer = checked.next().text();

				if (answer == '') {
					$('.result').text('Undefined answer');
					$('.score').text('Score: ' + score);
				}

				else if (answer == allQuestions[i].correctAnswer) {
					score += 10;
					$('.result').text(answer + ' is correct answer');
					$('.score').text('Score: ' + score);
				}

				else {
					$('.result').text('Nope,' + answer + ' is not correct answer. Correct answer is ' + allQuestions[i].correctAnswer + '.');
					$('.score').text('Score: ' + score);
				}

				if (i == (allQuestions.length - 1)) {
					$('.next').hide();
					$('.finish').show();
				}

				i++;
			}
			);

		$('.finish').click(
			function() {

				$('.question').hide();
				var radio = $('input[type="radio"]');

				radio.each(
					function() {
						$(this).hide();
						$(this).next().hide();
					}
					);

				$(this).hide();
				$('.result').text('THE END');
				$('.score').text('Your score: ' + score);
			}
			);

		$('.next').click(
			function() {

				$('.answer').show();

				$('.next').hide();

				$('.result').hide();

				$('.question').text(allQuestions[i].question);

				var radio = $('input[type="radio"]');

				radio.prop('checked', false);

				var newName = allQuestions[i].name;

				radio.each(
					function(j) {
						$(this).attr('name', newName);

						$(this).next().text(allQuestions[i].choices[j]);
					}
					);
			}
			);
	}
	);