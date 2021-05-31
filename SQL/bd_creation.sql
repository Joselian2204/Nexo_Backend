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
drop table if exists h_administrator;
drop table if exists h_hospital;
drop table if exists h_pharmacy;
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
    phone_number varchar(20) not null ,
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
                         phone_number varchar(20) not null ,
                         lat decimal(10,5) NOT NULL,
                         lng decimal(10,5) NOT NULL,
                         tx_date datetime NOT NULL,
                         tx_id_administrator int NOT NULL,
                         tx_host varchar(100) NOT NULL,
                         tx_update datetime NOT NULL);

ALTER TABLE pharmacy ADD CONSTRAINT pharmacy_department FOREIGN KEY pharmacy_department (id_department)
    REFERENCES department (id_department);
create  table h_administrator (
                                id_h_administrator int primary key auto_increment,
                                id_administrator int not null,
                                password varchar(255) not null,
                                name varchar(50) not null ,
                                last_name varchar(50) not null,
                                email varchar(100) not null,
                                status tinyint NOT NULL,
                                tx_date datetime NOT NULL,
                                tx_id_user int NOT NULL,
                                tx_host varchar(100) NOT NULL,
                                tx_update datetime NOT NULL);
create table h_hospital(
                         id_h_hospital int primary key auto_increment,
                         id_hospital int not null ,
                         id_department varchar(10),
                         name varchar(100) not null,
                         location varchar(100) not null,
                         phone_number varchar(20) not null ,
                         lat decimal(10,5) NOT NULL,
                         lng decimal(10,5) NOT NULL,
                         tx_date datetime NOT NULL,
                         tx_id_administrator int NOT NULL,
                         tx_host varchar(100) NOT NULL,
                         tx_update datetime NOT NULL);

create table h_pharmacy(
                         id_h_pharmacy int primary key auto_increment,
                         id_pharmacy int not null ,
                         id_department varchar(10),
                         name varchar(100) not null,
                         location varchar(100) not null,
                         phone_number varchar(20) not null ,
                         lat decimal(10,5) NOT NULL,
                         lng decimal(10,5) NOT NULL,
                         tx_date datetime NOT NULL,
                         tx_id_administrator int NOT NULL,
                         tx_host varchar(100) NOT NULL,
                         tx_update datetime NOT NULL);

select * from municipality where id_department="BOL1941";
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1293','Insumos Trinidad','C. Serafin Rivero','No tiene',-14.82628,-64.8958,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1293','Farmacia Trinidad','Av Sim�n Bol�var, Trinidad','No tiene',-14.83911,-64.8973,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1293','Farmacia EL CARMEN','Trinidad','59134620921',-14.65983,-64.8047,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1293','Farmacia chavez','Trinidad','59171124379',-14.83380,-64.9077,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1293','Farmacia El Carmen "Central"','Trinidad','No tiene',-14.83380,-64.9730,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1292','Farmacias San�Agust�n','�Arenales 219, Sucre','No tiene',-18.85168,-65.1933,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1292','Farmacia "Potosi"','Tarapaca # 280, Sucre','No tiene',-18.82471,-65.2737,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1292','Drogueria Natural�Sucre','Plaza 25 de Mayo N�2, Sucre','�4 6454619',-18.74306,-65.2720,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1292','Farmacorp - Sucursal�Sucre','Sucre','78500224',-18.83666,-65.2943,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1292','Farmacia San�Silvestre','Av. Ostria Gutierrez 353, Sucre','No tiene',-18.81227,-65.3107,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1291','BOTICA BUENAS NUEVAS - TIRAQUE','C. COMERCIO','No tiene',-17.39073,-66.1563,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1291','BOTICA CRUZ BLANCA - LAS CUADRAS','C. JUAN JOS� CARRASCO # 0578','�4328039',-17.39073,-66.1563,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1291','BOTICA ETERAZAMA - CARRASCO','CARRASCO','No tiene',-17.39073,-66.1563,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1291','BOTICA SAN MART�N DE PORRES - CHAPARE','CHAPARE','No tiene',-17.39073,-66.1563,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1291','BOTICA SAN SALVADOR - TIRAQUE','AV. PANAMERICANA','No tiene',-17.39073,-66.1563,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1936','Farmacias Bolivia','�Avenida 16 de Julio N� 1473, La Paz','2 2331838',-16.50381,-68.1313,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1936','Farmacia Arce','Av. Arce','2 2432421',-16.50991,-68.1237,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1936','Super Farmacia�Virgen de Copacabana','Lado Cotel, Zona Central','No tiene',-16.49692,-68.1368,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1936','Farmacias Ch�vez -�Obrajes','Av.Hernando Siles','2 2776577',-16.52879,-68.1009,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1936','Farmacia Gloria','Av Ballivi�n','�2 2770770',-16.53554,-68.0822,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1937','Farmacorp - Sucursal Oruro 2','Av Villarroel, Oruro','No tiene',-17.92328,-67.0955,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1937','Farmacia San Jorge','Bol�var, Oruro','No tiene',-17.94894,-67.1062,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1937','Farmacias Chavez, Suc. 6 de octubre','6056, 6 de Octubre, Oruro','No tiene',-17.92046,-67.1035,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1937','Farmacia Santa Marta','Bol�var, Oruro','3 5251784',-17.88314,-67.1223,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1937','Farmacia "Virgen de Chaguaya"','6 de Octubre, Oruro','77152110',-17.92046,-67.1035,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1938','FARMA VERDE - AV. LUIS SALAZAR DE LA VEGA','Av. Luis Salazar De La Vega Esq. Alm. Braun S/N','9782565',-11.02121,-68.7649,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1938','FARMACIA ALIMAR - AV. 9 DE FEBRERO','Av. 9 de Febrero Km 3 frente a Noreste Gas','8423541',-11.02121,-68.7649,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1938','FARMACIA CAROLINA - AV. 9 DE FEBRERO','Av. 9 de Febrero # 199','8423497',-11.02121,-68.7649,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1938','FARMACIA MAR�A AUXILIADORA - AV. FERN�NDEZ MOLINA','Av. Fern�ndez Molina # 105','8422066',-11.2121,-68.7649,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1938','FARMACIA REBEZZON - AV. 27 DE MAYO','Av. 27 de Mayo','8424373',-11.02121,-68.7649,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1939','Farmacia " San Silvestre "','�pasaje boulevard #3, Villa Imperial de Potos�','6222392',-19.46992,-65.7354,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1939','Farmacia Cristo De Las Americas','Villa Imperial de Potos�','No tiene',-19.46992,-65.7354,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1939','Farmacias "Econ�mica"','Villa Imperial de Potos�','No tiene',-19.46992,-65.7354,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1939','Farmacia Noelia','Villa Imperial de Potos�','No tiene',-19.46992,-65.7354,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1939','FARMACIA GESSBA','Villa Imperial de Potos�','No tiene',-19.46992,-65.7354,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1940','Farmacia Ca�oto','Cuellar, Santa Cruz de la Sierra','3 3338348',-17.61023,-63.2216,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1940','Farmacia Ch�vez sucursal 2 de Agosto 8vo anillo','Octavo Anillo, Santa Cruz de la Sierra','70884623',-17.43963,-63.1901,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1940','HP Medical Punto de Venta Rafael Pe�a - Insumos medicos','Calle Rafael Pe�a # 250 entre Espa�a y, 21 De Mayo','3344779',-17.59962,-63.1447,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1940','Farmacia Lavoisier','Santa Cruz de la Sierra','No tiene',-17.48616,-63.1447,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1940','Farmacias Bolivia','Avenida Ca�oto','No tiene',-17.63502,-63.2326,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1941','FARMA PLUS - CALLE BOLIVAR','C. Bolivar # 751 esq. Juan Misael Saracho','6665900',-21.51683,-64.7297,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1941','FARMACIA 3 DE AGOSTO - AV. MEJILLONES','Av. Mejillones # 2045 entre Pando y 4 de Julio','6675039',-21.51683,-64.7297,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1941','FARMACIA 8 DE JUNIO - AV. PANAMERICANA','Av. Panamericana # 4027 esq. Av. Sim�n Bolivar','6665942',-21.51683,-64.7297,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1941','FARMACIA ALEANA - AV. 6 DE AGOSTO','Av. 6 de Agosto casie esq. H. De La Independencia','6668820',-21.51683,-64.7297,NOW(),1,'192.168.1.18',NOW());
INSERT INTO pharmacy(id_department,name,location,phone_number,lat,lng,tx_date,tx_id_administrator,tx_host,tx_update) VALUES ('BOL1941','FARMACIA ANA LLANQUE G. - AV. LOS MOLLES','Av. Los Molles # 1718','6668962',-21.51683,-64.7297,NOW(),1,'192.168.1.18',NOW());
