-- MySQL dump 10.15  Distrib 10.0.38-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: savpro
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB

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
-- Table structure for table `EmpresaUsuario`
--

DROP TABLE IF EXISTS `EmpresaUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EmpresaUsuario` (
  `codEmpresa` int(11) NOT NULL,
  `codUsuario` int(11) NOT NULL,
  KEY `codEmpresa` (`codEmpresa`),
  KEY `codUsuario` (`codUsuario`),
  CONSTRAINT `codEmpresa` FOREIGN KEY (`codEmpresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `codUsuario` FOREIGN KEY (`codUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmpresaUsuario`
--

LOCK TABLES `EmpresaUsuario` WRITE;
/*!40000 ALTER TABLE `EmpresaUsuario` DISABLE KEYS */;
INSERT INTO `EmpresaUsuario` VALUES (26,179),(29,179),(29,181),(26,180),(26,183),(29,184),(29,185),(29,186),(26,189);
/*!40000 ALTER TABLE `EmpresaUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoEvaluador`
--

DROP TABLE IF EXISTS `TipoEvaluador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoEvaluador` (
  `idTipoEvaluador` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idTipoEvaluador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoEvaluador`
--

LOCK TABLES `TipoEvaluador` WRITE;
/*!40000 ALTER TABLE `TipoEvaluador` DISABLE KEYS */;
INSERT INTO `TipoEvaluador` VALUES (1,'Instructor'),(2,'Estudiante');
/*!40000 ALTER TABLE `TipoEvaluador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `perfil` int(11) NOT NULL,
  `estatus` varchar(20) NOT NULL,
  `TipoEvaluador` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `perfil` (`perfil`),
  KEY `FKTipoEva` (`TipoEvaluador`),
  CONSTRAINT `FKTipoEva` FOREIGN KEY (`TipoEvaluador`) REFERENCES `TipoEvaluador` (`idTipoEvaluador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKUsuario` FOREIGN KEY (`perfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (63,'sergio','cortes','sdcortes6@misena.edu.co','81dc9bdb52d04dc20036dbd8313ed055',1,'ok',NULL),(179,'edith','zambrano','edith@gmail.com','bface9aa8e675d3a1757f143893793db',2,'ok',NULL),(180,'raul','mercado','raul@gmail.com','bc7a844476607e1a59d8eb1b1f311830',3,'ok',NULL),(181,'pepe','raul','pepe@gmail.com','926e27eecdbc7a18858b3798ba99bddd',3,'ok',NULL),(183,'joselito','bermudez','jose@gmail.com','662eaa47199461d01a623884080934ab',3,'ok',NULL),(184,'popo','dd','alexgamez8734@gmail.com','00825584fcc3b1359dbaf7c1dd3bb0da',3,'activo',NULL),(185,'sergio','jj','sdcortes6@misena.edu.co','5abce9766ac2a19d445cf5b86d06e5b6',3,'activo',NULL),(186,'alex','gamez','cortesgonzalez9@gmail.com','5ec109159a41a1971eebe8bcb48eed14',3,'activo',NULL),(187,'eduar','enowden','cortesgonzalez9@gmail.com','1234',3,'ok',NULL),(189,'laura','molano','laura@gmail.com','680e89809965ec41e64dc7e447f175ab',3,'ok',NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_formacion`
--

DROP TABLE IF EXISTS `actividad_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad_formacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `numero_sesiones` int(11) NOT NULL,
  `proyecto_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKProyecto` (`proyecto_id`),
  CONSTRAINT `FKProyecto` FOREIGN KEY (`proyecto_id`) REFERENCES `proyecto` (`idProyecto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_formacion`
--

LOCK TABLES `actividad_formacion` WRITE;
/*!40000 ALTER TABLE `actividad_formacion` DISABLE KEYS */;
INSERT INTO `actividad_formacion` VALUES (57,'Introducción a redes','2019-10-01','2019-10-30',3,44),(59,'Medio ambiente','2019-11-01','2019-11-30',4,44),(60,'porno','2019-11-16','2019-11-07',4,44),(61,'ss','2019-11-01','2019-11-30',4,44),(62,'Mantenimiento de redes','2019-12-01','2019-12-30',2,44),(63,'Mantenimiento de celulares','2019-11-08','2019-11-23',45,44),(64,'Introducción a las computadoras','2019-11-08','2019-11-07',4,44),(65,'s','2019-11-01','2019-11-22',3,44),(66,'s','2019-11-07','2019-11-14',3,44),(67,'s','2019-11-22','2019-11-19',3,44),(68,'s','2019-11-03','2019-11-08',3,44),(69,'c','2019-11-01','2019-11-15',3,44),(70,'s','2019-11-01','2019-11-13',3,44),(71,'s','2019-11-15','2019-11-13',4,44),(72,'s','2019-11-07','2019-11-21',3,44),(73,'s','2019-11-09','2019-11-15',2,44),(74,'s','2019-11-15','2019-11-21',2,44),(75,'a','2019-11-07','2019-11-06',2,44),(76,'s','2019-11-14','2019-11-14',2,44),(77,'ss','2019-11-01','2019-11-22',3,44),(78,'s','2019-11-15','2019-11-14',3,44);
/*!40000 ALTER TABLE `actividad_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_formacion_has_aprendiz`
--

DROP TABLE IF EXISTS `actividad_formacion_has_aprendiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad_formacion_has_aprendiz` (
  `actividadFormacionId` int(11) NOT NULL,
  `EvaluadorId` int(11) NOT NULL,
  `nota` varchar(100) DEFAULT NULL,
  `fecha_evaluacion` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  KEY `FKActividadFormacion` (`actividadFormacionId`),
  KEY `FKUsuarioEvaluador` (`EvaluadorId`),
  CONSTRAINT `FKActividadFormacion` FOREIGN KEY (`actividadFormacionId`) REFERENCES `actividad_formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKUsuarioEvaluador` FOREIGN KEY (`EvaluadorId`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_formacion_has_aprendiz`
--

LOCK TABLES `actividad_formacion_has_aprendiz` WRITE;
/*!40000 ALTER TABLE `actividad_formacion_has_aprendiz` DISABLE KEYS */;
INSERT INTO `actividad_formacion_has_aprendiz` VALUES (57,181,'34','2019-11-03','muy bueno'),(57,180,'80','2019-10-22','malop'),(59,185,NULL,NULL,NULL),(59,184,NULL,NULL,NULL),(60,185,NULL,NULL,NULL),(60,184,NULL,NULL,NULL),(61,185,NULL,NULL,NULL),(61,184,NULL,NULL,NULL),(62,185,NULL,NULL,NULL),(62,184,NULL,NULL,NULL),(63,185,NULL,NULL,NULL),(63,184,NULL,NULL,NULL),(64,186,NULL,NULL,NULL),(64,185,NULL,NULL,NULL),(65,186,NULL,NULL,NULL),(65,185,NULL,NULL,NULL),(66,186,NULL,NULL,NULL),(66,185,NULL,NULL,NULL),(67,185,NULL,NULL,NULL),(67,186,NULL,NULL,NULL),(68,185,NULL,NULL,NULL),(68,186,NULL,NULL,NULL),(68,184,NULL,NULL,NULL),(69,186,NULL,NULL,NULL),(69,185,NULL,NULL,NULL),(69,184,NULL,NULL,NULL),(70,185,NULL,NULL,NULL),(70,184,NULL,NULL,NULL),(70,186,NULL,NULL,NULL),(71,185,NULL,NULL,NULL),(71,186,NULL,NULL,NULL),(72,186,NULL,NULL,NULL),(72,185,NULL,NULL,NULL),(72,184,NULL,NULL,NULL),(73,186,NULL,NULL,NULL),(73,185,NULL,NULL,NULL),(73,184,NULL,NULL,NULL),(74,186,NULL,NULL,NULL),(74,185,NULL,NULL,NULL),(74,184,NULL,NULL,NULL),(75,186,NULL,NULL,NULL),(75,185,NULL,NULL,NULL),(76,186,NULL,NULL,NULL),(76,185,NULL,NULL,NULL),(77,186,NULL,NULL,NULL),(77,185,NULL,NULL,NULL),(78,186,NULL,NULL,NULL),(78,185,NULL,NULL,NULL);
/*!40000 ALTER TABLE `actividad_formacion_has_aprendiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Cordinador'),(2,'instructor'),(3,'asesor');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro`
--

DROP TABLE IF EXISTS `centro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `centro` (
  `idCentro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idCentro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro`
--

LOCK TABLES `centro` WRITE;
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
INSERT INTO `centro` VALUES (1,'CENTRO DE GESTION DE MERCADOS'),(2,'CENTRO DE SERVICIOS FINANCIEROS'),(3,'CENTRO DE GESTION ADMINISTRATIVA');
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(255) NOT NULL,
  `nit` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `sector_economico` varchar(255) NOT NULL,
  `descripcion` text NOT NULL,
  `idtipo_Entidad` int(11) NOT NULL,
  `idtamano` int(11) NOT NULL,
  `paginaWeb` varchar(255) NOT NULL,
  `nombreEmpresa` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKTamano` (`idtamano`),
  KEY `FKtipo` (`idtipo_Entidad`),
  CONSTRAINT `FKTamano` FOREIGN KEY (`idtamano`) REFERENCES `tamano` (`idtamano`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKtipo` FOREIGN KEY (`idtipo_Entidad`) REFERENCES `tipo_Entidad` (`idtipo_Entidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (26,'Nodext','23-355R-4556532','calle 34 # 7-56','234-65-76','Textil','Las telas inteligentes son una de las tendencias más prometedoras para el 2018, es decir, textiles con filtro UV, antibacteriales, biodegradables, repelentes, con adaptaciones especiales a las condiciones y cambios medio ambientales. Esta clase de telas se podrán apreciar en todo tipo de estilos, ya sean casuales, formales, deportivos o incluso para las prendas de control.\r\n\r\nLa industria textil muestra un panorama alentador para este 2018, es así como el presidente de Inexmoda, Carlos Eduardo Botero, señaló luego de culminar la Feria Colombiatex de las Américas, el pasado 25 de enero, que se ha presentado un ambiente de optimismo entre los empresarios, quienes ven grandes posibilidades de aumentar su competitividad, producción y rentabilidad. ',2,1,'www.nodext.co','nodext'),(29,'jdkasjdkjasd','kdsjdkj','kdjskdj','kjdskajd','jdksajdk','kjdskajdk',1,2,'jdkasjdkajsdk','Sonmmer');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interventor`
--

DROP TABLE IF EXISTS `interventor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interventor` (
  `idInterventor` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `cargo_idcargo` int(11) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono_celular` varchar(255) NOT NULL,
  `centro_idcentro` int(11) NOT NULL,
  PRIMARY KEY (`idInterventor`,`cargo_idcargo`),
  KEY `FKCargo` (`cargo_idcargo`),
  KEY `FKCentro` (`centro_idcentro`),
  CONSTRAINT `FKCargo` FOREIGN KEY (`cargo_idcargo`) REFERENCES `cargo` (`idCargo`),
  CONSTRAINT `FKCentro` FOREIGN KEY (`centro_idcentro`) REFERENCES `centro` (`idCentro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interventor`
--

LOCK TABLES `interventor` WRITE;
/*!40000 ALTER TABLE `interventor` DISABLE KEYS */;
INSERT INTO `interventor` VALUES (3,'edith','Gonzalez',2,'3453556','edith@gmail.com','kra 34#7-77','3123094567',2),(4,'Mauricio','Delgado',3,'6828408','madelgado05gmail.com','Kra 123 No. 172 a 80','3132172456',3);
/*!40000 ALTER TABLE `interventor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_formacion`
--

DROP TABLE IF EXISTS `material_formacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material_formacion` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `unidad_tenatica_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKUnidadTematica` (`unidad_tenatica_id`),
  CONSTRAINT `FKUnidadTematica` FOREIGN KEY (`unidad_tenatica_id`) REFERENCES `unidad_tenatica` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_formacion`
--

LOCK TABLES `material_formacion` WRITE;
/*!40000 ALTER TABLE `material_formacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `material_formacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'administrador'),(2,'empresa'),(3,'evaluador');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `idProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `copartida_sena` varchar(255) NOT NULL,
  `empresa_id` int(11) NOT NULL,
  `interventor_id` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `objetivos` text NOT NULL,
  PRIMARY KEY (`idProyecto`),
  KEY `FKEmpresa` (`empresa_id`),
  KEY `FKInterventor` (`interventor_id`),
  CONSTRAINT `FKEmpresa` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKInterventor` FOREIGN KEY (`interventor_id`) REFERENCES `interventor` (`idInterventor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (44,'new tech','34%',26,3,'Proyecto dedicado a la','Implementar TICs en la juventud'),(46,'calvo brazers','lkdjsalkdj',29,4,'Las telas inteligentes son una de las tendencias más prometedoras para el 2018, es decir, textiles con filtro UV, antibacteriales, biodegradables, repelentes, con adaptaciones especiales a las condiciones y cambios medio ambientales. Esta clase de telas se podrán apreciar en todo tipo de estilos, ya sean casuales, formales, deportivos o incluso para las prendas de control.\r\n\r\nLa industria textil muestra un panorama alentador para este 2018, es así como el presidente de Inexmoda, Carlos Eduardo Botero, señaló luego de culminar la Feria Colombiatex de las Américas, el pasado 25 de enero, que se ha presentado un ambiente de optimismo entre los empresarios, quienes ven grandes posibilidades de aumentar su competitividad, producción y rentabilidad. ','asdfasd');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamano`
--

DROP TABLE IF EXISTS `tamano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tamano` (
  `idtamano` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTamano` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idtamano`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamano`
--

LOCK TABLES `tamano` WRITE;
/*!40000 ALTER TABLE `tamano` DISABLE KEYS */;
INSERT INTO `tamano` VALUES (1,'grande'),(2,'pequeña');
/*!40000 ALTER TABLE `tamano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_Entidad`
--

DROP TABLE IF EXISTS `tipo_Entidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_Entidad` (
  `idtipo_Entidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEntidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idtipo_Entidad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_Entidad`
--

LOCK TABLES `tipo_Entidad` WRITE;
/*!40000 ALTER TABLE `tipo_Entidad` DISABLE KEYS */;
INSERT INTO `tipo_Entidad` VALUES (1,'publica'),(2,'privada');
/*!40000 ALTER TABLE `tipo_Entidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_tenatica`
--

DROP TABLE IF EXISTS `unidad_tenatica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_tenatica` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `actividad_formacion_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKActividadFormacionUni` (`actividad_formacion_id`),
  CONSTRAINT `FKActividadFormacionUni` FOREIGN KEY (`actividad_formacion_id`) REFERENCES `actividad_formacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_tenatica`
--

LOCK TABLES `unidad_tenatica` WRITE;
/*!40000 ALTER TABLE `unidad_tenatica` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidad_tenatica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-06  8:25:12
