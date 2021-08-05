# TruYum
TruYum App built using JSP, Spring MVC and SQL database

## SQL Script
**Make sure to run these SQL script before running the application**
<br>
create database truyum;<br>
use truyum;<br>

CREATE TABLE menu_item (<br>
    id int NOT NULL, <br>
	name varchar(45), <br>
    price decimal(10,2), <br>
    active varchar(45),<br>
    date_of_launch date,<br>
    category varchar(45),<br>
    free_delivery varchar(45),<br>
    PRIMARY KEY (id)<br>
    
);

CREATE TABLE cart (<br>
    id int auto_increment,<br>
    cust_id int,<br>
    menu_id int,<br>
    PRIMARY KEY (ID),<br>
    FOREIGN KEY (menu_id) REFERENCES menu_item(id)<br>
);

insert into menu_item values(1,"Sandwich", 99, "yes", str_to_date('15/03/2017', '%d/%m/%Y'),"Main Course","yes");<br>
insert into menu_item values(2,"Burger", 129, "yes", str_to_date('21/05/2017', '%d/%m/%Y'),"Main Course","no");<br>
insert into menu_item values(3,"Pizza", 149, "yes", str_to_date('21/08/2018', '%d/%m/%Y'),"Main Course","no");<br>
insert into menu_item values(4,"French Fries", 57, "no", str_to_date('02/07/2017', '%d/%m/%Y'),"Starters","yes");<br>
insert into menu_item values(5,"Chocolate Brownie", 32, "yes", str_to_date('22/11/2022', '%d/%m/%Y'),"Desert","yes");<br>

## Switching between admin and customer
**Admin Endpoint:** http://localhost:8080/show-menu-list-admin
<br>
**Customer Endpoint:** http://localhost:8080/show-menu-list-customer
