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
<<<<<<< HEAD
  `idfuncionario` INT NULL AUTO_INCREMENT,
=======
  `idfuncionario` INT NOT NULL AUTO_INCREMENT,
>>>>>>> joao
  `nomefuncionario` VARCHAR(45) NULL,
  `funcao` VARCHAR(45) NULL,
  `cpf` CHAR(14) NOT NULL,
  `salario` FLOAT NULL,
  PRIMARY KEY (`idfuncionario`),
<<<<<<< HEAD
  UNIQUE INDEX `idfuncionario_UNIQUE` (`idfuncionario` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
=======
  UNIQUE INDEX `idfuncionario_UNIQUE` (`idfuncionario` ASC) ,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) )
>>>>>>> joao
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nomeusuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NOT NULL,
<<<<<<< HEAD
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `idusuario_UNIQUE` (`idusuario` ASC) VISIBLE,
  INDEX `fk_usuario_funcionario_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
=======
  `tipoFuncionario` CHAR(1) NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `idusuario_UNIQUE` (`idusuario` ASC) ,
  INDEX `fk_usuario_funcionario_idx` (`funcionario_idfuncionario` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  UNIQUE INDEX `idendereco_UNIQUE` (`idendereco` ASC) VISIBLE)
=======
  UNIQUE INDEX `idendereco_UNIQUE` (`idendereco` ASC) )
>>>>>>> joao
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
<<<<<<< HEAD
  `idcliente` INT UNSIGNED NULL AUTO_INCREMENT,
=======
  `idcliente` INT NOT NULL AUTO_INCREMENT,
>>>>>>> joao
  `nomeCliente` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco_idendereco` INT NOT NULL,
  PRIMARY KEY (`idcliente`),
<<<<<<< HEAD
  INDEX `fk_cliente_endereco1_idx` (`endereco_idendereco` ASC) VISIBLE,
=======
  INDEX `fk_cliente_endereco1_idx` (`endereco_idendereco` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  `cliente_idcliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idtelefone`),
  INDEX `fk_telefone_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
  INDEX `fk_telefone_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
=======
  `cliente_idcliente` INT NOT NULL,
  PRIMARY KEY (`idtelefone`),
  INDEX `fk_telefone_funcionario1_idx` (`funcionario_idfuncionario` ASC) ,
  INDEX `fk_telefone_cliente1_idx` (`cliente_idcliente` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  `titulo` VARCHAR(45) NULL,
  `preco` FLOAT NULL,
  `editora` VARCHAR(45) NULL,
  `idioma` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `ano` INT NULL,
  `numeroPaginas` INT NULL,
  PRIMARY KEY (`idlivro`),
  UNIQUE INDEX `idlivro_UNIQUE` (`idlivro` ASC) VISIBLE)
=======
  `titulo` VARCHAR(100) NULL,
  `preco` FLOAT NULL,
  `editora` VARCHAR(100) NULL,
  `idioma` VARCHAR(100) NULL,
  `genero` VARCHAR(100) NULL,
  `ano` INT NULL,
  `numeroPaginas` INT NULL,
  PRIMARY KEY (`idlivro`),
  UNIQUE INDEX `idlivro_UNIQUE` (`idlivro` ASC) )
>>>>>>> joao
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`venda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
<<<<<<< HEAD
  `cliente_idcliente` INT UNSIGNED NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_venda_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
=======
  `cliente_idcliente` INT NOT NULL,
  `funcionario_idfuncionario` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_cliente1_idx` (`cliente_idcliente` ASC) ,
  INDEX `fk_venda_funcionario1_idx` (`funcionario_idfuncionario` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  UNIQUE INDEX `idlivroVendido_UNIQUE` (`idlivroVendido` ASC) VISIBLE,
  INDEX `fk_livroVendido_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_livroVendido_venda1_idx` (`venda_idvenda` ASC) VISIBLE,
=======
  UNIQUE INDEX `idlivroVendido_UNIQUE` (`idlivroVendido` ASC) ,
  INDEX `fk_livroVendido_livro1_idx` (`livro_idlivro` ASC) ,
  INDEX `fk_livroVendido_venda1_idx` (`venda_idvenda` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  UNIQUE INDEX `idhistoricoPrecos_UNIQUE` (`idhistoricoPrecos` ASC) VISIBLE,
  INDEX `fk_historicoPrecos_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_historicoPrecos_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
=======
  UNIQUE INDEX `idhistoricoPrecos_UNIQUE` (`idhistoricoPrecos` ASC) ,
  INDEX `fk_historicoPrecos_livro1_idx` (`livro_idlivro` ASC) ,
  INDEX `fk_historicoPrecos_funcionario1_idx` (`funcionario_idfuncionario` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  UNIQUE INDEX `idfornecedor_UNIQUE` (`idfornecedor` ASC) VISIBLE,
  INDEX `fk_fornecedor_endereco1_idx` (`endereco_idendereco` ASC) VISIBLE,
=======
  UNIQUE INDEX `idfornecedor_UNIQUE` (`idfornecedor` ASC) ,
  INDEX `fk_fornecedor_endereco1_idx` (`endereco_idendereco` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  UNIQUE INDEX `idcompra_UNIQUE` (`idcompra` ASC) VISIBLE,
  INDEX `fk_compra_funcionario1_idx` (`funcionario_idfuncionario` ASC) VISIBLE,
=======
  UNIQUE INDEX `idcompra_UNIQUE` (`idcompra` ASC) ,
  INDEX `fk_compra_funcionario1_idx` (`funcionario_idfuncionario` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  INDEX `fk_fornecedor_has_compra_compra1_idx` (`compra_idcompra` ASC) VISIBLE,
  INDEX `fk_fornecedor_has_compra_fornecedor1_idx` (`fornecedor_idfornecedor` ASC) VISIBLE,
=======
  INDEX `fk_fornecedor_has_compra_compra1_idx` (`compra_idcompra` ASC) ,
  INDEX `fk_fornecedor_has_compra_fornecedor1_idx` (`fornecedor_idfornecedor` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
  INDEX `fk_autor_has_livro_livro1_idx` (`livro_idlivro` ASC) VISIBLE,
  INDEX `fk_autor_has_livro_autor1_idx` (`autor_idautor` ASC) VISIBLE,
=======
  INDEX `fk_autor_has_livro_livro1_idx` (`livro_idlivro` ASC) ,
  INDEX `fk_autor_has_livro_autor1_idx` (`autor_idautor` ASC) ,
>>>>>>> joao
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
<<<<<<< HEAD
=======

insert into autor (idautor, nome) values (1, 'Nealy Ledley');
insert into autor (idautor, nome) values (2, 'Wendeline Annott');
insert into autor (idautor, nome) values (3, 'Garwin Curr');
insert into autor (idautor, nome) values (4, 'Roarke Purches');
insert into autor (idautor, nome) values (5, 'Sibelle Gytesham');


insert into endereco (idendereco, rua, bairro, cidade, estado) values (1, '497 Hoffman Plaza', 'Guatemalan', 'Huntsville', 'Alabama');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (2, '4051 Grayhawk Drive', 'Creek', 'Amarillo', 'Texas');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (3, '77018 Mcguire Trail', 'Eskimo', 'Hayward', 'California');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (4, '36 Grayhawk Terrace', 'Paiute', 'Bronx', 'New York');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (5, '87 Havey Circle', 'Micronesian', 'Glendale', 'Arizona');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (6, '51 Mcguire Crossing', 'Guamanian', 'Phoenix', 'Arizona');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (7, '23 Corben Trail', 'Honduran', 'Fort Pierce', 'Florida');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (8, '91 Gina Drive', 'Paraguayan', 'Texarkana', 'Texas');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (9, '9 Derek Circle', 'Alaskan Athabascan', 'Saint Petersburg', 'Florida');
insert into endereco (idendereco, rua, bairro, cidade, estado) values (10, '1304 Morningstar Alley', 'Asian Indian', 'Round Rock', 'Texas');


insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (1, 'Ruttger Merrell', '359.160.607-84', 1);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (2, 'Cinda O'' Bee', '348.309.438-20', 2);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (3, 'Tate Laurentin', '774.923.462-96', 3);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (4, 'Son Kubatsch', '783.043.777-64', 4);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (5, 'Gil Barnhill', '275.930.614-12', 5);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (6, 'Elwira Fishby', '177.517.927-82', 6);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (7, 'Kingsly Grainger', '346.527.179-54', 7);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (8, 'Linea Estoile', '327.217.811-79', 8);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (9, 'Michel Traice', '834.996.099-02', 9);
insert into cliente (idcliente, nomeCliente, cpf, endereco_idendereco) values (10, 'Beatrisa Kyle', '097.049.446-75', 10);

insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (1, 'Skinder', 1);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (2, 'Bubblemix', 2);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (3, 'Quamba', 3);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (4, 'Roodel', 4);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (5, 'Flipopia', 5);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (6, 'Brightbean', 6);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (7, 'Fatz', 7);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (8, 'Livepath', 8);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (9, 'Youopia', 9);
insert into fornecedor (idfornecedor, nomeFornecedor, endereco_idendereco) values (10, 'Agivu', 10);

insert into funcionario (idfuncionario, nomefuncionario, funcao, cpf, salario) values (1, 'Norton Rysdale', 'Vendedor', '415.769.890-89', '4810.46');
insert into funcionario (idfuncionario, nomefuncionario, funcao, cpf, salario) values (2, 'Rickard Locker', 'Vendedor', '643.421.040-08', '3068.26');
insert into funcionario (idfuncionario, nomefuncionario, funcao, cpf, salario) values (3, 'Godiva Cursons', 'Supervisor', '984.927.440-90', '4988.99');
insert into funcionario (idfuncionario, nomefuncionario, funcao, cpf, salario) values (4, 'Ebony Pannett', 'Vendedor', '354.535.930-16', '4437.39');

insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (1, 11, 1);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (2, 22, 2);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (3, 30, 3);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (4, 83, 4);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (5, 37, 1);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (6, 40, 2);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (7, 77, 3);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (8, 40, 4);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (9, 16, 1);
insert into compra (idcompra, quantidade, funcionario_idfuncionario) values (10, 12, 2);


insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (3, 1);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (1, 2);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (4, 3);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (2, 4);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (2, 5);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (3, 6);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (1, 7);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (4, 8);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (1, 9);
insert into fornecedor_has_compra (fornecedor_idfornecedor, compra_idcompra) values (2, 10);

insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (1, 'Brain Dead', '104.36', 'Oyondu', 'Hungarian', 'Horror|Sci-Fi', 1995, 990);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (2, 'In a Town This Size', '213.40', 'Rooxo', 'Polish', 'Documentary', 2007, 601);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (3, 'Three Faces East', '37.38', 'Tagcat', 'Kurdish', 'Drama|Mystery|War', 1999, 788);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (4, 'Mystery of the Wax Museum', '190.22', 'Twitterbeat', 'Gujarati', 'Horror', 2012, 184);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (5, 'Slipping-Down Life, A', '36.24', 'Babblestorm', 'German', 'Drama|Romance', 1998, 607);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (6, 'Soldier''s Daughter Never Cries, A', '144.36', 'Quinu', 'Romanian', 'Drama', 2006, 864);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (7, 'Chris Rock: Bring the Pain', '222.64', 'Youbridge', 'Icelandic', 'Comedy', 1994, 924);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (8, 'Murders in the Zoo', '49.92', 'Izio', 'Yiddish', 'Crime|Horror|Mystery', 2010, 415);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (9, 'Cuenca Crime, The (Crimen de Cuenca, El)', '136.68', 'Wordpedia', 'Lithuanian', 'Drama', 2010, 285);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (10, 'Learning Curve, The', '133.88', 'Oloo', 'Marathi', 'Crime|Drama|Thriller', 1993, 414);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (11, 'River, The', '117.13', 'Eazzy', 'Malayalam', 'Drama', 1995, 935);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (12, 'Illusion Of Blood', '174.47', 'Meedoo', 'Haitian Creole', 'Fantasy|Horror', 1995, 903);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (13, 'Leprechaun: Origins', '65.54', 'Vipe', 'Northern Sotho', 'Horror', 2012, 412);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (14, 'Bullfighters, The', '223.25', 'Zoomdog', 'Catalan', 'Comedy|Musical', 1987, 329);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (15, 'Dark Star', '206.21', 'Wikivu', 'Montenegrin', 'Comedy|Sci-Fi|Thriller', 1955, 854);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (16, 'Devil and Daniel Webster, The (All That Money Can Buy)', '127.06', 'Skimia', 'Portuguese', 'Drama|Fantasy', 1996, 141);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (17, 'Fog of War: Eleven Lessons from the Life of Robert S. McNamara, The', '211.76', 'Gigaclub', 'Hungarian', 'Documentary|War', 2009, 855);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (18, 'Wrong Is Right (a.k.a. The Man With the Deadly Lens)', '131.03', 'Skynoodle', 'Lao', 'Drama|Thriller', 1996, 906);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (19, 'Target', '105.08', 'Tagopia', 'Azeri', 'Action|Drama|Thriller', 1994, 632);
insert into livro (idlivro, titulo, preco, editora, idioma, genero, ano, numeroPaginas) values (20, 'Stewart Lee: If You Prefer a Milder Comedian, Please Ask for One', '181.38', 'Jabbersphere', 'West Frisian', 'Comedy', 1997, 699);

insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (1, '7/6/2022', '286.43', '235.93', 5, 1);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (2, '4/15/2022', '156.30', '295.98', 17, 2);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (3, '1/6/2021', '49.70', '44.87', 18, 3);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (4, '8/8/2021', '189.46', '108.97', 1, 4);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (5, '2/27/2022', '85.96', '118.92', 7, 1);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (6, '4/25/2022', '296.51', '257.07', 18, 2);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (7, '12/7/2021', '50.20', '224.46', 13, 3);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (8, '6/2/2021', '88.90', '84.10', 9, 4);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (9, '9/12/2021', '231.29', '28.52', 1, 1);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (10, '6/6/2021', '245.83', '37.37', 5, 2);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (11, '3/18/2022', '283.59', '12.81', 17, 3);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (12, '7/26/2022', '191.31', '119.52', 3, 4);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (13, '8/14/2022', '278.43', '248.33', 8, 1);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (14, '3/27/2022', '15.21', '55.70', 6, 2);
insert into historicoPrecos (idhistoricoPrecos, dataAlteracao, precoAlterado, precoAnterior, livro_idlivro, funcionario_idfuncionario) values (15, '9/6/2021', '213.63', '105.96', 11, 3);



insert into autor_has_livro (autor_idautor, livro_idlivro) values (1, 1);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (2, 2);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (3, 3);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (4, 4);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (5, 5);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (1, 6);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (2, 7);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (3, 8);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (4, 9);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (5, 10);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (1, 11);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (2, 12);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (3, 13);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (4, 14);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (5, 15);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (1, 16);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (2, 17);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (3, 18);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (4, 19);
insert into autor_has_livro (autor_idautor, livro_idlivro) values (5, 20);

insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (1, 1, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (2, 2, 2);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (3, 3, 3);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (4, 4, 4);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (5, 5, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (6, 6, 2);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (7, 7, 3);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (8, 8, 4);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (9, 9, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (10, 10, 2);

insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (1, 23, '143.56', 16, 1);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (2, 47, '31.03', 5, 2);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (3, 99, '158.87', 5, 3);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (4, 66, '57.06', 18, 4);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (5, 3, '162.23', 3, 5);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (6, 24, '113.09', 2, 6);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (7, 89, '49.01', 19, 7);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (8, 100, '70.53', 6, 8);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (9, 8, '130.90', 9, 9);
insert into livroVendido (idlivroVendido, quantidade, precoAtual, livro_idlivro, venda_idvenda) values (10, 71, '222.20', 1, 10);

insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (1, 9, '(516) 5392934', '1', '5');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (2, 6, '(772) 6031088', '4', '1');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (3, 52, '(508) 5781186', '3', '2');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (4, 13, '(715) 3102658', '2', '3');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (5, 100, '(290) 4903956', '1', '3');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (6, 65, '(889) 9071693', '2', '8');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (7, 23, '(333) 2543702', '2', '2');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (8, 8, '(287) 1132231', '3', '7');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (9, 73, '(282) 4311052', '3', '6');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (10, 98, '(416) 9309140', '1', '4');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (11, 68, '(943) 5009045', '4', '1');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (12, 27, '(723) 7640182', '4', '4');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (13, 18, '(937) 5046169', '3', '9');
insert into telefone (idtelefone, tipo, numero, funcionario_idfuncionario, cliente_idcliente) values (14, 31, '(978) 3105768', '2', '10');

insert into usuario (idusuario, nomeusuario, senha, tipofuncionario, funcionario_idfuncionario) values (1, 'rloyley0', 'lymuuY', 'V', 1);
insert into usuario (idusuario, nomeusuario, senha, tipofuncionario, funcionario_idfuncionario) values (2, 'tspeares1', 'b7swVGx', 'V', 2);
insert into usuario (idusuario, nomeusuario, senha, tipofuncionario, funcionario_idfuncionario) values (3, 'igarshore2', '3lnQazZH4cSm', 'S', 3);
insert into usuario (idusuario, nomeusuario, senha, tipofuncionario, funcionario_idfuncionario) values (4, 'esilliman3', 'wE8bsw', 'V', 4);

<<<<<<< HEAD
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (1, 1, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (2, 2, 2);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (3, 3, 3);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (4, 4, 4);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (5, 5, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (6, 6, 2);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (7, 7, 3);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (8, 8, 4);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (9, 9, 1);
insert into venda (idvenda, cliente_idcliente, funcionario_idfuncionario) values (10, 10, 2);
>>>>>>> joao
=======

>>>>>>> joao
