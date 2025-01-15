package com.matheus.escola.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name="numero_sala", nullable = false, unique = true)
    private int numeroSala;

    @Column(name="capacidade", nullable = false)
    private int capacidade;

    @Column(name="qtd_alunos", nullable = false)
    private int qtdAlunos;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(Integer id, String nome, int numeroSala, int capacidade, int qtdAlunos, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        this.qtdAlunos = qtdAlunos;
        this.alunos = alunos;
    }

    public Turma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return numeroSala == turma.numeroSala && capacidade == turma.capacidade && qtdAlunos == turma.qtdAlunos && Objects.equals(id, turma.id) && Objects.equals(nome, turma.nome) && Objects.equals(alunos, turma.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, numeroSala, capacidade, qtdAlunos, alunos);
    }
}