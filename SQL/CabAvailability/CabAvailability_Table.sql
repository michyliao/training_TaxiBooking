CREATE TABLE CabAvailability(
	id varchar(36) not null primary key,
	vehicle_id varchar(36),
	driver_id varchar(36),	
	current_location varchar(36),
	available number(1,0)
)