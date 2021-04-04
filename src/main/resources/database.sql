CREATE TABLE Address (
   id SERIAL primary key,
   streetName VARCHAR (100) not null,
   number VARCHAR (10) not null,
   complement VARCHAR (100),
   neighbourhood VARCHAR (100) not null,
   city VARCHAR (100) not null,
   state VARCHAR (100) not null,
   country VARCHAR (100) not null,
   zipcode VARCHAR (10) not null,
   latitude Double,
   longitude Double 
);