/* adding information to div1 */
function addJFK () { 
	const para = document.createElement("p");
	let text = document.createTextNode(`John F. Kennedy International Airport (IATA: JFK, ICAO: KJFK, FAA LID: JFK) 
		is a major international airport located near 
		South Ozone Park in the borough of Queens in New York City, United States, 
		12 miles (20 km) southeast of Lower Manhattan. 
		It is the busiest international air passenger gateway into the United States, the fifth busiest airport in the 
		United States and the busiest airport in the New York City airport system, handling 58,956,288 passengers in 2016. `);
	para.appendChild(text);
	var element = document.getElementById("div1");
	element.appendChild(para); 
}
/* adding information to div2 */
function addDubai () { 
	const para = document.createElement("p");
	let text = document.createTextNode(`Dubai International Airport (IATA: DXB, ICAO: OMDB) is the primary airport serving Dubai, 
		United Arab Emirates and is the world's busiest airport by international passenger traffic.
		 It is also the 3rd busiest airport in the world by passenger traffic, the 6th busiest cargo airport in world, 
		 the busiest airport for Airbus A380 and Boeing 777 movements, and the busiest airport in the world operating with only two runways.`);
	para.appendChild(text);
	var element = document.getElementById("div2");
	element.appendChild(para); 
}
/* adding information to div3 */
function addFrankfurt () { 
	const para = document.createElement("p");
	let text = document.createTextNode(`Frankfurt Airport (IATA: FRA, ICAO: EDDF) is a major international airport located in Frankfurt.  
		The airport covers an area of 2,000 hectares of land and features two passenger terminals with a 
		capacity of approximately 65 million passengers per year, four runways and extensive logistics and maintenance facilities.`);
	para.appendChild(text);
	var element = document.getElementById("div3");
	element.appendChild(para); 
}
$(document).ready(addJFK);
$(document).ready(addDubai); 
$(document).ready(addFrankfurt);

