DELIMITER $

CREATE PROCEDURE `INSERTAR_GRUPO` (
	IN pi_nombre VARCHAR(250),
    IN pi_sigla VARCHAR(45),
    OUT ps_idGrupo INT)
BEGIN
	insert into grupo (nombre, sigla) values (pi_nombre, pi_sigla);
    SET ps_idGrupo = @@last_insert_id; 
END$
