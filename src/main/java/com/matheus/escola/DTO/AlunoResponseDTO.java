package com.matheus.escola.DTO;

import com.matheus.escola.model.Turma;
import java.time.LocalDate;

public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String ra;
    private LocalDate dataNascimento;
    private Long turmaId;

    public AlunoResponseDTO(Long id, String nome, String ra, LocalDate dataNascimento, Long turmaId) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.dataNascimento = dataNascimento;
        this.turmaId = turmaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}
