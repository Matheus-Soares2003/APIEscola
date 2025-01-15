package com.matheus.escola.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="ra", length = 10, nullable = false, unique = true)
    private String ra;

    @Column(name="data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name="id_turma", nullable = false)
    private Turma turma;

    public Aluno(Integer id, String nome, String ra, LocalDate dataNascimento, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.dataNascimento = dataNascimento;
        this.turma = turma;
    }

    public Aluno() {
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(nome, aluno.nome) && Objects.equals(ra, aluno.ra) && Objects.equals(dataNascimento, aluno.dataNascimento) && Objects.equals(turma, aluno.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ra, dataNascimento, turma);
    }
}
