drop database if exists covid_db;

create database covid_db;

use covid_db;

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-04-14 22:09:43.685

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
                         CONSTRAINT country_pk PRIMARY KEY (id_country)
);

-- Table: day_country
CREATE TABLE day_country (
                             id_day_country int NOT NULL AUTO_INCREMENT,
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

-- Table: day_municipios
CREATE TABLE day_municipio (
                                id_day_municipio int NOT NULL AUTO_INCREMENT,
                                id_municipio varchar(5) NOT NULL,
                                date date NOT NULL,
                                new_cases int NOT NULL,
                                actives int NOT NULL,
                                deaths int NOT NULL,
                                recovered int NOT NULL,
                                vaccine int NOT NULL,
                                tx_date datetime NOT NULL,
                                tx_host varchar(50) NOT NULL,
                                tx_update datetime NOT NULL,
                                CONSTRAINT day_municipio_pk PRIMARY KEY (id_day_municipio)
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
CREATE TABLE h_day_municipio (
                                  id_h_day_municipio int NOT NULL AUTO_INCREMENT,
                                  id_day_municipio int NOT NULL,
                                  id_municipios varchar(5) NOT NULL,
                                  date date NOT NULL,
                                  new_cases int NOT NULL,
                                  actives int NOT NULL,
                                  deaths int NOT NULL,
                                  recovered int NOT NULL,
                                  vaccine int NOT NULL,
                                  tx_date datetime NOT NULL,
                                  tx_host varchar(50) NOT NULL,
                                  tx_update datetime NOT NULL,
                                  CONSTRAINT h_day_municipio_pk PRIMARY KEY (id_h_day_municipio)
);

-- Table: municipios
CREATE TABLE municipio (
                            id_municipio varchar(5) NOT NULL,
                            id_department varchar(10) NOT NULL,
                            name varchar(75) NOT NULL,
                            population int NOT NULL,
                            lat decimal(10,5) NOT NULL,
                            lng decimal(10,5) NOT NULL,
                            year_census int NOT NULL,
                            CONSTRAINT municipio_pk PRIMARY KEY (id_municipio)
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

-- Reference: day_municipios_municipios (table: day_municipios)
ALTER TABLE day_municipio ADD CONSTRAINT day_municipio_municipio FOREIGN KEY day_municipio_municipio (id_municipio)
    REFERENCES municipio (id_municipio);

-- Reference: departament_country (table: department)
ALTER TABLE department ADD CONSTRAINT departament_country FOREIGN KEY departament_country (id_country)
    REFERENCES country (id_country);

-- Reference: municipios_departament (table: municipios)
ALTER TABLE municipio ADD CONSTRAINT municipio_departament FOREIGN KEY municipio_departament (id_department)
    REFERENCES department (id_department);

-- End of file.

