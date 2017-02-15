var colors = ['red','blue','green'];

for (var i = 0; i <colors.length; i++){
	console.log(colors[i]);
}

colors.forEach(function(color){
	console.log(color);
})

var numbers = [1,2,3,4,5];
var doubledNumbers = [];
var sum = 0;

numbers.forEach(function(number){
	sum += number;
});

console.log(sum);

for(var j=0; j< numbers.length; j++){
	doubledNumbers.push(numbers[j] * 2);
}

console.log(doubledNumbers);

var doubled = numbers.map(function(number){
	return number * 2;
})

console.log(doubled);

var cars = [
{model: 'Opel Astra', price: 'Mid-price'},
{model: 'BMW M5', price: 'expensive'},
{model: 'Volkswagen Golf', price:'Mid-price'},
{model: 'Mercedes GLE', price:'expensive'},
{model: 'Chevrolet Spark', price: 'cheap'}
];

var models = cars.map(function(car){
	return car.model;
})

var prices = cars.map(function(car){
	return car.price;
})
console.log(prices);
console.log(models);

var products = [
	{name: 'cucumber', type: 'vegetable', quantity: 0, price: 1},
	{name: 'banana', type: 'fruit', quantity: 10, price: 15},
	{name: 'celery', type: 'vegetable', quantity: 30, price: 9},
	{name: 'orange', type: 'fruit', quantity: 3, price: 5}
];

var products1 = products.filter(function(product){
	return product.type === 'vegetable' && product.quantity > 0 && product.price < 10;
})

console.log(products1[0]);


var post = {id: 4, title: 'New Post'};

var comments = [
	{ postId: 4, content: 'awesome post' },
	{ postId: 3, content: 'it was ok' },
	{ postId: 4, content: 'neat' }
];

function commentsForPost(post, comments) {
	return comments.filter(function(comment) {
		return comment.postId === post.id;
	});
}

 for(var i = 0; i < comments.length; i++) {
console.log(commentsForPost(post, comments)[i]);
}


var users = [
	{name: 'Jill'},
	{name: 'Alex', id: 4},
	{name: 'Bill'}
]

var find = users.find(function(user) {
	return user.name === 'Alex';
})

console.log(find);

var computers = [
	{name: 'Apple', ram: 24},
	{name: 'Compaq', ram: 4},
	{name: 'Acer', ram: 32}
];

var allComputersCanRunPrograms = true;
var onlySomeComputersCanRunPrograms = false;

for (var i=0; i< computers.length; i++) {
	var computer = computers[i];

	if (computer.ram < 16){
		allComputersCanRunPrograms = false;
	} else {
		onlySomeComputersCanRunPrograms = true;
	}
}

console.log('---');
console.log(allComputersCanRunPrograms);
console.log(onlySomeComputersCanRunPrograms);
console.log('---');

//every 
var every = computers.every(function(computer){
	return computer.ram > 16;
})

//some
var some = computers.some(function(computer){
	return computer.ram > 16;
})

console.log('Every = ' + every);
console.log(some);


var trips = [{ distance: 34 }, { distance: 12 } , { distance: 1 }];

var totalDistance = trips.reduce(function(sum, trip) {
    return sum + trip.distance;
}, 5);

console.log(totalDistance);

const name = 'Jane';
let title = 'Software Engineer';

console.log(name + ' is a ' + title);

function getMessage() {
	const year = new Date().getFullYear();
	return `This is the year ${year}`;
}

console.log(getMessage());

const add = (a,b) => a + b;

const newSum = add(1,2);
console.log(newSum);

var phraseSplit = phrase => phrase.split("");
console.log(phraseSplit("Splitting"));

class Person{
	constructor() {
		this.firstName = "John";
		this.lastName = "Doe";
		this.Id = 4;
	}

	personInfo(){
		console.log('My name is ' + this.firstName + ' ' + this.lastName + ', my ID number is ' + this.Id);
		console.log(`My name is ${this.firstName} ${this.lastName}, my ID number is ${this.Id}`);
	}
}

var john = new Person();
john.personInfo();

var numbers2 = [2,4,7,9,12,15];
numbersMul = (numbers2.map(number => 2 * number));
console.log(numbersMul[3]);


const team = {
	members: ['Jane','Bill'],
	teamName: ['Super Squad'],
	teamSummary: function(){
		return this.members.map((member) => {
			return `${member} is on team ${this.teamName}`;
		});
	}
};

console.log(team.teamSummary());

function createBookShop(inventory){
	return{
		inventory,
		inventoryValue() {
			return this.inventory.reduce((total, book) => total + book.price, 0);
		},
		priceForTitle(title) {
			return ('The price for the book "') + title + '" is ' + this.inventory.find(book => book.title === title).price;
		}
	};
}

const inventory = [
{ title: 'Harry Potter', price: 19 },
{ title: 'Eloquent Javascript', price: 15 },
{ title: 'Game of Thrones', price: 17.8}
]

const bookShop = createBookShop(inventory);

console.log(bookShop.inventoryValue());

function User(id) {
	this.id = id;
}

function generateId(){
	return Math.round(Math.random() * 10);
}

function createAdminUser(user){
	user.admin = true;
	return user;
}

console.log('User id is: ' + generateId());
createAdminUser(new User(generateId()));

const defeaultColors = ['red', 'green'];
const userFavoriteColors = ['orange','yellow'];

[...defeaultColors, userFavoriteColors];