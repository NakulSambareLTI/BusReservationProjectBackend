create table user_profile(
user_name varchar2(20), 
dob date, 
gender char(1), 
phone varchar2(10),
registered_email varchar2(30) PRIMARY KEY, 
password varchar2(20)	
);

create table unregistered_user(
unregistered_email varchar2(30) PRIMARY KEY,
unregistered_name varchar2(20)
);

create table bus_details(
bus_no varchar2(10) PRIMARY KEY,
bus_type varchar2(10),
no_of_seats number,
driver_id number(5),
travels_name varchar2(30),
cost_per_seat number(5)
);

create table bus_journey_details(
bus_no varchar2(10),
departure_time timestamp,
arrival_time timestamp,
source_loc varchar2(20),
destination_loc varchar2(20),
departure_date date,
journey_id number(10) PRIMARY KEY,
availableSeates number(2)
);

create table driver_details(
driver_id varchar2(10) PRIMARY KEY,
driver_name varchar2(30),
contact_no number(10),
driver_address varchar2(100)
);


create table feedback(
 email varchar2(20) PRIMARY KEY,
 feedback varchar2(50) 
);

create table admin(
email varchar2(30) PRIMARY KEY, 
password varchar2(20)
);

create table transaction_details(
transaction_id number(10) PRIMARY KEY,
registered_email varchar2(30),
unregistered_email varchar2(30),
reservation_id number(10),
transaction_date date,
payment_id number(10)
);

create table reservation_details(
reservation_id number(10) PRIMARY KEY,
registered_email varchar2(30),
unregistered_email varchar2(30),
seats_booked number(10),
journey_id number(10),
departure_date date,
reservation_date date,
driverLess varchar2(3),
reservation_time varchar2(10)
);


create table payment_details(
payment_id number(10) PRIMARY KEY,
registered_email varchar2(30),
unregistered_email varchar2(30),
reservation_id number(10),
payment_date date,
total_amount_paid number(5)
);


create table customer_wallet(
registered_email varchar(20) unique,
wallet_pin number(6),
wallet_id number(10),
wallet_amount number(10)
);

create table Passenger_Details(
reservation_id varchar2(20),
Passenger_Name varchar2(20),
Age number(2),
Gender varchar2(8)
);

create table Bus_Seates_Details(
Seat_No varchar2(5),
reservation_id number(10),
journey_id number(10)
);

alter table UNREGISTERED_USER
 add phone number(10);

alter table user_profile





