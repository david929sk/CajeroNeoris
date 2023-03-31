-- Crear la tabla persona
CREATE TABLE persona (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Clave primaria autoincremental
    nombre VARCHAR(255) NOT NULL, -- Nombre no puede ser nulo
    genero ENUM('M', 'F') NOT NULL, -- Género debe ser 'M' o 'F' y no puede ser nulo
    edad INT NOT NULL CHECK (edad >= 0), -- Edad no puede ser nula y debe ser mayor o igual a cero
    identificacion VARCHAR(255) NOT NULL UNIQUE, -- Identificación no puede ser nula y debe ser única
    direccion VARCHAR(255) NOT NULL, -- Dirección no puede ser nula
    telefono VARCHAR(255) NOT NULL -- Teléfono no puede ser nulo
);

-- Crear la tabla cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Clave primaria autoincremental
    persona_id BIGINT NOT NULL UNIQUE, -- Referencia a la tabla persona (no puede ser nula y debe ser única)
    contrasena VARCHAR(255) NOT NULL, -- Contraseña no puede ser nula
    estado VARCHAR(255) NOT NULL, -- Estado no puede ser nulo
    FOREIGN KEY (persona_id) REFERENCES persona(id) -- Clave foránea a la tabla persona
);

-- Crear la tabla cuenta
CREATE TABLE cuenta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Clave primaria autoincremental
    numero_cuenta VARCHAR(255) NOT NULL UNIQUE, -- Número de cuenta no puede ser nulo y debe ser único
    tipo_cuenta ENUM('Ahorro', 'Corriente') NOT NULL, -- Tipo de cuenta debe ser 'Ahorro' o 'Corriente' y no puede ser nulo
    saldo_inicial DECIMAL(10, 2) NOT NULL CHECK (saldo_inicial >= 0), -- Saldo inicial no puede ser nulo y debe ser mayor o igual a cero
    estado VARCHAR(255) NOT NULL, -- Estado no puede ser nulo
    cliente_id INT NOT NULL, -- Referencia a la tabla cliente (no puede ser nula)
    FOREIGN KEY (cliente_id) REFERENCES cliente(id) -- Clave foránea a la tabla cliente
);
-- Crear la tabla movimiento
CREATE TABLE movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Clave primaria autoincremental
    fecha DATE NOT NULL, -- Fecha no puede ser nula
    tipo_movimiento ENUM('Depósito', 'Retiro') NOT NULL, -- Tipo de movimiento debe ser 'Depósito' o 'Retiro' y no puede ser nulo
    valor DECIMAL(10, 2) NOT NULL,-- Valor no puede ser nulo
    saldo DECIMAL(10, 2) NOT NULL,-- Saldo no puede ser nulo y debe ser mayor o igual a cero
    cuenta_id BIGINT NOT NULL, -- Referencia a la tabla cuenta (no puede ser nula)
    FOREIGN KEY (cuenta_id) REFERENCES cuenta(id) -- Clave foránea a la tabla cuenta
);

-- Crear un índice en la columna fecha de la tabla movimiento para mejorar el rendimiento de las consultas
CREATE INDEX idx_movimiento_fecha ON movimiento(fecha);