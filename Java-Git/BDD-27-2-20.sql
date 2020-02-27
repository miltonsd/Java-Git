-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: taller_mecanico
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `automoviles`
--

DROP TABLE IF EXISTS `automoviles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automoviles` (
  `id_patente` varchar(45) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `color` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_patente`),
  KEY `fk_automoviles_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_automoviles_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automoviles`
--

LOCK TABLES `automoviles` WRITE;
/*!40000 ALTER TABLE `automoviles` DISABLE KEYS */;
INSERT INTO `automoviles` VALUES ('AB333CD',2,'azul','Toyota','Hilux'),('AB333CP',4,'Rojo','Chevrolet','Onix');
/*!40000 ALTER TABLE `automoviles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id_factura` int(11) NOT NULL,
  `fecha_emision` date DEFAULT NULL,
  `importe_total` float(8,2) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_facturas_usuarios1_idx` (`id_usuario`),
  CONSTRAINT `fk_facturas_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,NULL,28864.00,2),(2,'2020-02-27',4222.00,4);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoja_repuestos`
--

DROP TABLE IF EXISTS `hoja_repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoja_repuestos` (
  `id_repuesto` int(11) NOT NULL,
  `id_hoja` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio_total` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`id_repuesto`,`id_hoja`),
  KEY `id_hoja_idx` (`id_hoja`),
  CONSTRAINT `id_hoja` FOREIGN KEY (`id_hoja`) REFERENCES `hojas_de_parte` (`id_hoja`),
  CONSTRAINT `id_repuesto` FOREIGN KEY (`id_repuesto`) REFERENCES `repuestos` (`id_repuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoja_repuestos`
--

LOCK TABLES `hoja_repuestos` WRITE;
/*!40000 ALTER TABLE `hoja_repuestos` DISABLE KEYS */;
INSERT INTO `hoja_repuestos` VALUES (1,30,1,11.00),(1,31,1,11.00),(2,30,1,1550.00),(2,31,1,1550.00),(6,30,1,2222.00),(6,32,1,2222.00);
/*!40000 ALTER TABLE `hoja_repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hojas_de_parte`
--

DROP TABLE IF EXISTS `hojas_de_parte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hojas_de_parte` (
  `id_hoja` int(11) NOT NULL AUTO_INCREMENT,
  `costo_mano_de_obra` float(8,2) DEFAULT NULL,
  `id_mecanico` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_patente` varchar(45) NOT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_hoja`),
  KEY `fk_hojas_de_parte_usuarios1_idx` (`id_mecanico`),
  KEY `fk_hojas_de_parte_facturas1_idx` (`id_factura`),
  KEY `fk_hojas_de_parte_automoviles1_idx` (`id_patente`),
  CONSTRAINT `fk_hojas_de_parte_automoviles1` FOREIGN KEY (`id_patente`) REFERENCES `automoviles` (`id_patente`),
  CONSTRAINT `fk_hojas_de_parte_usuarios1` FOREIGN KEY (`id_mecanico`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hojas_de_parte`
--

LOCK TABLES `hojas_de_parte` WRITE;
/*!40000 ALTER TABLE `hojas_de_parte` DISABLE KEYS */;
INSERT INTO `hojas_de_parte` VALUES (30,22220.00,1,1,'AB333CD','Reparaciones varias.'),(31,1300.00,1,1,'AB333CD','Reparaciones varias.'),(32,2000.00,1,2,'AB333CP','Arreglos varios');
/*!40000 ALTER TABLE `hojas_de_parte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametro` (
  `parametro` varchar(45) NOT NULL,
  PRIMARY KEY (`parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES ('1');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `cuit` int(12) NOT NULL,
  `razon_social` varchar(45) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cuit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (295459399,'Pancho el proveedor',3334440,'Zeballos 1341','panchoelproveedor@hotmail.com'),(306239871,'Tito el proveedor',4582509,'Mendoza 5400','titoelproveedor@hotmail.com');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparaciones`
--

DROP TABLE IF EXISTS `reparaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reparaciones` (
  `fecha_ingreso` date NOT NULL,
  `estado_reparacion` varchar(45) DEFAULT NULL,
  `id_patente` varchar(45) NOT NULL,
  `id_mecanico` int(11) NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  PRIMARY KEY (`fecha_ingreso`,`id_patente`,`id_mecanico`),
  KEY `fk_reparaciones_automoviles1_idx` (`id_patente`),
  KEY `fk_reparaciones_usuarios1_idx` (`id_mecanico`),
  CONSTRAINT `fk_reparaciones_automoviles1` FOREIGN KEY (`id_patente`) REFERENCES `automoviles` (`id_patente`),
  CONSTRAINT `fk_reparaciones_usuarios1` FOREIGN KEY (`id_mecanico`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES ('2019-09-15','Reparado','AB333CD',1,'2019-10-14');
/*!40000 ALTER TABLE `reparaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuestos`
--

DROP TABLE IF EXISTS `repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repuestos` (
  `id_repuesto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio_unitario` float(8,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `punto_pedido` int(11) DEFAULT NULL,
  `id_tipo_repuesto` int(11) NOT NULL,
  `cuit` int(11) NOT NULL,
  PRIMARY KEY (`id_repuesto`),
  KEY `fk_repuestos_tipo_repuestos1_idx` (`id_tipo_repuesto`),
  KEY `fk_repuestos_proveedores1_idx` (`cuit`),
  CONSTRAINT `fk_repuestos_proveedores1` FOREIGN KEY (`cuit`) REFERENCES `proveedores` (`cuit`),
  CONSTRAINT `fk_repuestos_tipo_repuestos1` FOREIGN KEY (`id_tipo_repuesto`) REFERENCES `tipo_repuestos` (`id_tipo_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (1,'Puerta Toyota Hilux',11.00,2,0,1,306239871),(2,'Capo WW Gol Trend',1550.00,3,0,2,306239871),(6,'Volante Chevrolet',2222.00,1,0,3,295459399),(8,'Volante Toyota',1333.35,1,0,3,295459399);
/*!40000 ALTER TABLE `repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'mecanico'),(2,'cliente'),(3,'admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_repuestos`
--

DROP TABLE IF EXISTS `tipo_repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_repuestos` (
  `id_tipo_repuesto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_repuestos`
--

LOCK TABLES `tipo_repuestos` WRITE;
/*!40000 ALTER TABLE `tipo_repuestos` DISABLE KEYS */;
INSERT INTO `tipo_repuestos` VALUES (1,'Puertas'),(2,'Capo'),(3,'Volantes');
/*!40000 ALTER TABLE `tipo_repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `password` varchar(70) DEFAULT NULL,
  `habilitado` tinyint(4) DEFAULT NULL,
  `id_rol` int(11) NOT NULL,
  `parametro` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuarios_roles_idx` (`id_rol`),
  KEY `fk_parametro_idx` (`parametro`),
  CONSTRAINT `fk_usuarios_parametros` FOREIGN KEY (`parametro`) REFERENCES `parametro` (`parametro`),
  CONSTRAINT `fk_usuarios_roles` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Mecanico','Mecanico',3950232,'al',444334211,'mecanico','Mecanico',1,1,'1'),(2,'Esteban','Quito',4020323,'estebanquito@hotmail.com',4787777,'equito','estebanquito',1,2,'1'),(4,'Susana','Torio',3300223,'susanatorio@hotmail.com',434355677,'storio','susanatorio',1,2,'1'),(5,'Admin','Admin',999999,'admin@hotmail.com',4444,'admin','c1377f2ff9476d9db6168491791bb55836f06c551aae5cc86742602947a538fd',1,3,'1');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 20:05:16
