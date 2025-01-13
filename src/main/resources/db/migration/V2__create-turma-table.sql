CREATE TABLE turmas (
    id SERIAL PRIMARY KEY, -- Gera IDs automaticamente
    nome VARCHAR(50) NOT NULL UNIQUE, -- Nome da turma, único
    numero_sala INT NOT NULL UNIQUE, -- Número da sala, único
    capacidade INT NOT NULL, -- Capacidade máxima de alunos
    qtd_alunos INT DEFAULT 0, -- Quantidade atual de alunos
    CONSTRAINT check_capacidade_max CHECK (qtd_alunos <= capacidade) -- Valida que qtd_alunos não exceda capacidade
);
