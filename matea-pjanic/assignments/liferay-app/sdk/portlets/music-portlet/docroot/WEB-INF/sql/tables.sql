create table Music_Album (
	albumId LONG not null primary key,
	bendId LONG,
	image VARCHAR(75) null,
	name VARCHAR(75) null,
	year INTEGER
);

create table Music_Bend (
	bendId LONG not null primary key,
	name VARCHAR(75) null
);

create table Music_Event (
	eventId LONG not null primary key,
	artist VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null,
	date_ LONG,
	name VARCHAR(75) null
);

create table Music_Song (
	songId LONG not null primary key,
	albumId LONG,
	name VARCHAR(75) null
);