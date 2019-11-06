DROP DATABASE IF EXISTS FreshVueDB;
CREATE DATABASE FreshVueDB;

USE FreshVueDB;

-- CREATE TABLE shopper(
--     shopperId BIGINT PRIMARY KEY AUTO_INCREMENT,
--     shopperName VARCHAR(40) NOT NULL,
--     email VARCHAR(300) NOT NULL,
--     mailingAddress VARCHAR(400) NOT NULL,
--     city VARCHAR(40) NOT NULL,
--     state CHAR(2) NOT NULL,
--     zipCode INT NOT NULL,
--     passwordHash TEXT NOT NULL,
--     isAdmin BOOL
-- );

CREATE TABLE item(
    itemId BIGINT PRIMARY KEY AUTO_INCREMENT,
    itemName VARCHAR(40),
    price decimal(5, 2) NOT NULL,
    inventory INT NOT NULL,
    image VARCHAR(1000),
    itemDescription TEXT
);

insert into item(itemName, price, inventory, image, itemDescription) values
	('T-Bone Steak', 9.99, 50, 'victoria-shes-XgFFJKSPkNk-unsplash.jpg', 'Grade A T-Bone Steak'),
    ('Blueberries', 4.99, 20, 'brandon-wilson-2eFgPIEoBsA-unsplash', 'Farm Fresh Blueberries'),
    ('Rainbow Chard', 3.99, 40, 'heather-barnes-ZGXhE1L7VL8-unsplash.jpg', 'Local, Organic Rainbow Chard');

-- CREATE TABLE review(
--     reviewId BIGINT PRIMARY KEY AUTO_INCREMENT,
--     rating INT NOT NULL,
--     statement TEXT,
--     itemId BIGINT NOT NULL REFERENCES item(itemId),
--     shopperId BIGINT NOT NULL REFERENCES shopper(shopperId)
-- );

CREATE TABLE cart(
    cartId BIGINT PRIMARY KEY AUTO_INCREMENT,
    cartDate DATE NOT NULL,
    cartStatus CHAR(5)
--     shopperId BIGINT NOT NULL REFERENCES shopper(shopperId)
);

insert into cart(cartDate, cartStatus) values
	('2019-09-29', 'PAID'),
    ('2019-10-05', 'PAID');

CREATE TABLE lineItem(
    cartId BIGINT NOT NULL REFERENCES cart(cartId),
    itemId BIGINT NOT NULL REFERENCES item(itemId),
    quantity INT NOT NULL,
    PRIMARY KEY (cartId, itemId)
);

insert into lineItem(cartId, itemId, quantity) values
	(1, 2, 3),
    (1, 1, 2),
    (2, 1, 1),
    (2, 2, 1);

-- CREATE TABLE payment(
-- 	paymentId BIGINT PRIMARY KEY AUTO_INCREMENT,
-- 	paymentType VARCHAR(40) NOT NULL,
--     amount decimal(7, 2) NOT NULL,
--     confirmationNumber BIGINT NOT NULL,
--     cartId BIGINT NOT NULL REFERENCES cart(cartId)
-- );
    

