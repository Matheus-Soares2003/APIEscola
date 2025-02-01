package com.matheus.escola.controller;

import com.matheus.escola.DTO.AlunoResponseDTO;
import com.matheus.escola.model.Aluno;
import com.matheus.escola.model.Turma;
import com.matheus.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(){

        List<AlunoResponseDTO> alunos = alunoRepository.findAll()
                .stream()
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getRa(),
                        aluno.getDataNascimento(),
                        aluno.getTurma().getId()
                ))
                .toList();

        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(alunos);
    }

}
