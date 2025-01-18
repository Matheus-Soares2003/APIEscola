package com.matheus.escola.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class HorarioTurmaId implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "dia_semana", nullable = false)
    private DiaSemana diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "professor_id", nullable = false)
    private Integer professorId;

    public HorarioTurmaId(DiaSemana diaSemana, LocalTime horaInicio, Integer professorId) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.professorId = professorId;
    }

    public HorarioTurmaId() {
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

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioTurmaId that = (HorarioTurmaId) o;
        return diaSemana == that.diaSemana && Objects.equals(horaInicio, that.horaInicio) && Objects.equals(professorId, that.professorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diaSemana, horaInicio, professorId);
    }
}
