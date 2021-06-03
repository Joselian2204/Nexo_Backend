USE covid_db;

drop trigger if  exists tg_insert_h_day_country ;
drop trigger if  exists tg_update_h_day_country;
drop trigger if  exists tg_insert_h_day_department ;

drop trigger if  exists tg_update_h_day_department;
drop trigger if  exists tg_insert_h_day_municipality ;
drop trigger if  exists tg_update_h_day_municipality;

drop trigger if  exists tg_update_total_department;
drop trigger if  exists tg_update_total_country;
drop trigger if  exists tg_update_total_municipality;

drop trigger if  exists tg_update_total_department;
drop trigger if  exists tg_update_total_country;
drop trigger if  exists tg_update_total_municipality;

drop trigger if  exists c;
drop trigger if  exists tg_update_delete_total_country;
drop trigger if  exists tg_update_delete_total_municipality;


DELIMITER |
CREATE TRIGGER tg_insert_h_day_country
    AFTER INSERT ON day_country
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_day_country
    AFTER UPDATE ON day_country
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_insert_h_day_department
    AFTER INSERT ON day_department
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_department`(`id_day_department`,`id_department`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_department,NEW.id_department,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_day_department
    AFTER UPDATE ON day_department
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_department`(`id_day_department`,`id_department`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_department,NEW.id_department,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;


DELIMITER |
CREATE TRIGGER tg_insert_h_day_municipality
    AFTER INSERT ON day_municipality
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_municipality`(`id_day_municipality`,`id_municipality`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_municipality,NEW.id_municipality,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_day_municipality
    AFTER UPDATE ON day_municipality
    FOR EACH ROW
BEGIN
    INSERT INTO `h_day_municipality`(`id_day_municipality`,`id_municipality`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_municipality,NEW.id_municipality,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER  tg_update_total_department
    AFTER Insert ON day_department
    FOR EACH ROW
BEGIN
    UPDATE department
    SET cases = cases + new.new_cases, deaths = deaths + new.deaths, recovered = recovered + new.recovered, vaccine = vaccine + new.vaccine
    WHERE id_department = new.id_department;
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER  tg_update_total_country
    AFTER Insert ON day_country
    FOR EACH ROW
BEGIN
    UPDATE country
    SET cases = cases + new.cases, deaths = deaths + new.deaths, recovered = recovered + new.recovered, vaccine = vaccine + new.vaccine
    WHERE id_country = new.id_country;
END;
|
DELIMITER ;
DELIMITER |
CREATE TRIGGER  tg_update_total_municipality
    AFTER Insert ON day_municipality
    FOR EACH ROW
BEGIN
    UPDATE country
    SET cases = cases + new.new_cases, deaths = deaths + new.deaths, recovered = recovered + new.recovered, vaccine = vaccine + new.vaccine
    WHERE id_municipality= new.id_municipality;
END;
|
DELIMITER ;


DELIMITER |
CREATE TRIGGER  tg_update_delete_total_department
    AFTER delete ON day_department
    FOR EACH ROW
BEGIN
    UPDATE department
    SET cases = cases - OLD.new_cases, deaths = deaths - OLD.deaths, recovered = recovered - OLD.recovered, vaccine = vaccine - OLD.vaccine
    WHERE id_department = OLD.id_department;
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER  tg_update_delete_total_country
    AFTER delete ON day_country
    FOR EACH ROW
BEGIN
    UPDATE country
    SET cases = cases - OLD.cases, deaths = deaths - OLD.deaths, recovered = recovered - OLD.recovered, vaccine = vaccine - OLD.vaccine
    WHERE id_country = OLD.id_country;
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER  tg_update_delete_total_municipality
    AFTER delete ON day_municipality
    FOR EACH ROW
BEGIN
    UPDATE municipality
    SET cases = cases - OLD.new_cases, deaths = deaths - OLD.deaths, recovered = recovered - OLD.recovered, vaccine = vaccine - OLD.vaccine
    WHERE id_municipality= OLD.id_municipality;
END;
|
DELIMITER ;
use covid_db;
drop trigger if exists tg_insert_h_administrator;
drop trigger if exists tg_update_h_administrator;
drop trigger if exists tg_update_h_hospital;
drop trigger if exists tg_insert_h_hospital;
drop trigger if exists tg_update_h_pharmacy;
drop trigger if exists tg_insert_h_pharmacy;

DELIMITER |
CREATE TRIGGER tg_insert_h_administrator
    AFTER INSERT ON administrator
    FOR EACH ROW
BEGIN
    INSERT INTO `h_administrator`(`id_h_administrator`,`id_administrator`,`password`,`name`,`last_name`,`email`,`status`,`tx_date`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_administrator,NEW.password,NEW.name,NEW.last_name,NEW.email,NEW.status,NEW.tx_id_user,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_administrator
    AFTER UPDATE ON administrator
    FOR EACH ROW
BEGIN
    INSERT INTO `h_administrator`(`id_h_administrator`,`id_administrator`,`password`,`name`,`last_name`,`email`,`status`,`tx_id_user`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_administrator,NEW.password,NEW.name,NEW.last_name,NEW.email,NEW.status,NEW.tx_id_user,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_insert_h_hospital
    AFTER INSERT ON hospital
    FOR EACH ROW
BEGIN
    INSERT INTO `h_hospital`(`id_h_hospital`,`id_hospital`,`id_department`,`name`,`location`,`phone_number`,`lat`,`lng`,`status`,`tx_date`,`tx_id_administrator`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_hospital,NEW.id_department,NEW.name,NEW.location,NEW.phone_number,NEW.lat,NEW.lng,NEW.status,NOW(),NEW.tx_id_administrator,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_hospital
    AFTER UPDATE ON hospital
    FOR EACH ROW
BEGIN
    INSERT INTO `h_hospital`(`id_h_hospital`,`id_hospital`,`id_department`,`name`,`location`,`phone_number`,`lat`,`lng`,`status`,`tx_date`,`tx_id_administrator`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_hospital,NEW.id_department,NEW.name,NEW.location,NEW.phone_number,NEW.lat,NEW.lng,NEW.status,NEW.tx_date,NEW.tx_id_administrator,NEW.tx_host,NOW());
END;
|
DELIMITER ;
DELIMITER |
CREATE TRIGGER tg_insert_h_pharmacy
    AFTER INSERT ON pharmacy
    FOR EACH ROW
BEGIN
    INSERT INTO `h_pharmacy`(`id_h_pharmacy`,`id_pharmacy`,`id_department`,`name`,`location`,`phone_number`,`lat`,`lng`,`status`,`tx_date`,`tx_id_administrator`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_pharmacy,NEW.id_department,NEW.name,NEW.location,NEW.phone_number,NEW.lat,NEW.lng,NEW.status,NOW(),NEW.tx_id_administrator,NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_pharmacy
    AFTER UPDATE ON pharmacy
    FOR EACH ROW
BEGIN
    INSERT INTO `h_pharmacy`(`id_h_pharmacy`,`id_pharmacy`,`id_department`,`name`,`location`,`phone_number`,`lat`,`lng`,`status`,`tx_date`,`tx_id_administrator`,`tx_host`,`tx_update`) VALUES (NULL,NEW.id_pharmacy,NEW.id_department,NEW.name,NEW.location,NEW.phone_number,NEW.lat,NEW.lng,NEW.status, NEW.tx_date,NEW.tx_id_administrator,NEW.tx_host,NOW());
END;
|
DELIMITER ;

