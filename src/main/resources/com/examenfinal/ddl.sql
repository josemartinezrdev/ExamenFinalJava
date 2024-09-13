DROP DATABASE IF EXISTS examenfinaljava;
CREATE DATABASE examenfinaljava;
USE examenfinaljava;

CREATE TABLE pacientes(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    fechaNacimiento DATE,
    telefono VARCHAR(50),
    email VARCHAR(50),
    direccion VARCHAR(100),

    CONSTRAINT pk_id_paciente PRIMARY KEY (id)
);

CREATE TABLE especialidades(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    CONSTRAINT pk_id_esp PRIMARY KEY (id)
);

CREATE TABLE medicos(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    horaInicio VARCHAR(50),
    horaFin VARCHAR(50),
    idespecialidad INT,
    CONSTRAINT pk_id_medico PRIMARY KEY (id),
    CONSTRAINT fk_medicos_especialidades FOREIGN KEY (idespecialidad) REFERENCES especialidades (id)
);

CREATE TABLE cita(
    id INT AUTO_INCREMENT,
    fechaHora TIMESTAMP,
    estado VARCHAR(50),
    idpaciente INT,
    idmedico INT,

    CONSTRAINT pk_id_citas PRIMARY KEY (id),
    CONSTRAINT fk_citas_pacientes FOREIGN KEY (idpaciente) REFERENCES pacientes (id),
    CONSTRAINT fk_citas_medicos FOREIGN KEY (idmedico) REFERENCES medicos (id)
);