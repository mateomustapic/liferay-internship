$(document).ready(function(){
	/* json for flight information */
	const flightZGBDBV = {
    	airline: 'Cro Airlines',
    	number: 'OU662',
    	departure: {
    		airport: 'ZGA',
    		time: '21:00'
    	},
    	arrival: {
    		airport: 'DBV',
    		time: '22:15'
    	}
    } 
    const flightZGBSPV = {
    	airline: 'Cro Airlines',
    	number: 'OU640',
    	departure: {
    		airport: 'SPV',
    		time: '18:00'
    	},
    	arrival: {
    		airport: 'ZGA',
    		time: '19:15'
    	}
    }
    const flightZGBLHA = {
    	airline: 'Cro Airlines',
    	number: 'BH441',
    	departure: {
    		airport: 'ZGA',
    		time: '15:00'
    	},
    	arrival: {
    		airport: 'LHA',
    		time: '17:35'
    	}
    }
    /* showing flight information in modal 1 window */  
    const departure = ('Airline: ' + flightZGBDBV.airline + ' Flight number: ' 
    	+ flightZGBDBV.number + ' Departure airport: ' + flightZGBDBV.departure.airport 
    	+ ' Departure Time: ' + flightZGBDBV.departure.time);
    document.getElementById("dep").innerHTML = departure;
    const arrival = ('Airline: ' + flightZGBDBV.airline + ' Flight number: ' 
    	+ flightZGBDBV.number + ' Arrival airport: ' + flightZGBDBV.arrival.airport 
    	+ ' Arrival Time: ' + flightZGBDBV.arrival.time);
    document.getElementById("arr").innerHTML = arrival;
    /* showing flight information in modal 2 window */  
    const departure2 = ('Airline: ' + flightZGBSPV.airline + ' Flight number: ' 
    	+ flightZGBSPV.number + ' Departure airport: ' + flightZGBSPV.departure.airport 
    	+ ' Departure Time: ' + flightZGBSPV.departure.time);
    document.getElementById("dep2").innerHTML = departure2;
    const arrival2 = ('Airline: ' + flightZGBSPV.airline + ' Flight number: ' 
    	+ flightZGBSPV.number + ' Arrival airport: ' + flightZGBSPV.arrival.airport 
    	+ ' Arrival Time: ' + flightZGBSPV.arrival.time);
    document.getElementById("arr2").innerHTML = arrival2;
    /* showing flight information in modal 3 window */  
    const departure3 = ('Airline: ' + flightZGBLHA.airline + ' Flight number: ' 
    	+ flightZGBLHA.number + ' Departure airport: ' + flightZGBLHA.departure.airport 
    	+ ' Departure Time: ' + flightZGBLHA.departure.time);
    document.getElementById("dep3").innerHTML = departure3;
    const arrival3 = ('Airline: ' + flightZGBLHA.airline + ' Flight number: ' 
    	+ flightZGBLHA.number + ' Arrival airport: ' + flightZGBLHA.arrival.airport 
    	+ ' Arrival Time: ' + flightZGBLHA.arrival.time);
    document.getElementById('arr3').innerHTML = arrival3;
    /* Append airline companies to unordered list */
	var list = ['Qatar Airways','British Airways','Easyjet','Ryanair','Croatia Airlines','Lufthansa','Turkish Airlines'];
	var newList = ['Wizzair', 'Flying Emirates'];
	list.push(...newList);
	ul = document.getElementById('companiesList'); 
	for(var i in list) {
		var li = document.createElement('li');
		var content = document.createTextNode(list[i]); 
		li.appendChild(content); 
		ul.appendChild(li); 
	}
    /* Sort the list of companies */
	$("#sortBtn").on("click", function () {
		$('#companiesList').html(
		    $('#companiesList').children("li").sort(function (a, b) {
		       return $(a).text().toUpperCase().localeCompare($(b).text().toUpperCase());
		    }) 
        ); 
    }); 
	/* Sort the list of airports */
	$("#sortBtn2").on("click", function () {
		$('#airportList').html(
	        $('#airportList').children("li").sort(function (a, b) {
	           return $(a).text().toUpperCase().localeCompare($(b).text().toUpperCase());
	       	}) 
        ); 
    }); 
	/* Pilot class */
	class Pilot {
	    constructor(name,lastname,email,id,country){
	    	this.name = name;
	    	this.lastname = lastname;
	    	this.email = email;
	    	this.id = id;
	    	this.country = country;
	    }
	    info(){
	    	return `- ${this.name} 
	    		${this.lastname}
	    		email: ${this.email} 
	    		id: ${this.id}
	    		country: ${this.country}`;
	    	}
	    	fullName(){
	    		return`${this.name} ${this.lastname}`;
	    	}
	    }
	/* creating new pilot objects */
	let Michael = new Pilot('Michael', 'Michaelson', 'mxm0044@gmail.com', '88', 'United Kingdom');
	let Peter = new Pilot('Peter', 'Carlson', 'pxc1122@live.com', '12', 'United States');
	let John = new Pilot('John', 'Wellington', 'jxw7752@live.com', '08', 'South Africa');
	document.getElementById('michaelDiv').innerHTML = Michael.info();
	document.getElementById('peterDiv').innerHTML = Peter.info();
	document.getElementById('johnDiv').innerHTML = John.info();
	document.getElementById('pilot1').innerHTML = Michael.fullName();
	document.getElementById('pilot2').innerHTML = Peter.fullName();
	document.getElementById('pilot3').innerHTML = John.fullName();
    /* Add new pilot on button click */
    $("#addBtn").on("click", function () {
		var x = document.createElement("UL");
		x.setAttribute("id", "pilotUL");
		document.body.appendChild(x);
		var y = document.createElement("LI");
		var newPilot = prompt("Enter pilot's name: ");
		var email = prompt("Enter pilot's email");
		var id = prompt("Enter pilot's id: ");
		var country = prompt("Enter pilot's country: ");
	    if ((newPilot != '') && (email != '' )&& (id != '') && (country != '')) {
	    $('#pilotUL').append('<li>' + '- ' + newPilot + ' email: ' + email + ' id: ' + id + ' country:' + country +'</li>');
	        alert('Pilot added to the list');
	    }
	    else{
	         alert('Please enter missing pilot information');
	        }
		}) 	
})


