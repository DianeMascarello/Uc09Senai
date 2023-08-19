CREATE DATABASE  IF NOT EXISTS `uc9_desenvolvimento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `uc9_desenvolvimento`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: uc9_desenvolvimento
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_Usuario` int NOT NULL AUTO_INCREMENT,
  `ativo` tinyint DEFAULT NULL,
  `nome_Usuario` varchar(150) DEFAULT NULL,
  `email_Usuario` varchar(150) DEFAULT NULL,
  `cpf_Usuario` varchar(11) DEFAULT NULL,
  `cnpj_Usuario` varchar(15) DEFAULT NULL,
  `login` varchar(100) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_Usuario`),
  UNIQUE KEY `cpf_Usuario` (`cpf_Usuario`),
  UNIQUE KEY `cnpj_Usuario` (`cnpj_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'Alice Silva','teste@gmail.com','43264734010','00000000000000','teste@gmail.com','1234'),(2,1,'Miguel Antunes','testinho@gmail.com','00000000000','77716248000188','testinho@gmail.com','1234'),(3,1,'Davi Fonseca','testes@gmail.com','63468440081','00000000000001','testes@gmail.com','1234'),(4,1,'Isabella Santos','testao@gmail.com','22451243082','00000000000002','testao@gmail.com','1234'),(5,1,'Arthur Castro','testando@gmail.com','00000000001','46701775000195','testando@gmail.com','1234'),(6,1,'Julia Taner','testar@gmail.com','00000000002','19661091000134','testar@gmail.com','1234'),(7,1,'Pedro Lunelli','testamos@gmail.com','33474982087','00000000000003','testamos@gmail.com','1234'),(8,1,'Gabriel Santos','testaremos@gmail.com','00000000003','86590316000104','testaremos@gmail.com','1234'),(9,1,'Sophia Abraão','testei@gmail.com','72263864024','00000000000004','testei@gmail.com','1234'),(10,1,'Manuela Silva','testou@gmail.com','00000000004','98858064000122','testou@gmail.com','1234'),(21,NULL,'Diane Mascarello','email@teste.com.br',NULL,NULL,'email@teste.com.br','4321'),(22,NULL,'Testar','testar@gmail.com.br',NULL,NULL,'testar@gmail.com.br','7894');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-18 23:26:55
