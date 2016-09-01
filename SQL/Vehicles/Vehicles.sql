CREATE TABLE Vehicles(
	id varchar(50) not null primary key,
	type varchar(20),
	type_full varchar(36),
	minKm number(10,0),
	addCharge number(5,0),
	wtgCharge number(5,0)
)