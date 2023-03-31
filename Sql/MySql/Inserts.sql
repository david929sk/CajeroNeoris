
-- Insertar registros en la tabla persona
INSERT INTO persona (nombre, genero, edad, identificacion, direccion, telefono)
VALUES ('Jose Lema', 'M', 30, '1234567890', 'Otavalo sn y principal', '098254785'),
       ('Marianela Montalvo', 'F', 25, '0987654321', 'Amazonas y NNUU', '097548965'),
       ('Juan Osorio', 'M', 35, '1029384756', '13 junio y Equinoccial', '098874587');

-- Insertar registros en la tabla cliente
INSERT INTO cliente (persona_id, contrasena, estado)
VALUES (1, '1234', 'Activo'),
       (2, '5678', 'Activo'),
       (3, '1245', 'Activo');
	   
-- Insertar registros en la tabla cuenta
INSERT INTO cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado)
VALUES
    ('478758', 'Ahorro', 2000, 'Activo'),
    ('225487', 'Corriente', 100, 'Activo'),
    ('495878', 'Ahorro', 0, 'Activo'),
    ('496825', 'Ahorro', 540, 'Activo');