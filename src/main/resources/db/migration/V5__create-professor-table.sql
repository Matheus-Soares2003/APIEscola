CREATE TABLE professores(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefone VARCHAR(25) UNIQUE NOT NULL,
    materia_id BIGINT NOT NULL,
    FOREIGN KEY (materia_id) REFERENCES materias (id)
);