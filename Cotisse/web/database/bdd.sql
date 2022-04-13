/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
CREATE DATABASE cotisse;
USE cotisse;

CREATE TABLE administrator(
    idadmin INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    loginadmin VARCHAR(255),
    mdpadmin VARCHAR(255)
);

CREATE TABLE client (
    idclient INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nom CHAR(255),
    email VARCHAR(255),
    mdp VARCHAR(255)
);

CREATE TABLE destination (
    iddestination INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(255)
);

CREATE TABLE reservation (
    idreservation INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idclient INT,
    iddestination INT,
    places INT,
    datereservation DATE,
    statut BOOLEAN,
    FOREIGN KEY (idclient) REFERENCES client(idclient),
    FOREIGN KEY (iddestination) REFERENCES destination(iddestination)
)ENGINE=InnoDb;

INSERT INTO administrator VALUES ("0", "admin", sha1("admin"));
/**
 * Author:  rindr
 * Created: 3 juin 2021
 */

