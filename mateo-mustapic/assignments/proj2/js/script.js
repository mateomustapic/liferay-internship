$(document).ready(function(){

var firstNumberInput = document.getElementById("firstNumber");
var secondNumberInput = document.getElementById("secondNumber");
var resultInput = document.getElementById("result");

$('#multiply').on('click', multiplyBy);
$('#divide').on('click', divideBy);
$('#sum').on('click', sumBy);
$('#substract').on('click', substractBy);
$('#increment').on('click', increment);
$('#showPi').on('click',showPi);
$('#calculateTax').on('click',calculateTax);
$('#euroConverter').on('change',euroConverter);
$('#dollarConverter').on('change',dollarConverter);
$('#poundConverter').on('change',poundConverter);
$('#yenConverter').on('change',yenConverter);



function multiplyBy(){
	var num1 = parseInt(firstNumberInput.value);
	var num2 = parseInt(secondNumberInput.value);

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	else if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else {
		(resultInput).innerHTML = num1 * num2;
	}
}

function divideBy(){
	var num1 = parseInt(firstNumberInput.value);
	var num2 = parseInt(secondNumberInput.value);

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	else if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else {
		(resultInput).innerHTML = num1 / num2;
	}
}

function sumBy(){
	var num1 = parseInt(firstNumberInput.value);
	var num2 = parseInt(secondNumberInput.value);

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	else if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else {
		(resultInput).innerHTML = num1 + num2;
	}
}

function substractBy(){
	var num1 = parseInt(firstNumberInput.value);
	var num2 = parseInt(secondNumberInput.value);

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	else if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else {
		(resultInput).innerHTML = num1 - num2;
	}
}

function increment(){
	var num1 = parseInt(firstNumberInput.value);
	num1++;
	num2 = num1;

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	else if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else {
		document.getElementById("secondNumber").value = num2;
	}
}

function reset(){
	document.getElementById("firstNumber").reset();
	document.getElementById("secondNumber").reset();
}

function showPi(){
	document.getElementById("piResult").innerHTML = Math.PI;
}

function calculateTax(){
	salary = document.getElementById("sal").value;
	var tax = 0.25;
	document.getElementById("taxResult").innerHTML = salary * tax;
}

function euroConverter(){
	document.converter.dollar.value = document.converter.euro.value * 1.470;
	document.converter.pound.value = document.converter.euro.value * 0.717;
	document.converter.yen.value = document.converter.euro.value * 165.192;
}

function dollarConverter(){
	document.converter.euro.value = document.converter.dollar.value * 0.680;
	document.converter.pound.value = document.converter.dollar.value * 0.488;
	document.converter.yen.value = document.converter.dollar.value * 112.36;
}

function poundConverter(){
	document.converter.dollar.value = document.converter.pound.value * 2.049;
	document.converter.euro.value = document.converter.pound.value * 1.394;
	document.converter.yen.value = document.converter.pound.value * 230.27;
}

function yenConverter(){
	document.converter.dollar.value = document.converter.yen.value * 0.0089;
	document.converter.pound.value = document.converter.yen.value * 0.00434;
	document.converter.euro.value = document.converter.yen.value * 0.00605;
}

});