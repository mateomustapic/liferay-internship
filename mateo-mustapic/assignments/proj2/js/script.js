function multiplyBy(){
	num1 = document.getElementById("firstNumber").value;
	num2 = document.getElementById("secondNumber").value;
	
	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else if ((num1 >= 1 && num1 <= 100)&&(num2 >= 1 && num2 <= 100)){
		document.getElementById("result").innerHTML = num1 * num2;
	}
}

function divideBy() 
{ 
    num1 = parseInt(document.getElementById("firstNumber").value);
    num2 = parseInt(document.getElementById("secondNumber").value);
	
	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}
	else if ((num1 >= 1 && num1 <= 100)&&(num2 >= 1 && num2 <= 100)){
		document.getElementById("result").innerHTML = num1 / num2;
	}
}

function sumBy(){
	num1 = parseInt(document.getElementById("firstNumber").value);
	num2 = parseInt(document.getElementById("secondNumber").value);
	
	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}
	else if ((num1 >= 1 && num1 <= 100)&&(num2 >= 1 && num2 <= 100)){
		document.getElementById("result").innerHTML = num1 + num2;
	}
}

function substractBy(){
	num1 = parseInt(document.getElementById("firstNumber").value);
	num2 = parseInt(document.getElementById("secondNumber").value);
	
	if (num1 > 100 || num1 < 1) {
		alert("Please insert number between 1 and 100");
	}
	
	if (num2 > 100 || num2 < 1) {
		alert("Please insert number between 1 and 100");
	}
	else if ((num1 >= 1 && num1 <= 100)&&(num2 >= 1 && num2 <= 100)){
		document.getElementById("result").innerHTML = num1 - num2;
	}
}

function increment(){
	num1 = parseInt(document.getElementById("firstNumber").value);
	num1++;
	num2 = num1;

	if (num1 > 100 || num1 < 1) {
		alert("Please insert first number between 1 and 100");
	}
	
	if (num2 > 100 || num2 < 1) {
		alert("Please insert second number between 1 and 100");
	}

	else if ((num1 >= 1 && num1 <= 100)&&(num2 >= 1 && num2 <= 100)){
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

