-- MySQL Script generated by MySQL Workbench
-- Thu Jul  6 11:02:36 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `dbgirl` ;

-- -----------------------------------------------------
-- Table `mydb`.`sales_volume`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbgirl`.`sales_volume` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `classcation` VARCHAR(45) NOT NULL COMMENT '类别：【总】、【vivo】、【oppo】',
  `date` VARCHAR(10) NOT NULL COMMENT 'yyyy-MM保存，展示需要显示成yyyy年MM月',
  `datatime` VARCHAR(45) NOT NULL COMMENT '生成该记录的日期 yyyy-MM-dd HH:mm:ss',
  `amount` INT NOT NULL DEFAULT 0 COMMENT '数量',
  `regioname` VARCHAR(55) NOT NULL COMMENT '地区name',
  `modifydate` DATETIME NULL COMMENT '记录修改的日期',
  PRIMARY KEY (`id`),
  INDEX `classcation` (`classcation` ASC),
  INDEX `date` (`date` ASC),
  INDEX `regioname` (`regioname` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
