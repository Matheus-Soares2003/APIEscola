ALTER TABLE alunos
ADD CONSTRAINT fk_id_turma
FOREIGN KEY (id_turma) REFERENCES turmas (id)
ON DELETE RESTRICT;
