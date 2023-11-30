-- MySQL Script generated by MySQL Workbench
-- Tue Nov 28 15:02:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Account` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`Account` (
  `personAccountID` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `middleName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `SSN` CHAR(9) NOT NULL,
  `streetAddress` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zipCode` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`personAccountID`, `SSN`, `username`, `password`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`BankAccount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BankAccount` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`BankAccount` (
  `accountID` INT NOT NULL,
  `accountName` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NOT NULL,
  `AccountType` ENUM('CHECKING', 'SAVINGS', 'CREDIT') NOT NULL,
  PRIMARY KEY (`accountID`, `accountName`),
  CONSTRAINT `fk_bankaccount_customer`
    FOREIGN KEY (`accountID`)
    REFERENCES `mydb`.`Customer` (`customerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `accountName_UNIQUE` ON `mydb`.`BankAccount` (`accountName` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`CreditCard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`CreditCard` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`CreditCard` (
  `linkedAccountID` INT NOT NULL,
  `creditNumber` VARCHAR(45) NOT NULL,
  `expirationDate` DATETIME NOT NULL,
  `creditLimit` DOUBLE NOT NULL,
  `dueDate` DATETIME NOT NULL,
  PRIMARY KEY (`linkedAccountID`, `creditNumber`),
  CONSTRAINT `fk_credit_bankaccount`
    FOREIGN KEY (`linkedAccountID`)
    REFERENCES `mydb`.`BankAccount` (`accountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `creditNumber_UNIQUE` ON `mydb`.`CreditCard` (`creditNumber` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Customer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`Customer` (
  `customerID` INT NOT NULL,
  PRIMARY KEY (`customerID`),
  CONSTRAINT `fk_customer_account`
    FOREIGN KEY (`customerID`)
    REFERENCES `mydb`.`Account` (`personAccountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `customerID_UNIQUE` ON `mydb`.`Customer` (`customerID` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`DebitCard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DebitCard` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`DebitCard` (
  `linkedAccountID` INT NOT NULL,
  `debitNumber` VARCHAR(45) NOT NULL,
  `expirationDate` DATETIME NOT NULL,
  `limits` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`linkedAccountID`, `debitNumber`),
  CONSTRAINT `fk_debit_bankaccount`
    FOREIGN KEY (`linkedAccountID`)
    REFERENCES `mydb`.`BankAccount` (`accountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `debitNumber_UNIQUE` ON `mydb`.`DebitCard` (`debitNumber` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`Manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Manager` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`Manager` (
  `accountID` INT NOT NULL,
  PRIMARY KEY (`accountID`),
  CONSTRAINT `fk_managerSSN_account`
    FOREIGN KEY (`accountID`)
    REFERENCES `mydb`.`Account` (`personAccountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`Teller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Teller` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`Teller` (
  `employeeID` INT NOT NULL,
  PRIMARY KEY (`employeeID`),
  CONSTRAINT `fk_tellerSSN_account`
    FOREIGN KEY (`employeeID`)
    REFERENCES `mydb`.`Account` (`personAccountID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
