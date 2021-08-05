use truyum1;

CREATE TABLE menu_item (
    id int NOT NULL, 
	name varchar(45), 
    price decimal(10,2), 
    active varchar(45),
    date_of_launch date,
    category varchar(45),
    free_delivery varchar(45),
    PRIMARY KEY (id)
    
);

CREATE TABLE cart (
    id int auto_increment,
    cust_id int,
    menu_id int,
    PRIMARY KEY (ID),
    FOREIGN KEY (menu_id) REFERENCES menu_item(id)
);

insert into menu_item values(1,"Sandwich", 99, "yes", str_to_date('15/03/2017', '%d/%m/%Y'),"Main Course","yes");
insert into menu_item values(2,"Burger", 129, "yes", str_to_date('21/05/2017', '%d/%m/%Y'),"Main Course","no");
insert into menu_item values(3,"Pizza", 149, "yes", str_to_date('21/08/2018', '%d/%m/%Y'),"Main Course","no");
insert into menu_item values(4,"French Fries", 57, "no", str_to_date('02/07/2017', '%d/%m/%Y'),"Starters","yes");
insert into menu_item values(5,"Chocolate Brownie", 32, "yes", str_to_date('22/11/2022', '%d/%m/%Y'),"Desert","yes");
