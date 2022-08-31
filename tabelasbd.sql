-- MySQL Script generated by MySQL Workbench
-- Wed Aug 31 18:45:23 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `idfuncionario` INT NULL AUTO_INCREMENT,
  `nomefuncionario` VARCHAR(45) NULL,
  `funcao` VARCHAR(45) NULL,
  `cpf` CHAR(14) NOT NULL,
  `salario` FLOAT NULL,
  PRIMARY KEY (`idfuncionario`),
  UNIQUE INDEX `idfuncionario_UNIQUE` (`idfuncionario` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nomeusuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `idusuario_UNIQUE` (`idusuario` ASC) VISIBLE,
  INDEX `fk_usuario_funcionario_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_funcionario`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`endereco` ;

CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `idendereco` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`idendereco`),
  UNIQUE INDEX `idendereco_UNIQUE` (`idendereco` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idcliente` INT UNSIGNED NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco_idendereco` INT NOT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `fk_cliente_endereco1_idx` (`endereco_idendereco` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`endereco_idendereco`)
    REFERENCES `mydb`.`endereco` (`idendereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`telefone` ;

CREATE TABLE IF NOT EXISTS `mydb`.`telefone` (
  `idtelefone` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `numero` VARCHAR(30) NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  `cliente_idcliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idtelefone`),
  INDEX `fk_telefone_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  INDEX `fk_telefone_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mydb`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`livro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`livro` ;

CREATE TABLE IF NOT EXISTS `mydb`.`livro` (
  `idlivro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `preco` FLOAT NULL,
  `editora` VARCHAR(45) NULL,
  `idioma` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `ano` INT NULL,
  `numeroPaginas` INT NULL,
  PRIMARY KEY (`idlivro`),
  UNIQUE INDEX `idlivro_UNIQUE` (`idlivro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`venda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `cliente_idcliente` INT UNSIGNED NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `mydb`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`livroVendido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`livroVendido` ;

CREATE TABLE IF NOT EXISTS `mydb`.`livroVendido` (
  `idlivroVendido` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NULL,
  `precoAtual` FLOAT NULL,
  `livro_idlivro` INT NOT NULL,
  `venda_idvenda` INT NOT NULL,
  PRIMARY KEY (`idlivroVendido`),
  UNIQUE INDEX `idlivroVendido_UNIQUE` (`idlivroVendido` ASC) VISIBLE,
  INDEX `fk_livroVendido_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_livroVendido_venda1_idx` (`venda_idvenda` ASC) VISIBLE,
  CONSTRAINT `fk_livroVendido_livro1`
    FOREIGN KEY (`livro_idlivro`)
    REFERENCES `mydb`.`livro` (`idlivro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_livroVendido_venda1`
    FOREIGN KEY (`venda_idvenda`)
    REFERENCES `mydb`.`venda` (`idvenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`historicoPrecos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`historicoPrecos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`historicoPrecos` (
  `idhistoricoPrecos` INT NOT NULL AUTO_INCREMENT,
  `dataAlteracao` VARCHAR(45) NULL,
  `precoAlterado` FLOAT NULL,
  `precoAnterior` FLOAT NULL,
  `livro_idlivro` INT NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idhistoricoPrecos`),
  UNIQUE INDEX `idhistoricoPrecos_UNIQUE` (`idhistoricoPrecos` ASC) VISIBLE,
  INDEX `fk_historicoPrecos_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_historicoPrecos_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_historicoPrecos_livro1`
    FOREIGN KEY (`livro_idlivro`)
    REFERENCES `mydb`.`livro` (`idlivro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historicoPrecos_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor` (
  `idfornecedor` INT NOT NULL AUTO_INCREMENT,
  `nomeFornecedor` VARCHAR(45) NULL,
  `endereco_idendereco` INT NOT NULL,
  PRIMARY KEY (`idfornecedor`),
  UNIQUE INDEX `idfornecedor_UNIQUE` (`idfornecedor` ASC) VISIBLE,
  INDEX `fk_fornecedor_endereco1_idx` (`endereco_idendereco` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_endereco1`
    FOREIGN KEY (`endereco_idendereco`)
    REFERENCES `mydb`.`endereco` (`idendereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`compra` ;

CREATE TABLE IF NOT EXISTS `mydb`.`compra` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idcompra`),
  UNIQUE INDEX `idcompra_UNIQUE` (`idcompra` ASC) VISIBLE,
  INDEX `fk_compra_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  CONSTRAINT `fk_compra_funcionario1`
    FOREIGN KEY (`funcionario_idfuncionario`)
    REFERENCES `mydb`.`funcionario` (`idfuncionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`autor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`autor` (
  `idautor` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idautor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor_has_compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`fornecedor_has_compra` ;

CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor_has_compra` (
  `fornecedor_idfornecedor` INT NOT NULL,
  `compra_idcompra` INT NOT NULL,
  PRIMARY KEY (`fornecedor_idfornecedor`, `compra_idcompra`),
  INDEX `fk_fornecedor_has_compra_compra1_idx` (`compra_idcompra` ASC) VISIBLE,
  INDEX `fk_fornecedor_has_compra_fornecedor1_idx` (`fornecedor_idfornecedor` ASC) VISIBLE,
  CONSTRAINT `fk_fornecedor_has_compra_fornecedor1`
    FOREIGN KEY (`fornecedor_idfornecedor`)
    REFERENCES `mydb`.`fornecedor` (`idfornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fornecedor_has_compra_compra1`
    FOREIGN KEY (`compra_idcompra`)
    REFERENCES `mydb`.`compra` (`idcompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`autor_has_livro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`autor_has_livro` ;

CREATE TABLE IF NOT EXISTS `mydb`.`autor_has_livro` (
  `autor_idautor` INT UNSIGNED NOT NULL,
  `livro_idlivro` INT NOT NULL,
  PRIMARY KEY (`autor_idautor`, `livro_idlivro`),
  INDEX `fk_autor_has_livro_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_autor_has_livro_autor1_idx` (`autor_idautor` ASC) VISIBLE,
  CONSTRAINT `fk_autor_has_livro_autor1`
    FOREIGN KEY (`autor_idautor`)
    REFERENCES `mydb`.`autor` (`idautor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor_has_livro_livro1`
    FOREIGN KEY (`livro_idlivro`)
    REFERENCES `mydb`.`livro` (`idlivro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
