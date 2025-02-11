package com.matheus.escola.controller;

import com.matheus.escola.DTO.AlunoRequestDTO;
import com.matheus.escola.DTO.AlunoResponseDTO;
import com.matheus.escola.model.Aluno;
import com.matheus.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(){

        List<AlunoResponseDTO> alunos = service.listarAlunos();

        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(alunos);
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> criarAluno(@RequestBody AlunoRequestDTO alunoRequest){
        AlunoResponseDTO alunoResponse = service.criarAluno(alunoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoResponse);
    }

}
