drop trigger if  exists tg_insert_h_day_country ;
drop trigger if  exists tg_update_h_day_country;

DELIMITER |
CREATE TRIGGER tg_insert_h_day_world
AFTER INSERT ON day_world
FOR EACH ROW
BEGIN
	INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`deaths`,`recovered`,`vaccine`,`accumulated`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.new_cases,NEW.deaths,NEW.recovered,NEW.vaccine,NEW.accumulated,NEW.tx_date,NEW.tx_host,NEW.tx_update);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER tg_update_h_day_world
AFTER UPDATE ON day_world
FOR EACH ROW
BEGIN
	INSERT INTO `h_day_country`(`id_day_country`,`id_country`,`date`,`new_cases`,`deaths`,`recovered`,`vaccine`,`accumulated`,`tx_date`,`tx_host`,`tx_update`) VALUES ( NEW.id_day_country,NEW.id_country,NEW.date,NEW.new_cases,NEW.deaths,NEW.recovered,NEW.vaccine,NEW.accumulated,NOW(),NEW.tx_host,NEW.tx_update);
	END;
|
DELIMITER ;
