package com.matheus.escola.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "horarios_turmas")
public class HorarioTurma {

    @EmbeddedId
    private HorarioTurmaId id;

    @Column(name="dia_semana", nullable = false, insertable = false, updatable = false)
    private DiaSemana diaSemana;

    @Column(name="hora_inicio", nullable = false, insertable = false, updatable = false)
    private LocalTime horaInicio;

    @Column(name="hora_termino", nullable = false)
    private LocalTime horaTermino;

    @ManyToOne
    @JoinColumn(name="turma_id", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name="professor_id", nullable = false, insertable = false, updatable = false)
    private Professor professor;

    public HorarioTurma(HorarioTurmaId id, DiaSemana diaSemana, LocalTime horaInicio, LocalTime horaTermino, Turma turma, Professor professor) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.turma = turma;
        this.professor = professor;
    }

    public HorarioTurma() {
    }

    public HorarioTurmaId getId() {
        return id;
    }

    public void setId(HorarioTurmaId id) {
        this.id = id;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioTurma that = (HorarioTurma) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
