package com.matheus.escola.DTO;

import com.matheus.escola.model.Turma;
import java.time.LocalDate;

public record AlunoResponseDTO (
    Long id,
    String nome,
    String ra,
    LocalDate dataNascimento,
    Long turmaId
){

    public AlunoResponseDTO(Long id, String nome, String ra, LocalDate dataNascimento, Long turmaId) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.dataNascimento = dataNascimento;
        this.turmaId = turmaId;
    }
}
