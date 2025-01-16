package com.matheus.escola.repository;

import com.matheus.escola.model.Materia;
import com.matheus.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    List<Professor> findByMateriaId(Long materiaId);

    @Query(value="SELECT p.* FROM professores p JOIN materias m ON p.materia_id = m.id WHERE UPPER(m.nome) LIKE UPPER(:materiaNome%)", nativeQuery = true)
    List<Professor> findByMateriaNome(@Param("materiaNome") String materiaNome);

}
