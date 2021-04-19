drop trigger if  exists tg_insert_h_day_country ;
drop trigger if  exists tg_update_h_day_country;
drop trigger if  exists tg_insert_h_day_department ;
drop trigger if  exists tg_update_h_day_department;
drop trigger if  exists tg_insert_h_day_municipality ;
drop trigger if  exists tg_update_h_day_municipality;

DELIMITER |
CREATE TRIGGER tg_insert_h_day_country
AFTER INSERT ON day_country
FOR EACH ROW
BEGIN
	INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_day_country
AFTER UPDATE ON day_country
FOR EACH ROW
BEGIN
	INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`actives`,`deaths`,`recovered`,`vaccine`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.new_cases,NEW.actives,NEW.deaths,NEW.recovered,NEW.vaccine,NOW(),NEW.tx_host,NOW());
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
CREATE TRIGGER tg_update_total_municipality
    AFTER UPDATE ON day_municipality
    FOR EACH ROW
BEGIN
    UPDATE DEPARTMENT
END;
|
DELIMITER ;