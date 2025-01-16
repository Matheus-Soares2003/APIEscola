package com.matheus.escola.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="telefone", length = 25)
    private String telefone;

    @ManyToOne
    @JoinColumn(name="materia_id", nullable = false)
    private Materia materia;

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
