/* global $ */

$(document).ready(
	function() {

		$.getJSON(
			'questions.json',
			function(questions) {
				var i = 0;
				var score = 0;

				$('.start').click(
					function() {
						$(this).hide();
						$('.content').show();
					}
					);

				$('.answer').click(
					function() {
						$('.answer').hide();
						$('.next').show();
						$('.resultDiv').show();
						var checked = $('input[type="radio"]:checked');

						var answer = checked.next().text();

						if (answer == '') {
							$('.result').text('Undefined answer');
							$('.score').text('Score: ' + score);
						}

						else if (answer == questions[i].correctAnswer) {
							score += 10;
							$('.result').text('Yeah!! ' + answer + ' is correct answer');
							$('.score').text('Score: ' + score);
						}

						else {
							$('.result').text('Nope. ' + answer + ' is not correct answer. Correct answer is ' + questions[i].correctAnswer + '.');
							$('.score').text('Score: ' + score);
						}

						if (i == (questions.length - 1)) {
							$('.next').hide();
							$('.finish').show();
						}

						i++;
					}
					);

				$('.finish').click(
					function() {

						$('.content').hide();

						$('.endDiv').css('display', 'flex');

						var end = $('.endResult p');

						end.append(score + '/100.');

						if (score < 40) {
							end.append('<br>Well.. Why dont you try it all over again??');
						}

						if (score >= 40 && score < 70) {
							end.append('<br>Hmm.. sjedi 2');
						}

						if (score >= 70) {
							end.append('<br>Not bad! Not bad!');
						}
					}
					);

				$('.next').click(
					function() {

						$('.answer').show();

						$('.next').hide();

						$('.resultDiv').hide();

						$('.question').text(questions[i].question);

						var radio = $('input[type="radio"]');

						radio.prop('checked', false);

						var newName = questions[i].name;

						radio.each(
							function(j) {
								$(this).attr('name', newName);

								$(this).next().text(questions[i].choices[j]);
							}
							);
					}
					);
			}
			);
	}
	);