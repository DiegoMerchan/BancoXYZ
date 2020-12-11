-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 192.168.0.4    Database: Banco
-- ------------------------------------------------------
-- Server version	5.6.50

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Ciudad`
--

DROP TABLE IF EXISTS `Ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Ciudad` varchar(45) DEFAULT NULL,
  `Pais_idPais` int(11) NOT NULL,
  PRIMARY KEY (`idCiudad`,`Pais_idPais`),
  KEY `fk_Ciudad_Pais1_idx` (`Pais_idPais`),
  CONSTRAINT `fk_Ciudad_Pais1` FOREIGN KEY (`Pais_idPais`) REFERENCES `Pais` (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ciudad`
--

LOCK TABLES `Ciudad` WRITE;
/*!40000 ALTER TABLE `Ciudad` DISABLE KEYS */;
INSERT INTO `Ciudad` VALUES (1,'Bogota',1),(2,'Cali',1),(3,'Chicago',2),(4,'Dallas',2);
/*!40000 ALTER TABLE `Ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Genero` varchar(1) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `Ciudad_idCiudad` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`Ciudad_idCiudad`),
  UNIQUE KEY `idCliente_UNIQUE` (`idCliente`),
  KEY `fk_Cliente_Ciudad1_idx` (`Ciudad_idCiudad`),
  CONSTRAINT `fk_Cliente_Ciudad1` FOREIGN KEY (`Ciudad_idCiudad`) REFERENCES `Ciudad` (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (80567123,'George','Rusell','1978-11-03','M','dddd','3456781',4),(1032475921,'Lewis','Hamilton','1985-03-13','M','Calle 33 #12-22','2344445',3),(1038583016,'Charles','Leclerc','1979-01-24','M','Transversal 3 #64-32','7654321',4),(1043187332,'Juan','Montoya','1981-05-06','M','Cra 2 #21-18','3456899',1),(1046282042,'Mariana','Pajon','1983-12-21','F','Cra 3 #97-43','8765432',2);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cuenta`
--

DROP TABLE IF EXISTS `Cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cuenta` (
  `Num` int(11) NOT NULL,
  `Saldo` double DEFAULT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  `contrasena` varchar(4) NOT NULL,
  PRIMARY KEY (`Num`,`Cliente_idCliente`),
  KEY `fk_Cuenta_Cliente_idx` (`Cliente_idCliente`),
  CONSTRAINT `fk_Cuenta_Cliente` FOREIGN KEY (`Cliente_idCliente`) REFERENCES `Cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cuenta`
--

LOCK TABLES `Cuenta` WRITE;
/*!40000 ALTER TABLE `Cuenta` DISABLE KEYS */;
INSERT INTO `Cuenta` VALUES (364986722,7339292,1032475921,'1234'),(378903236,23455,80567123,'1234'),(434676711,5678943,1038583016,'1234'),(657335987,2345672,1046282042,'1234'),(876356865,234678,1043187332,'1234');
/*!40000 ALTER TABLE `Cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movimiento`
--

DROP TABLE IF EXISTS `Movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movimiento` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_movimiento` date DEFAULT NULL,
  `Concepto` varchar(45) DEFAULT NULL,
  `Valor` double DEFAULT NULL,
  `Tipo_movimiento_idTipo` int(11) NOT NULL,
  `Cuenta_Num` int(11) NOT NULL,
  `Cuenta_Cliente_idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idMovimiento`,`Tipo_movimiento_idTipo`,`Cuenta_Num`,`Cuenta_Cliente_idCliente`),
  KEY `fk_Movimiento_Tipo_movimiento1_idx` (`Tipo_movimiento_idTipo`),
  KEY `fk_Movimiento_Cuenta1_idx` (`Cuenta_Num`,`Cuenta_Cliente_idCliente`),
  CONSTRAINT `fk_Movimiento_Cuenta1` FOREIGN KEY (`Cuenta_Num`, `Cuenta_Cliente_idCliente`) REFERENCES `Cuenta` (`Num`, `Cliente_idCliente`),
  CONSTRAINT `fk_Movimiento_Tipo_movimiento1` FOREIGN KEY (`Tipo_movimiento_idTipo`) REFERENCES `Tipo_movimiento` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movimiento`
--

LOCK TABLES `Movimiento` WRITE;
/*!40000 ALTER TABLE `Movimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pais`
--

DROP TABLE IF EXISTS `Pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pais`
--

LOCK TABLES `Pais` WRITE;
/*!40000 ALTER TABLE `Pais` DISABLE KEYS */;
INSERT INTO `Pais` VALUES (1,'Colombia'),(2,'Estados Unidos');
/*!40000 ALTER TABLE `Pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tipo_movimiento`
--

DROP TABLE IF EXISTS `Tipo_movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tipo_movimiento` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tipo_movimiento`
--

LOCK TABLES `Tipo_movimiento` WRITE;
/*!40000 ALTER TABLE `Tipo_movimiento` DISABLE KEYS */;
INSERT INTO `Tipo_movimiento` VALUES (1,'Consignacion'),(2,'Retiro');
/*!40000 ALTER TABLE `Tipo_movimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-10 23:00:17
