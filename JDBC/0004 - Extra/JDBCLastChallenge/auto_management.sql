CREATE TABLE Propietarios (
  id_propietario INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  email VARCHAR(100),
  telefono VARCHAR(15)
);

CREATE TABLE Autos (
  id_auto INT PRIMARY KEY AUTO_INCREMENT,
  marca VARCHAR(50),
  modelo VARCHAR(50),
  año INT,
  color VARCHAR(30),
  precio DECIMAL(10, 2),
  id_propietario INT,
  FOREIGN KEY (id_propietario) REFERENCES Propietarios(id_propietario)
);


CREATE TABLE Transacciones (
  id_transaccion INT PRIMARY KEY AUTO_INCREMENT,
  id_auto INT,
  fecha_transaccion DATE,
  tipo_transaccion VARCHAR(20),  -- 'compra' o 'venta'
  precio DECIMAL(10, 2),
  FOREIGN KEY (id_auto) REFERENCES Autos(id_auto)
);