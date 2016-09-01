CREATE TABLE TaxiUser(
	id varchar(36) not null primary key,
	email varchar(20) not null,
	password varchar(8) not null,
	phone number(10,0),
	city varchar(20)
)