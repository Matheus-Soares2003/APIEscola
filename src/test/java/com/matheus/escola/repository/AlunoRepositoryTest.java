package com.matheus.escola.repository;

import com.matheus.escola.model.Aluno;
import com.matheus.escola.model.Turma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Test
    @DisplayName("Deve retornar um aluno com sucesso!")
    void findByRaShouldReturnSuccessfully() {
        // Criando uma turma
        Turma turma = new Turma();
        turma.setNome("Turma B");
        turma.setNumeroSala(102);
        turma.setCapacidade(30);
        turma.setQtdAlunos(0);
        turmaRepository.save(turma);

        // Criando um aluno
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        aluno.setRa("RA987654");
        aluno.setDataNascimento(LocalDate.of(2004, 5, 20));
        aluno.setTurma(turma);
        alunoRepository.save(aluno);

        // Buscando o aluno pelo RA
        Optional<Aluno> foundAluno = alunoRepository.findByRa("RA987654");

        // Validando os resultados
        assertTrue(foundAluno.isPresent());
        assertEquals(aluno.getNome(), foundAluno.get().getNome());
        assertEquals(aluno.getRa(), foundAluno.get().getRa());
    }
}