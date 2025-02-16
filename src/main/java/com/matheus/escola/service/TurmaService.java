package com.matheus.escola.service;

import com.matheus.escola.DTO.TurmaResponseDTO;
import com.matheus.escola.model.Turma;
import com.matheus.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaResponseDTO> listarTurmas(){
        return turmaRepository.findAll()
                .stream()
                .map(t -> new TurmaResponseDTO(
                        t.getId(),
                        t.getNome(),
                        t.getNumeroSala(),
                        t.getCapacidade(),
                        t.getQtdAlunos()
                ))
                .toList();
    }

}
