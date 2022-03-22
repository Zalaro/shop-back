-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS `shop`;
USE `shop`;


-- CREATE CATEGORIES TABLE
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories`(
    `category_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(255) NOT NULL
) ENGINE= InnoDB DEFAULT CHARSET=utf8;


-- CREATE PRODUCTS TABLE
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`(
    `product_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `designation` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `price` DOUBLE NOT NULL,
    `photo` VARCHAR(255) NOT NULL,
    `promotion` BOOLEAN NOT NULL,
    `selected` BOOLEAN NOT NULL,
    `quantity` INTEGER NOT NULL,
    `tva` DOUBLE NOT NULL,
    `category_id` INTEGER NOT NULL,
    FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE= InnoDB DEFAULT CHARSET=utf8;


-- INSERT DATA INTO CATEGORIES TABLE
INSERT INTO `categories` (`category_name`) VALUES ("VIDEO");
INSERT INTO `categories` (`category_name`) VALUES ("MUSIC");
INSERT INTO `categories` (`category_name`) VALUES ("GAME");

-- INSERT DATA INTO PRODUCTS TABLE
INSERT INTO `products` (`designation`,`description`,`price`,`photo`,`promotion`,`selected`,`quantity`,`tva`,`category_id`)
VALUES ("Produit 1","Lorem ipsum",15.25,"unknown.png",true,true,5,20,1);
INSERT INTO `products` (`designation`,`description`,`price`,`photo`,`promotion`,`selected`,`quantity`,`tva`,`category_id`)
VALUES ("Produit 2","Lorem ipsum",135.25,"unknown.png",false,false,15,5.50,2);
INSERT INTO `products` (`designation`,`description`,`price`,`photo`,`promotion`,`selected`,`quantity`,`tva`,`category_id`)
VALUES ("Produit 3","Lorem ipsum",1356.25,"unknown.png",true,false,25,10,3);

--TEST THE RELATION BETWEEN CATEGORIES AND PRODUCTS
SELECT * FROM products p, categories c 
WHERE p.category_id = c.category_id;

--DISPLAY ONLY USEFUL FIELDS
SELECT designation, price, category_name
FROM products p, categories c 
WHERE p.category_id = c.category_id;