
DROP DATABASE tramites_tecnm;

CREATE DATABASE tramites_tecnm;

USE tramites_tecnm;

CREATE TABLE alumnos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellido_paterno VARCHAR(255) NOT NULL,
    apellido_materno VARCHAR(255) NOT NULL,
    numero_control INT NOT NULL UNIQUE,
    correo VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    carrera VARCHAR(255) NOT NULL
);

CREATE TABLE tipos_archivo (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_archivo VARCHAR(255)  NOT NULL
);

CREATE TABLE archivos (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    alumno_id INT UNSIGNED NOT NULL,
    tipos_archivo_id INT UNSIGNED NOT NULL,
    ruta_archivo VARCHAR(255) NOT NULL,
    tamano_archivo INT NOT NULL,
    subido BOOLEAN NOT NULL DEFAULT false,
    aprovado BOOLEAN NOT NULL DEFAULT false,

    FOREIGN KEY (alumno_id) REFERENCES alumnos(id),
    FOREIGN KEY (tipos_archivo_id) REFERENCES tipos_archivo(id)
);

