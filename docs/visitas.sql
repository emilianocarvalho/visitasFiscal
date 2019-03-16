CREATE DATABASE IF NOT EXISTS `visitas` DEFAULT CHARACTER SET utf8;
USE `visitas`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `visitas`.`fiscal`;
CREATE TABLE IF NOT EXISTS `visitas`.`fiscal` (
  `matricula` INT(11) NOT NULL,
  `nome` VARCHAR(25) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;

DROP TABLE IF EXISTS `visitas`.`estabelecimento`;

CREATE TABLE IF NOT EXISTS `visitas`.`estabelecimento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cidade` INT(11) NULL DEFAULT NULL,
  `cep` VARCHAR(25) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `razao` VARCHAR(25) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `cnpj` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_id_cidade` FOREIGN KEY (`id_cidade`) REFERENCES `visitas`.`cidade` (`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;



DROP TABLE IF EXISTS `visitas`.`cidade`;

CREATE TABLE IF NOT EXISTS `visitas`.`cidade` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(25) CHARACTER SET 'utf8' NOT NULL,
  `uf` VARCHAR(25) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;

DROP TABLE IF EXISTS `visitas`.`fiscal`;

CREATE TABLE IF NOT EXISTS `visitas`.`fiscal` (
  `matricula` INT(11) NOT NULL,
  `nome` VARCHAR(25) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;


DROP TABLE IF EXISTS `visitas`.`auto`;

CREATE TABLE IF NOT EXISTS `visitas`.`auto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_auto` INT(11) NOT NULL,
  `data` TIMESTAMP NULL DEFAULT NULL,
  `id_estabelecimento` INT(11) NOT NULL,
  `cnpj` INT(11) NOT NULL,
  `recusa_receber` VARCHAR(3) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `id_fiscal` INT(11) NOT NULL,
  `equipe` VARCHAR(30) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `id_tipoauto` INT(11) NULL,
  `irregularidade` VARCHAR(30) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `obs` VARCHAR(100) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_id_estabelecimento` FOREIGN KEY (`id_estabelecimento`) REFERENCES `visitas`.`estabelecimento` (`id`),
  CONSTRAINT `fk_id_fiscal` FOREIGN KEY (`id_fiscal`) REFERENCES `visitas`.`fiscal` (`matricula`),
  CONSTRAINT `fk_id_tipoauto` FOREIGN KEY (`id_tipoauto`) REFERENCES `visitas`.`tipoauto` (`id`)
  
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;

CREATE INDEX `fk_id_estabelecimento` ON `visitas`.`auto` (`id_estabelecimento` ASC);
CREATE INDEX `fk_id_fiscal` ON `visitas`.`auto` (`id_fiscal` ASC);
CREATE INDEX `fk_id_tipoauto` ON `visitas`.`auto` (`id_tipoauto` ASC);

DROP TABLE IF EXISTS `visitas`.`tipoauto`;

CREATE TABLE IF NOT EXISTS `visitas`.`tipoauto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_de_auto` VARCHAR(30) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_unicode_ci;

CREATE INDEX `id` ON `visitas`.`tipoauto` (`id` ASC);

SET FOREIGN_KEY_CHECKS = 1;
