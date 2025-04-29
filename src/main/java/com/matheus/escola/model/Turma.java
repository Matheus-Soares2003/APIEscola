package com.matheus.escola.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name="numero_sala", nullable = false, unique = true)
    private int numeroSala;

    @Column(name="capacidade", nullable = false)
    private int capacidade;

    @Column(name="qtd_alunos", nullable = false)
    private int qtdAlunos;

    @OneToMany(mappedBy = "turma")
    @JsonManagedReference
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma")
    private List<HorarioTurma> horariosTurmas;

    public Turma(Long id, String nome, int numeroSala, int capacidade, int qtdAlunos, List<Aluno> alunos, List<HorarioTurma> horariosTurmas) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        this.qtdAlunos = qtdAlunos;
        this.alunos = alunos;
        this.horariosTurmas = horariosTurmas;
    }

    public Turma() {
    }

    public Turma(Long id, String nome, int numeroSala, int capacidade, int qtdAlunos) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        this.qtdAlunos = qtdAlunos;
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

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<HorarioTurma> getHorariosTurmas() {
        return horariosTurmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
