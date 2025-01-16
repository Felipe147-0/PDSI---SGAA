-- MySQL Script generated by MySQL Workbench
-- Fri Jan 10 16:41:37 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SGAA-AQ3016439
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SGAA-AQ3016439
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SGAA-AQ3016439` DEFAULT CHARACTER SET utf8 ;
USE `SGAA-AQ3016439` ;

-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`animais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`animais` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `especie` VARCHAR(100) NOT NULL,
  `raca` VARCHAR(100) NULL,
  `idade` VARCHAR(10) NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `saude` VARCHAR(500) NOT NULL,
  `data_entrada` DATE NOT NULL,
  `disponivel_adocao` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`usuarios` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `login` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `tipo_usuario` ENUM('administrador', 'funcionario') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`adotantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`adotantes` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `endereco` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`adocoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`adocoes` (
  `id` INT NOT NULL,
  `data_adocao` DATE NOT NULL,
  `animais_id` INT NOT NULL,
  `adotantes_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_adocoes_animais_idx` (`animais_id` ASC) VISIBLE,
  INDEX `fk_adocoes_adotantes1_idx` (`adotantes_id` ASC) VISIBLE,
  CONSTRAINT `fk_adocoes_animais`
    FOREIGN KEY (`animais_id`)
    REFERENCES `SGAA-AQ3016439`.`animais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_adocoes_adotantes1`
    FOREIGN KEY (`adotantes_id`)
    REFERENCES `SGAA-AQ3016439`.`adotantes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`doadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`doadores` (
  `id` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGAA-AQ3016439`.`doacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SGAA-AQ3016439`.`doacoes` (
  `id` INT NOT NULL,
  `tipo_doacao` VARCHAR(150) NOT NULL,
  `descricao` VARCHAR(500) NULL,
  `valor` VARCHAR(45) NOT NULL,
  `data_doacao` DATE NULL,
  `doadores_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_doacoes_doadores1_idx` (`doadores_id` ASC) VISIBLE,
  CONSTRAINT `fk_doacoes_doadores1`
    FOREIGN KEY (`doadores_id`)
    REFERENCES `SGAA-AQ3016439`.`doadores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
