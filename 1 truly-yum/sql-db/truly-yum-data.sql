-- 1. View Menu Item List Admin
-- 	a. Frame insert scripts to add data into menu_item table.

INSERT INTO `truyum`.`menu` (`item_id`, `item_name`, `item_price`, `item_active`, `item_date_of_launch`, `item_category`, `item_free_delivery`) VALUES ('1', 'Sandwich', '99.00', 'Yes', '2021-01-01', 'Main Course', 'Yes');
INSERT INTO `truyum`.`menu` (`item_id`, `item_name`, `item_price`, `item_active`, `item_date_of_launch`, `item_category`, `item_free_delivery`) VALUES ('2', 'Burger', '129.00', 'Yes', '2021-01-02', 'Main Course', 'No');
INSERT INTO `truyum`.`menu` (`item_id`, `item_name`, `item_price`, `item_active`, `item_date_of_launch`, `item_category`, `item_free_delivery`) VALUES ('3', 'Pizza', '149.00', 'Yes', '2021-01-05', 'Main Course', 'No');
INSERT INTO `truyum`.`menu` (`item_id`, `item_name`, `item_price`, `item_active`, `item_date_of_launch`, `item_category`, `item_free_delivery`) VALUES ('4', 'French Fries', '57.00', 'No', '2021-01-10', 'Starters', 'Yes');
INSERT INTO `truyum`.`menu` (`item_id`, `item_name`, `item_price`, `item_active`, `item_date_of_launch`, `item_category`, `item_free_delivery`) VALUES ('5', 'Chocolate Brownie', '32.00', 'Yes', '2021-02-11', 'Dessert', 'Yes');

-- 	b. Frame SQL query to get all menu items

SELECT * FROM truyum.user;

-- 2. View Menu Item List Customer
-- 	a. Frame SQL query to get all menu items which after launch date and is active.

SELECT item_name, item_free_delivery, item_price, item_category FROM truyum.menu WHERE item_active = 'Yes' and item_date_of_launch < curdate();

-- 3. Edit Menu Item
-- 	a. Frame SQL query to get a menu items based on Menu Item Id

SELECT item_name, item_price, item_active, item_date_of_launch, item_category, item_free_delivery FROM truyum.menu WHERE item_id = 1;

-- 	b. Frame update SQL menu_items table to update all the columns values based on Menu Item Id

UPDATE truyum.menu SET item_name = '', item_price = '', item_active = '', item_date_of_launch = '', item_free_delivery = '' WHERE item_id = 1;

-- 4. Add to Cart
-- 	a. Frame insert scripts for adding data into user and cart tables.In user table create two users. Once user will not have any entries in cart, while the other will have at least 3 items in the cart.

INSERT INTO `truyum`.`user` (`user_id`, `user_name`) VALUES ('1', 'Harsh Verma');
INSERT INTO `truyum`.`user` (`user_id`, `user_name`) VALUES ('2', 'Brijesh Rathore');

INSERT INTO `truyum`.`cart` (`cart_id`, `user_id`, `item_id`) VALUES ('1', '1', '2');
INSERT INTO `truyum`.`cart` (`cart_id`, `user_id`, `item_id`) VALUES ('2', '1', '3');
INSERT INTO `truyum`.`cart` (`cart_id`, `user_id`, `item_id`) VALUES ('3', '1', '1');

-- 5. View Cart
-- 	a. Frame SQL query to get all menu items in a particular user’s cart

cartcartSELECT item_name, item_free_delivery, item_price FROM truyum.cart NATURAL JOIN truyum.menu WHERE user_id = 1;

-- 	b. Frame SQL query to get the total price of all menu items in a particular user’s cart

SELECT sum(item_price) FROM truyum.cart NATURAL JOIN truyum.menu WHERE user_id = 1;

-- 6. Remove Item from Cart
-- 	a. Frame SQL query to remove a menu items from Cart based on User Id and Menu Item Id

DELETE FROM truyum.cart WHERE user_id = '' and item_id = ''; 

