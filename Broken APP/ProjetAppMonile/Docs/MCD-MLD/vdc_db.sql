-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema VDC_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema VDC_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VDC_DB` DEFAULT CHARACTER SET utf8 ;
USE `VDC_DB` ;

-- -----------------------------------------------------
-- Table `VDC_DB`.`Pleins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Pleins` (
  `idPleins` INT NOT NULL,
  `Prix` INT NOT NULL,
  `No` VARCHAR(45) NOT NULL,
  `Date` DATE NULL,
  `Adresse` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPleins`),
  UNIQUE INDEX `Date_UNIQUE` (`Date` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Voitures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Voitures` (
  `idVoitures` INT NOT NULL,
  `Marque` VARCHAR(45) NOT NULL,
  `Modele` VARCHAR(45) NOT NULL,
  `Chassis` VARCHAR(45) NOT NULL,
  `Carburant` VARCHAR(45) NOT NULL,
  `Puissance` INT NOT NULL,
  `Poids` INT NOT NULL,
  `Anee` DATE NOT NULL,
  `Pleins_idPleins` INT NULL,
  PRIMARY KEY (`idVoitures`),
  UNIQUE INDEX `Chassis_UNIQUE` (`Chassis` ASC) VISIBLE,
  INDEX `fk_Voitures_Pleins1_idx` (`Pleins_idPleins` ASC) VISIBLE,
  CONSTRAINT `fk_Voitures_Pleins1`
    FOREIGN KEY (`Pleins_idPleins`)
    REFERENCES `VDC_DB`.`Pleins` (`idPleins`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Contrat_Assurance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Contrat_Assurance` (
  `idContrat_Assurance` INT NOT NULL,
  `N_Contrat` VARCHAR(45) NOT NULL,
  `Nom` VARCHAR(45) NOT NULL,
  `Date` DATE NOT NULL,
  `Conseiller` VARCHAR(45) NOT NULL,
  `Contrat_Assurancecol` VARCHAR(45) NOT NULL,
  `Voitures_idVoitures` INT NOT NULL,
  PRIMARY KEY (`idContrat_Assurance`),
  UNIQUE INDEX `Contrat_Assurancecol_UNIQUE` (`Contrat_Assurancecol` ASC) VISIBLE,
  INDEX `fk_Contrat_Assurance_Voitures1_idx` (`Voitures_idVoitures` ASC) VISIBLE,
  CONSTRAINT `fk_Contrat_Assurance_Voitures1`
    FOREIGN KEY (`Voitures_idVoitures`)
    REFERENCES `VDC_DB`.`Voitures` (`idVoitures`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Garages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Garages` (
  `idGarages` INT NOT NULL,
  `Nom` VARCHAR(45) NOT NULL,
  `Adresse` VARCHAR(45) NOT NULL,
  `N_Telephone` INT NOT NULL,
  `N_Affilie` INT NOT NULL,
  `Propriaitaire` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGarages`),
  UNIQUE INDEX `Nom_UNIQUE` (`Nom` ASC) VISIBLE,
  UNIQUE INDEX `Adresse_UNIQUE` (`Adresse` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Taxer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Taxer` (
  `idTaxer` INT NOT NULL,
  `N_Facture` INT NOT NULL,
  `Date` DATE NOT NULL,
  `Prix` INT NOT NULL,
  `Voitures_idVoitures` INT NULL,
  PRIMARY KEY (`idTaxer`),
  UNIQUE INDEX `N_Facture_UNIQUE` (`N_Facture` ASC) VISIBLE,
  INDEX `fk_Taxer_Voitures1_idx` (`Voitures_idVoitures` ASC) VISIBLE,
  CONSTRAINT `fk_Taxer_Voitures1`
    FOREIGN KEY (`Voitures_idVoitures`)
    REFERENCES `VDC_DB`.`Voitures` (`idVoitures`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Plaques`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Plaques` (
  `idPlaques` INT NOT NULL,
  `Numero` VARCHAR(45) NOT NULL,
  `Taxer_idTaxer` INT NOT NULL,
  PRIMARY KEY (`idPlaques`),
  UNIQUE INDEX `Numero_UNIQUE` (`Numero` ASC) VISIBLE,
  INDEX `fk_Plaques_Taxer_idx` (`Taxer_idTaxer` ASC) VISIBLE,
  CONSTRAINT `fk_Plaques_Taxer`
    FOREIGN KEY (`Taxer_idTaxer`)
    REFERENCES `VDC_DB`.`Taxer` (`idTaxer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Payer_Primes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Payer_Primes` (
  `idPayer_Primes` INT NOT NULL,
  `N_Facture` INT NOT NULL,
  `Date` DATE NOT NULL,
  `Prix` INT NOT NULL,
  `Contrat_Assurance_idContrat_Assurance` INT NOT NULL,
  PRIMARY KEY (`idPayer_Primes`),
  UNIQUE INDEX `N_Facture_UNIQUE` (`N_Facture` ASC) VISIBLE,
  INDEX `fk_Payer_Primes_Contrat_Assurance1_idx` (`Contrat_Assurance_idContrat_Assurance` ASC) VISIBLE,
  CONSTRAINT `fk_Payer_Primes_Contrat_Assurance1`
    FOREIGN KEY (`Contrat_Assurance_idContrat_Assurance`)
    REFERENCES `VDC_DB`.`Contrat_Assurance` (`idContrat_Assurance`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Assures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Assures` (
  `idAssures` INT NOT NULL,
  `Bonus` INT NOT NULL,
  `Nationalite` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  `Annee_Permis` INT NOT NULL,
  `N_Accidents` VARCHAR(45) NOT NULL,
  `N_Permis` VARCHAR(45) NOT NULL,
  `Payer_Primes_idPayer_Primes` INT NOT NULL,
  PRIMARY KEY (`idAssures`),
  UNIQUE INDEX `N_Permis_UNIQUE` (`N_Permis` ASC) VISIBLE,
  INDEX `fk_Assures_Payer_Primes1_idx` (`Payer_Primes_idPayer_Primes` ASC) VISIBLE,
  CONSTRAINT `fk_Assures_Payer_Primes1`
    FOREIGN KEY (`Payer_Primes_idPayer_Primes`)
    REFERENCES `VDC_DB`.`Payer_Primes` (`idPayer_Primes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VDC_DB`.`Reparer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VDC_DB`.`Reparer` (
  `idReparer` INT NOT NULL,
  `N_Facture` INT NOT NULL,
  `Date` DATE NOT NULL,
  `Prix` INT NOT NULL,
  `Garages_idGarages` INT NULL,
  `Voitures_idVoitures` INT NULL,
  PRIMARY KEY (`idReparer`),
  UNIQUE INDEX `N_Facture_UNIQUE` (`N_Facture` ASC) VISIBLE,
  INDEX `fk_Reparer_Garages1_idx` (`Garages_idGarages` ASC) VISIBLE,
  INDEX `fk_Reparer_Voitures1_idx` (`Voitures_idVoitures` ASC) VISIBLE,
  CONSTRAINT `fk_Reparer_Garages1`
    FOREIGN KEY (`Garages_idGarages`)
    REFERENCES `VDC_DB`.`Garages` (`idGarages`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reparer_Voitures1`
    FOREIGN KEY (`Voitures_idVoitures`)
    REFERENCES `VDC_DB`.`Voitures` (`idVoitures`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
