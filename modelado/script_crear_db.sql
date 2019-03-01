CREATE DATABASE  IF NOT EXISTS `torneo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `torneo`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: torneo
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aspirantes`
--

DROP TABLE IF EXISTS `aspirantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspirantes` (
  `id_aspirante` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  `c_apellido` varchar(255) DEFAULT NULL,
  `c_direccion` varchar(255) DEFAULT NULL,
  `f_nacimiento` datetime DEFAULT NULL,
  `n_dni` int(11) DEFAULT NULL,
  `id_escuela` bigint(20) NOT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_aspirante`),
  KEY `FK_htfcp39i3a0a2vel98pp25qad` (`id_escuela`),
  CONSTRAINT `FK_htfcp39i3a0a2vel98pp25qad` FOREIGN KEY (`id_escuela`) REFERENCES `escuelas` (`id_escuela`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cambios_estado`
--

DROP TABLE IF EXISTS `cambios_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cambios_estado` (
  `id_cambio_estado` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_cambio` datetime DEFAULT NULL,
  `id_inscripcion` bigint(20) NOT NULL,
  `id_estado_inscripcion` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cambio_estado`),
  KEY `FK_ah6uloi97omrsbq3biojb5bg6` (`id_inscripcion`),
  KEY `FK_s6pgur5pae2nkwk321hpkftc4` (`id_estado_inscripcion`),
  CONSTRAINT `FK_ah6uloi97omrsbq3biojb5bg6` FOREIGN KEY (`id_inscripcion`) REFERENCES `inscripciones` (`id_inscripcion`),
  CONSTRAINT `FK_s6pgur5pae2nkwk321hpkftc4` FOREIGN KEY (`id_estado_inscripcion`) REFERENCES `estados_inscripcion` (`id_estado_inscripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  `n_edad_desde` int(11) DEFAULT NULL,
  `n_edad_hasta` int(11) DEFAULT NULL,
  `c_sexo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Menores Mujeres',13,18,'Femenino'),(2,'Menores Varones',13,18,'Masculino'),(3,'Infantiles Mujeres',8,12,'Femenino'),(4,'Infantiles Varones',8,12,'Masculino');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competencias`
--

DROP TABLE IF EXISTS `competencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competencias` (
  `id_competencia` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  `id_torneo` bigint(20) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_competencia`),
  KEY `FK_8c7ynwkhyjhfo5hbtjdbplayt` (`id_torneo`),
  CONSTRAINT `FK_8c7ynwkhyjhfo5hbtjdbplayt` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id_torneo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competencias`
--

LOCK TABLES `competencias` WRITE;
/*!40000 ALTER TABLE `competencias` DISABLE KEYS */;
INSERT INTO `competencias` VALUES (1,'Salto en largo',NULL,NULL),(2,'50 metros con valla',NULL,NULL),(3,'500 metros con posta',NULL,NULL),(4,'300 metros con posta',NULL,NULL),(5,'100 metros llanos',NULL,NULL),(6,'100 metros llanos',1,0),(7,'300 metros con posta',1,1),(8,'500 metros con posta',1,2),(9,'50 metros con valla',1,3),(10,'Salto en largo',1,4);
/*!40000 ALTER TABLE `competencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escuelas`
--

DROP TABLE IF EXISTS `escuelas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escuelas` (
  `id_escuela` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  `c_telefono` varchar(255) DEFAULT NULL,
  `c_direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_escuela`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escuelas`
--

LOCK TABLES `escuelas` WRITE;
/*!40000 ALTER TABLE `escuelas` DISABLE KEYS */;
INSERT INTO `escuelas` VALUES (1,'Colegio Carbó',NULL,NULL),(2,'Colegio Corazón de María',NULL,NULL),(3,'Colegio del Carmen',NULL,NULL),(4,'Colegio Monserrat',NULL,NULL),(5,'Colegio Nacional General San Martín',NULL,NULL),(6,'Escuela Agrotécnica Número 23',NULL,NULL),(7,'Escuela Normal Superior Número 10',NULL,NULL),(8,'Instituto Hellen Keller',NULL,NULL);
/*!40000 ALTER TABLE `escuelas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados_inscripcion`
--

DROP TABLE IF EXISTS `estados_inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados_inscripcion` (
  `id_estado_inscripcion` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado_inscripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados_inscripcion`
--

LOCK TABLES `estados_inscripcion` WRITE;
/*!40000 ALTER TABLE `estados_inscripcion` DISABLE KEYS */;
INSERT INTO `estados_inscripcion` VALUES (1,'Aprobada'),(2,'Pre-aprobada'),(3,'Registrada');
/*!40000 ALTER TABLE `estados_inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripciones`
--

DROP TABLE IF EXISTS `inscripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripciones` (
  `id_inscripcion` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_inscripcion` datetime DEFAULT NULL,
  `id_torneo` bigint(20) NOT NULL,
  `id_aspirante` bigint(20) NOT NULL,
  `id_competencia` bigint(20) NOT NULL,
  `id_categoria` bigint(20) NOT NULL,
  PRIMARY KEY (`id_inscripcion`),
  KEY `FK_qr3iq540rdg256nrd149qefq0` (`id_torneo`),
  KEY `FK_5vmhi9u2xvywgbq0sgredyu7s` (`id_aspirante`),
  KEY `FK_jg4hxffn04amiq3hlosrhl3o8` (`id_competencia`),
  KEY `FK_51aldnt7rn3dqesipa8lusyl4` (`id_categoria`),
  CONSTRAINT `FK_51aldnt7rn3dqesipa8lusyl4` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`),
  CONSTRAINT `FK_5vmhi9u2xvywgbq0sgredyu7s` FOREIGN KEY (`id_aspirante`) REFERENCES `aspirantes` (`id_aspirante`),
  CONSTRAINT `FK_jg4hxffn04amiq3hlosrhl3o8` FOREIGN KEY (`id_competencia`) REFERENCES `competencias` (`id_competencia`),
  CONSTRAINT `FK_qr3iq540rdg256nrd149qefq0` FOREIGN KEY (`id_torneo`) REFERENCES `torneos` (`id_torneo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sedes`
--

DROP TABLE IF EXISTS `sedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sedes` (
  `id_sede` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_sede`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sedes`
--

LOCK TABLES `sedes` WRITE;
/*!40000 ALTER TABLE `sedes` DISABLE KEYS */;
INSERT INTO `sedes` VALUES (1,'Villa María');
/*!40000 ALTER TABLE `sedes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneos`
--

DROP TABLE IF EXISTS `torneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torneos` (
  `id_torneo` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_nombre` varchar(255) DEFAULT NULL,
  `f_torneo` datetime DEFAULT NULL,
  `b_vigente` bit(1) DEFAULT NULL,
  `id_sede` bigint(20) NOT NULL,
  PRIMARY KEY (`id_torneo`),
  KEY `FK_9wptnnnk7ejey31a254rhj08x` (`id_sede`),
  CONSTRAINT `FK_9wptnnnk7ejey31a254rhj08x` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id_sede`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneos`
--

LOCK TABLES `torneos` WRITE;
/*!40000 ALTER TABLE `torneos` DISABLE KEYS */;
INSERT INTO `torneos` VALUES (1,'Torneo Evita','2019-03-01 09:17:43','',2);
/*!40000 ALTER TABLE `torneos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-01 10:24:34
