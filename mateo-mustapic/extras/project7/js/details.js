$(document).ready(function(){
    /*users json*/
    const text = '{"users":[' +
        '{"username":"doe122","firstName":"John","lastName":"Doe","email":"johndoe111@gmail.com" },' +
        '{"username":"anna750","firstName":"Anna","lastName":"Smith","email":"anniesmith000@outlook.com" },' +
        '{"username":"pete007","firstName":"Peter","lastName":"Jones","email":"pete998@live.com" }]}';

    var obj;
    obj = JSON.parse(text);
    document.getElementById("johnLi").innerHTML = obj.users[0].username;
    document.getElementById("annaLi").innerHTML = obj.users[1].username;
    document.getElementById("peteLi").innerHTML = obj.users[2].username;
    $("#detailsButton").on("click", function () {
        const george = {
            username: 'george2345',
            firstName:'George', 
            lastName:'Watson',  
            email: 'gwatson@gmail.com'
        };
        const halley = {
            username: 'halley735',
            firstName: 'Halley',
            lastName: 'Jackson',
            email: 'halley735@live.com'
        }
        const adele = {
            username: 'adele2345',
            firstName: 'Adele',
            lastName: 'Smith',
            email: 'adele2345@gmail.com'
        }
        const agnes = {
            username: 'agnes112',
            firstName: 'Agnes',
            lastName: 'Bellington',
            email: 'agny248@gmail.com'
        }
        const billy = {
            username: 'billy735',
            firstName: 'Billy',
            lastName: 'Jordan',
            email: 'billybob@gmail.com'
        }
        document.getElementById('georgeLi').innerHTML = 'name: ' + george.firstName + ', last name:' + george.lastName + ', email: ' + george.email;
        document.getElementById('halleyLi').innerHTML = 'name: ' + halley.firstName + ', last name:' + halley.lastName + ', email: '+ halley.email;
        document.getElementById('adeleLi').innerHTML = 'name: ' + adele.firstName + ', last name:' + adele.lastName + ', email: ' + adele.email;
        document.getElementById('agnesLi').innerHTML = 'name: ' + agnes.firstName + ', last name:' + agnes.lastName + ', email: ' + agnes.email;
        document.getElementById('billyLi').innerHTML = 'name: ' + billy.firstName + ', last name:' + billy.lastName + ', email: ' + billy.email;
        document.getElementById("johnDetails").innerHTML = 'name: ' + obj.users[0].firstName + ', last name: ' + obj.users[0].lastName + ', email: ' + obj.users[0].email;   
        document.getElementById("annaDetails").innerHTML = 'name: ' + obj.users[1].firstName + ', last name: ' + obj.users[1].lastName + ', email: ' +  obj.users[1].email;
        document.getElementById("peteDetails").innerHTML = 'name: ' + obj.users[2].firstName + ', last name:' + obj.users[2].lastName + ', email: ' + obj.users[2].email;
    })       
})
