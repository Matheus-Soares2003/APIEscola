package com.matheus.escola.repository;

import com.matheus.escola.model.Materia;
import com.matheus.escola.model.Professor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class ProfessorRepositoryTest {

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Test
    @DisplayName("Deve retornar professores que lecionam a matéria especifica")
    void findByMateriaNomeDeveRetornarTodosProfessores() {
        //ARRANGE
        Materia materia1 = new Materia();
        materia1.setNome("Quimica");
        materiaRepository.save(materia1);

        Materia materia2 = new Materia();
        materia2.setNome("Historia");
        materiaRepository.save(materia2);

        Professor professor1 = new Professor();
        professor1.setNome("Fernando");
        professor1.setEmail("fernandoquimica@gmail.com");
        professor1.setTelefone("(11)99998888");
        professor1.setMateria(materia1);

        Professor professor2 = new Professor();
        professor2.setNome("Jessica");
        professor2.setEmail("jessica@gmail.com");
        professor2.setTelefone("(11)22221111");
        professor2.setMateria(materia2);

        Professor professor3 = new Professor();
        professor3.setNome("Claudio");
        professor3.setEmail("claudio@outlook.com");
        professor3.setTelefone("(11)12345678");
        professor3.setMateria(materia1);

        Professor professor4 = new Professor();
        professor4.setNome("Tiana");
        professor4.setEmail("tiana@outlook.com");
        professor4.setTelefone("(11)87654321");
        professor4.setMateria(materia2);

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);
        professorRepository.save(professor4);

        //ACT
        List<Professor> resultProfessores = professorRepository.findByMateriaNome("quimica");

        //ASSERT
        assertEquals(2, resultProfessores.size());
        assertThat(resultProfessores).contains(professor1);
        assertThat(resultProfessores).contains(professor3);
        assertThat(resultProfessores).doesNotContain(professor2);
        assertThat(resultProfessores).doesNotContain(professor4);
    }

}