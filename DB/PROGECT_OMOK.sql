DROP DATABASE IF EXISTS OMOK;
CREATE DATABASE OMOK;

USE OMOK;

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
	`U_ID`	VARCHAR(15) PRIMARY KEY	NOT NULL,
	`U_PW`	VARCHAR(20)  NOT	NULL,
	`U_LOG`	ENUM("Y","N") NOT	NULL
);

DROP TABLE IF EXISTS `RESULT`;

CREATE TABLE `RESULT` (
	`R_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`R_U_ID`	VARCHAR(15)	NOT NULL,
	`R_POSITION`	ENUM("BLACK","WHITE") NOT	NULL,
	`R_OUTCOME`	ENUM("WIN","LOSE","DRAW") NOT	NULL,
	`R_DATE`	DATETIME DEFAULT CURRENT_TIMESTAMP NOT	NULL
);

DROP TABLE IF EXISTS `SCORE`;

CREATE TABLE `SCORE` (
	`S_NUM`	INT PRIMARY KEY AUTO_INCREMENT	NOT NULL,
	`S_U_ID`	VARCHAR(15)	NOT NULL,
	`S_POSITION`	ENUM("BLACK","WHITE") NOT	NULL,
	`S_COUNT`	INT NOT	NULL,
	`S_WIN`	INT NOT	NULL,
	`S_LOSE`	INT NOT	NULL,
	`S_DAW`	INT NOT	NULL
);


ALTER TABLE `RESULT` ADD CONSTRAINT `FK_USER_TO_RESULT_1` FOREIGN KEY (
	`R_U_ID`
)
REFERENCES `USER` (
	`U_ID`
);

ALTER TABLE `SCORE` ADD CONSTRAINT `FK_USER_TO_SCORE_1` FOREIGN KEY (
	`S_U_ID`
)
REFERENCES `USER` (
	`U_ID`
);
