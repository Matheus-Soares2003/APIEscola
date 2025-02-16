package com.matheus.escola.controller;

import com.matheus.escola.DTO.TurmaResponseDTO;
import com.matheus.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> listarTurmas(){
        List<TurmaResponseDTO> turmas = service.listarTurmas();

        if (turmas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(turmas);
    }
}
