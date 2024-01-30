CREATE DATABASE  IF NOT EXISTS `book_management`;
USE `book_management`;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book_management`.`book` (
  `bookID` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `author` VARCHAR(45) NULL,
  `isbn` INT NULL,
  PRIMARY KEY (`bookID`));

  --
  -- Data for table `book`
  --

  INSERT INTO `book_management`.`book` VALUES
  	(1,'Java Programming','James Gosling' ,1235),
  	(2,'C# Programming','Anders Hejlsberg', 1236),
  	(3,'C++ Programming','Bjarne Stroustrup', 1237),
  	(4,'Python Programming','Guido van Rossum', 1238);