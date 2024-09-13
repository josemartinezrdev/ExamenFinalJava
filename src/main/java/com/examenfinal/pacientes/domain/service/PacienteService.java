package com.examenfinal.pacientes.domain.service;

import java.util.List;

import com.examenfinal.pacientes.domain.entity.Paciente;

public interface PacienteService {
    public void createPaciente(Paciente paciente);

    public void updatePaciente(Paciente paciente);

    public void deletePaciente(int id);

    public List<Paciente> findAllPacientes();

    public Paciente findByIdPaciente(int id);
}
