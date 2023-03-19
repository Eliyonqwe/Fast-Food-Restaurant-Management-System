/*
 *  DATABASE FOR RESTAURANT MANAGEMENT SYSTEM 
 */
CREATE DATABASE ProjectDB
USE ProjectDB





/* 
 * ADMINISTRATOR TABLE CREATING 
 */
CREATE TABLE admin(
	adminId int IDENTITY(100,1),
	firstName varchar(20) NOT NULL,
	lastName varchar(20) NOT NULL,
	username varchar(30) UNIQUE NOT NULL,
	password varchar(20) NOT NULL,
	CONSTRAINT PK_AID PRIMARY KEY (adminId)
);
DROP TABLE admin;
SELECT * FROM admin;
INSERT INTO admin VALUES ('Hawariaw', 'Paulos', 'hawa701', '1111' );
INSERT INTO admin VALUES ('Kidanekal', 'Melkam', 'kido222', '2222' );
INSERT INTO admin VALUES ('Kidus', 'Mesfin', 'kida333', '3333' );
INSERT INTO admin VALUES ('Eliyon', 'Mesfin', 'eli444', '4444' );
INSERT INTO admin VALUES ('Kalid', 'Nuredin', 'kali555', '5555' );





/*
 * WAITER TABLE 
 */
CREATE TABLE waiter(
	waiterId int IDENTITY(200,1),
	firstName varchar(20) NOT NULL,
	lastName varchar(20) NOT NULL,
	username varchar(30) UNIQUE NOT NULL,
	password varchar(20),
	gender varchar(6) ,
	age int,
	salary money,
	experiance int
	CONSTRAINT PK_WID PRIMARY KEY (waiterId)
);
DROP TABLE waiter;
SELECT * FROM waiter;
INSERT INTO waiter VALUES ('Helen', 'Mola', 'heli000', '0000', 'female', 18, 6000, 0);
INSERT INTO waiter VALUES ('Biruk', 'Yohannes', 'bura111', '1111', 'male', 20, 5000, 2);
INSERT INTO waiter VALUES ('Mickias', 'Seyoum', 'micki000', '2222', 'male', 22, 5600, 1);





/*
 * CUSTOMER TABLE 
 */
CREATE TABLE customer(
	customerId int IDENTITY(400,1),
	firstName varchar(20),
	lastName varchar(20),
	username varchar(30) UNIQUE,
	password varchar(20),
	email varchar(50),
	CONSTRAINT PK_CID PRIMARY KEY (customerId)
);
DROP TABLE customer;
SELECT * FROM customer;
INSERT INTO customer VALUES ('Abebe', 'Gashaw', 'abe123', '1234', 'abe@email.com');





 /*
 * ORDERS TABLE 
 */
CREATE TABLE orders(
	orderId int IDENTITY(2000,1),
	customerid int foreign key references customer (customerId),
	waiterID int foreign key references waiter (waiterId),
	total float,
	orderDate date,
	CONSTRAINT PK_OID PRIMARY KEY (orderId)
);
DROP TABLE orders;
SELECT * FROM orders;
DELETE FROM orders;




 /*
  * INGREDIENTS TABLE 
  */
CREATE TABLE ingredients(
	  itemId int IDENTITY(10,1),
	  itemName varchar(20) NOT NULL UNIQUE,
	  quantity float,
	  price money NOT NULL,
	  CONSTRAINT PK_IID PRIMARY KEY(itemId) ,
);

DROP TABLE ingredients;
SELECT * FROM ingredients;
INSERT INTO ingredients VALUES ( 'Bread', 5, 2.50 );
INSERT INTO ingredients VALUES ( 'Cheese', 5, 20.00 );
INSERT INTO ingredients VALUES ( 'Meat', 5, 30.00 );
INSERT INTO ingredients VALUES ( 'Beef', 5, 25.00 );
INSERT INTO ingredients VALUES ( 'Eggs', 5, 7.50 );
INSERT INTO ingredients VALUES ( 'Flour', 5, 12.70 );
INSERT INTO ingredients VALUES ( 'Tomatoes', 5, 33.00 );
INSERT INTO ingredients VALUES ( 'Soft Drinks', 5, 10.00 );
INSERT INTO ingredients VALUES ( 'Water', 5, 8.00 );





/*
 * FOOD TABLE 
 */
CREATE TABLE food (
	foodId int PRIMARY KEY IDENTITY(1000,1),	
	name varchar(30) UNIQUE NOT NULL,
	price money NOT NULL,   	
	foodType varchar(23)
);

DROP TABLE food;
SELECT * FROM food
INSERT INTO food VALUES ('Beef Burger', 120, 'Burger');
INSERT INTO food VALUES ('Cheese Burger', 140, 'Burger');
INSERT INTO food VALUES ('Double Burger', 180, 'Burger');
INSERT INTO food VALUES ('Cheese Pizza', 200, 'Pizza');
INSERT INTO food VALUES ('Special Pizza', 220, 'Pizza');
INSERT INTO food VALUES ('Soft Drink', 15, 'Drink');
INSERT INTO food VALUES ('Water', 15, 'Drink');
DELETE FROM food;





/*
 * RECIPE TABLE 
 */
CREATE TABLE recipe(
	foodIdRef int FOREIGN KEY REFERENCES food (foodId) NOT NULL,
	bread float,
	cheese float,
	meat float
);

DROP TABLE recipe;
SELECT * FROM recipe;
INSERT INTO recipe VALUES (1000, 1, 0, 0.4);
INSERT INTO recipe VALUES (1001, 1, 0.2, 0.5);
INSERT INTO recipe VALUES (1002, 1, 0.4, 1);

CREATE VIEW menu_table AS SELECT * FROM Food LEFT JOIN recipe ON FOOD.foodId = recipe.foodIdRef;