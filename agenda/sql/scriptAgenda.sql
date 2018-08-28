CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Calle` varchar(20) NOT NULL,
  `Altura` varchar(20) NOT NULL,
  `Piso` varchar(20) NOT NULL,
  `Localidad` varchar(20) NOT NULL,
  `Mail` varchar(20) NOT NULL,
  `TipoContacto` varchar(20) NOT NULL,
  PRIMARY KEY (`idPersona`)
);
USE agenda;
CREATE TABLE `localidades`
(
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `CodigoPostal` varchar(20) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
);