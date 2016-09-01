CREATE TABLE Bookings(
	id varchar(36) not null primary key,
	email varchar(20) not null,
	phone number(10,0),
	booking_type varchar(20),
	pickup_place varchar(36),
	dropoff_place varchar(36),
	pickupTime timestamp with time zone
)


ALTER TABLE Bookings
add constraint bookingtype CHECK
(booking_type in ('METER', 'OUTSTATION', 'PACKAGE'));
