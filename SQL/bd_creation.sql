drop database if exists covid_db_test;

create database covid_db_test;

use covid_db;
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-04-18 04:10:56.272

-- tables
-- Table: continent
CREATE TABLE continent (
                           id_continent varchar(3) NOT NULL,
                           name varchar(50) NOT NULL,
                           CONSTRAINT continent_pk PRIMARY KEY (id_continent)
);

-- Table: country
CREATE TABLE country (
                         id_country varchar(5) NOT NULL,
                         id_continent varchar(3) NOT NULL,
                         name varchar(75) NOT NULL,
                         population int NOT NULL,
                         lat decimal(10,5) NOT NULL,
                         lng decimal(10,5) NOT NULL,
                         year_census int NOT NULL,
                         cases bigint NOT NULL DEFAULT 0,
                         deaths bigint NOT NULL DEFAULT 0,
                         recovered bigint NOT NULL DEFAULT 0,
                         vaccine int NOT NULL DEFAULT 0,
                         CONSTRAINT country_pk PRIMARY KEY (id_country)
);

-- Table: day_country
CREATE TABLE day_country (
                             id_day_country int NOT NULL AUTO_INCREMENT,
                             id_country varchar(5) NOT NULL,
                             date date NOT NULL,
                             actives int NOT NULL,
                             cases int NOT NULL,
                             deaths int NOT NULL,
                             recovered int NOT NULL,
                             vaccine int NOT NULL,
                             tx_date datetime NOT NULL,
                             tx_host varchar(50) NOT NULL,
                             tx_update datetime NOT NULL,
                             CONSTRAINT day_country_pk PRIMARY KEY (id_day_country)
);

-- Table: day_department
CREATE TABLE day_department (
                                id_day_department int NOT NULL AUTO_INCREMENT,
                                id_department varchar(10) NOT NULL,
                                date date NOT NULL,
                                new_cases int NOT NULL,
                                actives int NOT NULL,
                                deaths int NOT NULL,
                                recovered int NOT NULL,
                                vaccine int NOT NULL,
                                tx_date datetime NOT NULL,
                                tx_host varchar(50) NOT NULL,
                                tx_update datetime NOT NULL,
                                CONSTRAINT day_department_pk PRIMARY KEY (id_day_department)
);

-- Table: day_municipality
CREATE TABLE day_municipality (
                                  id_day_municipality int NOT NULL AUTO_INCREMENT,
                                  id_municipality varchar(5) NOT NULL,
                                  date date NOT NULL,
                                  new_cases int NOT NULL,
                                  actives int NOT NULL,
                                  deaths int NOT NULL,
                                  recovered int NOT NULL,
                                  vaccine int NOT NULL,
                                  tx_date datetime NOT NULL,
                                  tx_host varchar(50) NOT NULL,
                                  tx_update datetime NOT NULL,
                                  CONSTRAINT day_municipality_pk PRIMARY KEY (id_day_municipality)
);

-- Table: department
CREATE TABLE department (
                            id_department varchar(10) NOT NULL,
                            id_country varchar(5) NOT NULL,
                            name varchar(50) NOT NULL,
                            population int NOT NULL,
                            lat decimal(10,5) NOT NULL,
                            lng decimal(10,5) NOT NULL,
                            year_census int NOT NULL,
                            cases int NOT NULL DEFAULT 0,
                            deaths int NOT NULL DEFAULT 0,
                            recovered int NOT NULL DEFAULT 0,
                            vaccine int NOT NULL DEFAULT 0,
                            CONSTRAINT department_pk PRIMARY KEY (id_department)
);

-- Table: h_day_country
CREATE TABLE h_day_country (
                               id_h_day_country int NOT NULL AUTO_INCREMENT,
                               id_day_country int NOT NULL,
                               id_country varchar(5) NOT NULL,
                               date date NOT NULL,
                               new_cases int NOT NULL,
                               actives int NOT NULL,
                               deaths int NOT NULL,
                               recovered int NOT NULL,
                               vaccine int NOT NULL,
                               tx_date datetime NOT NULL,
                               tx_host varchar(50) NOT NULL,
                               tx_update datetime NOT NULL,
                               CONSTRAINT h_day_country_pk PRIMARY KEY (id_h_day_country)
);

-- Table: h_day_department
CREATE TABLE h_day_department (
                                  id_h_day_department int NOT NULL AUTO_INCREMENT,
                                  id_day_department int NOT NULL,
                                  id_department varchar(10) NOT NULL,
                                  date date NOT NULL,
                                  new_cases int NOT NULL,
                                  actives int NOT NULL,
                                  deaths int NOT NULL,
                                  recovered int NOT NULL,
                                  vaccine int NOT NULL,
                                  tx_date datetime NOT NULL,
                                  tx_host varchar(50) NOT NULL,
                                  tx_update datetime NOT NULL,
                                  CONSTRAINT h_day_department_pk PRIMARY KEY (id_h_day_department)
);

-- Table: h_day_municipios
CREATE TABLE h_day_municipios (
                                  id_h_day_municipality int NOT NULL AUTO_INCREMENT,
                                  id_day_municipality int NOT NULL,
                                  id_municipality varchar(5) NOT NULL,
                                  date date NOT NULL,
                                  new_cases int NOT NULL,
                                  actives int NOT NULL,
                                  deaths int NOT NULL,
                                  recovered int NOT NULL,
                                  vaccine int NOT NULL,
                                  tx_date datetime NOT NULL,
                                  tx_host varchar(50) NOT NULL,
                                  tx_update datetime NOT NULL,
                                  CONSTRAINT h_day_municipios_pk PRIMARY KEY (id_h_day_municipality)
);

-- Table: municipality
CREATE TABLE municipality (
                              id_municipality varchar(5) NOT NULL,
                              id_department varchar(10) NOT NULL,
                              name varchar(75) NOT NULL,
                              population int NOT NULL,
                              lat decimal(10,5) NOT NULL,
                              lng decimal(10,5) NOT NULL,
                              year_census int NOT NULL DEFAULT 0,
                              cases int NOT NULL DEFAULT 0,
                              deaths int NOT NULL DEFAULT 0,
                              recovered int NOT NULL DEFAULT 0,
                              vaccine int NOT NULL DEFAULT 0,
                              CONSTRAINT municipality_pk PRIMARY KEY (id_municipality)
);

-- foreign keys
-- Reference: country_continent (table: country)
ALTER TABLE country ADD CONSTRAINT country_continent FOREIGN KEY country_continent (id_continent)
    REFERENCES continent (id_continent);

-- Reference: day_country_country (table: day_country)
ALTER TABLE day_country ADD CONSTRAINT day_country_country FOREIGN KEY day_country_country (id_country)
    REFERENCES country (id_country);

-- Reference: day_department_department (table: day_department)
ALTER TABLE day_department ADD CONSTRAINT day_department_department FOREIGN KEY day_department_department (id_department)
    REFERENCES department (id_department);

-- Reference: day_municipios_municipios (table: day_municipality)
ALTER TABLE day_municipality ADD CONSTRAINT day_municipios_municipios FOREIGN KEY day_municipios_municipios (id_municipality)
    REFERENCES municipality (id_municipality);

-- Reference: departament_country (table: department)
ALTER TABLE department ADD CONSTRAINT departament_country FOREIGN KEY departament_country (id_country)
    REFERENCES country (id_country);

-- Reference: municipios_departament (table: municipality)
ALTER TABLE municipality ADD CONSTRAINT municipios_departament FOREIGN KEY municipios_departament (id_department)
    REFERENCES department (id_department);

-- End of file.

-- Creacion table Usuario
drop table if exists administrator;
drop table if exists hospital;
drop table if exists pharmacy;
create  table administrator (
    id_administrator int primary key auto_increment,
    password varchar(255) not null,
    name varchar(50) not null ,
    last_name varchar(50) not null,
    email varchar(100) not null,
    status tinyint NOT NULL,
    tx_date datetime NOT NULL,
    tx_id_user int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL);
create table hospital(
    id_hospital int primary key auto_increment,
    id_department varchar(10),
    name varchar(100) not null,
    location varchar(100) not null,
    phoneNumber varchar(20) not null ,
    lat decimal(10,5) NOT NULL,
    lng decimal(10,5) NOT NULL,
    tx_date datetime NOT NULL,
    tx_id_administrator int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL);

ALTER TABLE hospital ADD CONSTRAINT hospital_department FOREIGN KEY hospital_department (id_department)
    REFERENCES department (id_department);
create table pharmacy(
                         id_pharmacy int primary key auto_increment,
                         id_department varchar(10),
                         name varchar(100) not null,
                         location varchar(100) not null,
                         phoneNumber varchar(20) not null ,
                         lat decimal(10,5) NOT NULL,
                         lng decimal(10,5) NOT NULL,
                         tx_date datetime NOT NULL,
                         tx_id_administrator int NOT NULL,
                         tx_host varchar(100) NOT NULL,
                         tx_update datetime NOT NULL);

);
ALTER TABLE pharmacy ADD CONSTRAINT pharmacy_department FOREIGN KEY pharmacy_department (id_department)
    REFERENCES department (id_department);
insert into administrator values (null,"$2a$10$xNqp3FoBn13MABpyP.92v.ok1W400fbrJAHsuKUhLACOGkk2AIXfW","Silvana","Munoz","silvana.munoz@ucb.edu.bo",1,NOW(),1,"192.168.1.18", NOW());
insert into administrator values (null,"$2a$10$xNqp3FoBn13MABpyP.92v.ok1W400fbrJAHsuKUhLACOGkk2AIXfW","Josemar","Castro","josemar.castro@ucb.edu.bo",1,NOW(),1,"192.168.100.48", NOW());
insert into administrator values (null,"$2a$10$xNqp3FoBn13MABpyP.92v.ok1W400fbrJAHsuKUhLACOGkk2AIXfW","Ximena","Cruz","ximena.cruz@ucb.edu.bo",1,NOW(),1,"192.168.0.18", NOW());