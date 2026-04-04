agrego los codigos de MySQL

Inscripciones:

CREATE TABLE inscripciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    id_participante INT,
    id_concurso INT
);
------------------------------------
Pagos:

CREATE TABLE pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME,
    monto DOUBLE
);
