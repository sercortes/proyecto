-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: savpro
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.16-MariaDB

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
  `email` varchar(100) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `perfil` int(11) NOT NULL,
  `estatus` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `perfil` (`perfil`),
  CONSTRAINT `FKUsuario` FOREIGN KEY (`perfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'ssergio','sergio@misena.edu.co','admin','21232f297a57a5a743894a0e4a801fc3',1,'ok'),(2,'andrea','andrea@misena.edu.co','users','ee11cbb19052e40b07aac0ca060c23ee',2,'ok'),(3,'ximena','ximena@misena.edu.co','jimena','ce127552d8bef2d3f15be385cd3363b3',2,'ok'),(60,'Miguel','sdcortes6@misena.edu.co','Miguel','0eb18d20d6fb90cb6ba1810c5f266d2a',3,'ok');
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_formacion`
--

LOCK TABLES `actividad_formacion` WRITE;
/*!40000 ALTER TABLE `actividad_formacion` DISABLE KEYS */;
INSERT INTO `actividad_formacion` VALUES (16,'introduccion a las redes','2019-08-17','2019-09-14',2,11),(53,'Inteligencia artificial','2019-08-01','2019-09-19',4,8),(54,'Linux','2019-08-01','2019-08-31',4,8),(55,'Linux','2019-08-01','2019-08-30',5,8),(56,'Linux','2019-08-01','2019-08-30',4,23);
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
  KEY `FKEvaluador` (`EvaluadorId`),
  CONSTRAINT `FKActividadFormacion` FOREIGN KEY (`actividadFormacionId`) REFERENCES `actividad_formacion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKEvaluador` FOREIGN KEY (`EvaluadorId`) REFERENCES `evaluador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_formacion_has_aprendiz`
--

LOCK TABLES `actividad_formacion_has_aprendiz` WRITE;
/*!40000 ALTER TABLE `actividad_formacion_has_aprendiz` DISABLE KEYS */;
INSERT INTO `actividad_formacion_has_aprendiz` VALUES (56,12,'50','2019-09-24','Muy bueno');
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
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKTamano` (`idtamano`),
  KEY `FKUsuario1` (`idUsuario`),
  KEY `FKtipo` (`idtipo_Entidad`),
  CONSTRAINT `FKTamano` FOREIGN KEY (`idtamano`) REFERENCES `tamano` (`idtamano`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKUsuario1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKtipo` FOREIGN KEY (`idtipo_Entidad`) REFERENCES `tipo_Entidad` (`idtipo_Entidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (3,'wester.co','345-4562-23','calle 45 #55-2 barrio las flores','2343456','Comercial','Empresa dedicada a la elaboraciÃ³n de articulos comestibles como empanadas u otros su principal producto son las hamburguesas gigantes',1,2,'www.wester.com.co','wester',2),(4,'sintec.co','9967894-1233','kra 8 # 34-45 san miguel','2346593','Comercial','Empresas dedicada a la ventas de equipos infomaticos para ambientes educativos',1,1,'www.sintec.com.co','Sintec',3),(5,'super.co','4545-235788-455','Calle 17 D No.116-15','456-45-67','Comercial','1961 nace la empresa, Productos Ricos Ltda. Comienza la consolidaciÃ³n de la imagen de marca.\r\nInicia la producciÃ³n de papas. En una pequeÃ±a planta en el barrio Rionegro de la ciudad de BogotÃ¡, se desarrolla el proceso de las papas de manera semi-industrial.\r\n1967 La sociedad Productos Ricos Ltda, cambia su razÃ³n social, a Comestibles Ricos Ltda.',1,1,'https://www.superricas.com/conocenos','Super ricas',3),(6,'alpinas','56562-56567RRRR','Km 3, via briceño sopo','34653423','Comercio','Empresa deidca a la ventas de producto nutritivos a base de lacteos',1,1,'https://www.alpina.com/','Alpinás',2);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluador`
--

DROP TABLE IF EXISTS `evaluador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `programa_formacion` varchar(255) NOT NULL,
  `CorreoEvaluador` varchar(255) NOT NULL,
  `CodTipo` int(11) NOT NULL,
  `codUsuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKTipoEvaluador` (`CodTipo`),
  KEY `FKUsuarioEvaluador` (`codUsuario`),
  CONSTRAINT `FKTipoEvaluador` FOREIGN KEY (`CodTipo`) REFERENCES `TipoEvaluador` (`idTipoEvaluador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKUsuarioEvaluador` FOREIGN KEY (`codUsuario`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluador`
--

LOCK TABLES `evaluador` WRITE;
/*!40000 ALTER TABLE `evaluador` DISABLE KEYS */;
INSERT INTO `evaluador` VALUES (12,'Miguel','cervantez','ADSI','sdcortes6@misena.edu.co',2,60);
/*!40000 ALTER TABLE `evaluador` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (8,'Simplex','26%',3,3,'Proyecto enfocado en solucionar la problematica de las basuras y con ellas generar nuevos producto a base de economio circular','Implementar estrategias que permitan reutilizar desechos y reducir la contaminacion '),(11,'Curso CISCO','25%',4,4,'Ofrece una educacion y capacitacion tecnica con referente a la gestion y seguridad de redes, y se vincula a orientar a miles de personas la plataforma para brindar soporte profesional.','Informar respecto a la seguridad de redes y su importancia.\r\n\r\nUtilizar herramientas para aumento del conocimiento en cableado estructurado'),(23,'Full era','50%',6,3,'Proyecto dedicado para establecer conevios','Implementar estrategias que fomentes la ventas en el municipio');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_Entidad`
--

LOCK TABLES `tipo_Entidad` WRITE;
/*!40000 ALTER TABLE `tipo_Entidad` DISABLE KEYS */;
INSERT INTO `tipo_Entidad` VALUES (1,'privada'),(2,'publica');
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

-- Dump completed on 2019-10-05  8:26:57
