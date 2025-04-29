package com.matheus.escola.DTO;

import com.matheus.escola.model.Aluno;

import java.util.List;

public record TurmaResponseDTO(
        Long id,
        String nome,
        Integer numeroSala,
        Integer capacidadeMaxima,
        Integer quantidadeAlunos,
        List<Aluno> aluno
) {
}
