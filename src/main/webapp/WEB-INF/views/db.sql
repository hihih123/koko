

CREATE TABLE `gnote`.`member` (
  `serial` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `id` CHAR(45),
  `pw` CHAR(45),
  `firstName` CHAR(45),
  `lastName` CHAR(45),
  PRIMARY KEY (`serial`)
)
ENGINE = InnoDB;

CREATE TABLE  `gnote`.`groups` (
  `serial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `memberSerial` int(10) unsigned DEFAULT NULL,
  `name` char(45) DEFAULT NULL,
  `purpose` char(60) DEFAULT NULL,
  `numMember` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `gnote`.`tasks` (
  `serial` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `groupSerial` INTEGER UNSIGNED,
  `memberSerial` INTEGER UNSIGNED,
  `name` CHAR(45),
  `regDate` DATETIME,
  `expiredDate` DATETIME,
  `todo` CHAR(200),
  `isCompleted` BOOLEAN,
  PRIMARY KEY (`serial`)
)
ENGINE = InnoDB;

CREATE TABLE  `gnote`.`groupmembers` (
  `serial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `groupSerial` int(10) unsigned DEFAULT NULL,
  `memberSerial` int(10) unsigned DEFAULT NULL,
  `id` char(45) DEFAULT NULL,
  `regDate` datetime DEFAULT NULL,
  `isMaster` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;