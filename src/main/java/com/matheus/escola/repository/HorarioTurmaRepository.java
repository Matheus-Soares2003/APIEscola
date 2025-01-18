package com.matheus.escola.repository;

import com.matheus.escola.model.HorarioTurma;
import com.matheus.escola.model.HorarioTurmaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioTurmaRepository extends JpaRepository<HorarioTurma, HorarioTurmaId> {
}
