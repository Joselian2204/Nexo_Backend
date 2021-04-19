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

USE covid_db_test;

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
CREATE TRIGGER  tg_update_delete_total_municipality
    AFTER delete ON day_municipality
    FOR EACH ROW
BEGIN
    UPDATE country
    SET cases = cases - OLD.new_cases, deaths = deaths - OLD.deaths, recovered = recovered - OLD.recovered, vaccine = vaccine - OLD.vaccine
    WHERE id_municipality= OLD.id_municipality;
END;
|
DELIMITER ;
