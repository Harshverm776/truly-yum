-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema turyum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema turyum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `turyum` DEFAULT CHARACTER SET utf8 ;
USE `turyum` ;

-- -----------------------------------------------------
-- Table `turyum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turyum`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turyum`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turyum`.`menu` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(60) NOT NULL,
  `item_price` DECIMAL(5,2) UNSIGNED NOT NULL,
  `item_active` VARCHAR(3) NOT NULL,
  `item_date_of_launch` DATE NOT NULL,
  `item_category` VARCHAR(60) NOT NULL,
  `item_free_delivery` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`item_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `turyum`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `turyum`.`cart` (
  `card_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  INDEX `fk_cart_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_cart_menu1_idx` (`item_id` ASC) VISIBLE,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `fk_cart_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `turyum`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_menu1`
    FOREIGN KEY (`item_id`)
    REFERENCES `turyum`.`menu` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
