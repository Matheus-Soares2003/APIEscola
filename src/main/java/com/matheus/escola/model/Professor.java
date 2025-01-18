package com.matheus.escola.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", length = 255, nullable = false)
    private String nome;

    @Column(name="email", unique = true, nullable = false)
    private String email;

    @Column(name="telefone", length = 25)
    private String telefone;

    @ManyToOne
    @JoinColumn(name="materia_id", nullable = false)
    private Materia materia;

    @OneToMany(mappedBy = "professor")
    private List<HorarioTurma> horariosTurmas;

    public Professor(Long id, String nome, String email, String telefone, Materia materia, List<HorarioTurma> horariosTurmas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.materia = materia;
        this.horariosTurmas = horariosTurmas;
    }

    public Professor() {
    }

    public Professor(Long id, String nome, String email, String telefone, Materia materia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.materia = materia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<HorarioTurma> getHorariosTurmas() {
        return horariosTurmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
