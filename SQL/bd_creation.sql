drop database if exists covid_db;

create database covid_db;

use covid_db;

CREATE TABLE continent (
    id_continent varchar(5) NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT continent_pk PRIMARY KEY (id_continent)
);

-- Table: country
CREATE TABLE country (
    id_country varchar(8) NOT NULL,
    id_continent varchar(5) NOT NULL,
    name varchar(50) NOT NULL,
    population int NOT NULL,
    year_census int NOT NULL,
    CONSTRAINT country_pk PRIMARY KEY (id_country)
);

-- Table: day_departament
CREATE TABLE day_departament (
    id_day_departament int NOT NULL AUTO_INCREMENT,
    id_departament varchar(10) NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT day_departament_pk PRIMARY KEY (id_day_departament)
);

-- Table: day_municipio
CREATE TABLE day_municipio (
    id_day_municipio int NOT NULL AUTO_INCREMENT,
    id_municipio int NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT day_municipio_pk PRIMARY KEY (id_day_municipio)
);

-- Table: day_world
CREATE TABLE day_country (
    id_day_country int NOT NULL AUTO_INCREMENT,
    id_country varchar(10) NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT day_country_pk PRIMARY KEY (id_day_country)
);

-- Table: departament
CREATE TABLE departament (
    id_departament varchar(8) NOT NULL,
    id_country varchar(10) NOT NULL,
    name varchar(30) NOT NULL,
    population int NOT NULL,
    year_census int NOT NULL,
    CONSTRAINT departament_pk PRIMARY KEY (id_departament)
);

-- Table: h_day_departament
CREATE TABLE h_day_departament (
    id_h_day_departament int NOT NULL AUTO_INCREMENT,
    id_day_departament int NOT NULL,
    id_departament varchar(10) NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT h_day_departament_pk PRIMARY KEY (id_h_day_departament)
);

-- Table: h_day_municipio
CREATE TABLE h_day_municipio (
    id_h_day_municipio int NOT NULL AUTO_INCREMENT,
    id_day_municipio int NOT NULL,
    id_municipio int NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT h_day_municipio_pk PRIMARY KEY (id_h_day_municipio)
);

-- Table: h_day_world
CREATE TABLE h_day_country (
    id_h_day_country int NOT NULL AUTO_INCREMENT,
    id_day_country int NOT NULL,
    id_country varchar(8) NOT NULL,
    date date NOT NULL,
    new_cases int NOT NULL,
    deaths int NOT NULL,
    recovered int NOT NULL,
    vaccine int NOT NULL,
    accumulated int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT h_day_country_pk PRIMARY KEY (id_h_day_country)
);

-- Table: h_visit
CREATE TABLE h_visit (
    id_h_visit int NOT NULL AUTO_INCREMENT,
    id_visit int NOT NULL,
    date date NOT NULL,
    count int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT h_visit_pk PRIMARY KEY (id_h_visit)
);

-- Table: municipio
CREATE TABLE municipio (
    id_municipio int NOT NULL AUTO_INCREMENT,
    id_departament varchar(10) NOT NULL,
    name varchar(30) NOT NULL,
    population int NOT NULL,
    year_census int NOT NULL,
    CONSTRAINT municipio_pk PRIMARY KEY (id_municipio)
);

-- Table: visit
CREATE TABLE visit (
    id_visit int NOT NULL AUTO_INCREMENT,
    date date NOT NULL,
    count int NOT NULL,
    tx_date datetime NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_update datetime NOT NULL,
    CONSTRAINT visit_pk PRIMARY KEY (id_visit)
);

-- foreign keys
-- Reference: City_Country (table: departament)
ALTER TABLE departament ADD CONSTRAINT City_Country FOREIGN KEY City_Country (id_country)
    REFERENCES country (id_country);

-- Reference: Copy_of_day_Bolivia_departament (table: day_departament)
ALTER TABLE day_departament ADD CONSTRAINT Copy_of_day_Bolivia_departament FOREIGN KEY Copy_of_day_Bolivia_departament (id_departament)
    REFERENCES departament (id_departament);

-- Reference: Country_Continent (table: country)
ALTER TABLE country ADD CONSTRAINT Country_Continent FOREIGN KEY Country_Continent (id_continent)
    REFERENCES continent (id_continent);

-- Reference: Day_Municipio (table: day_municipio)
ALTER TABLE day_municipio ADD CONSTRAINT Day_Municipio FOREIGN KEY Day_Municipio (id_municipio)
    REFERENCES municipio (id_municipio);

-- Reference: Day_World_Country (table: day_world)
ALTER TABLE day_country ADD CONSTRAINT Day_Country_Country FOREIGN KEY Day_Country_Country (id_country)
    REFERENCES country (id_country);

-- Reference: Municipio_State (table: municipio)
ALTER TABLE municipio ADD CONSTRAINT Municipio_State FOREIGN KEY Municipio_State (id_departament)
    REFERENCES departament (id_departament);

-- End of file.