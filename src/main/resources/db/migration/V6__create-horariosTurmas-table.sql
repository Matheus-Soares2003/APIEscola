CREATE TABLE horarios_turmas (
    dia_semana VARCHAR(15) NOT NULL,
    hora_inicio TIME NOT NULL,
    professor_id BIGINT NOT NULL,
    hora_termino TIME NOT NULL,
    turma_id BIGINT NOT NULL,
    PRIMARY KEY (dia_semana, hora_inicio, professor_id),

    FOREIGN KEY (professor_id) REFERENCES professores (id),
    FOREIGN KEY (turma_id) REFERENCES turmas (id) ON DELETE CASCADE
);
