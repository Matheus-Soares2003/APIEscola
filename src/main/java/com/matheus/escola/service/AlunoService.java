package com.matheus.escola.service;

import com.matheus.escola.DTO.AlunoRequestDTO;
import com.matheus.escola.DTO.AlunoResponseDTO;
import com.matheus.escola.DTO.TurmaResponseDTO;
import com.matheus.escola.model.Aluno;
import com.matheus.escola.model.Turma;
import com.matheus.escola.repository.AlunoRepository;
import com.matheus.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoRequest) throws RuntimeException {

        Turma turma = turmaRepository.findById(alunoRequest.turmaID())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Aluno aluno = new Aluno();
        aluno.setNome(alunoRequest.nome());
        aluno.setRa(alunoRequest.ra());
        aluno.setDataNascimento(alunoRequest.dataNascimento());
        aluno.setTurma(turma);

        Aluno alunoCriado =  alunoRepository.save(aluno);

        return new AlunoResponseDTO(
                alunoCriado.getId(),
                alunoCriado.getNome(),
                alunoCriado.getRa(),
                alunoCriado.getDataNascimento(),
                new TurmaResponseDTO(turma.getId(), turma.getNome(), turma.getNumeroSala())
        );

    }

    public List<AlunoResponseDTO> listarAlunos(){

        List<AlunoResponseDTO> alunos = alunoRepository.findAll()
                .stream()
                .map(aluno -> new AlunoResponseDTO(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getRa(),
                        aluno.getDataNascimento(),
                        new TurmaResponseDTO(aluno.getTurma().getId(), aluno.getTurma().getNome(), aluno.getTurma().getNumeroSala())
                ))
                .toList();

        return alunos;
    }
}
