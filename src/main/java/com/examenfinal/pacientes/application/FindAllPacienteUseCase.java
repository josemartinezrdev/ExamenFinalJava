package com.examenfinal.pacientes.application;

import java.util.List;

import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

public class FindAllPacienteUseCase {
    private final PacienteService pacienteService;

    public FindAllPacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public List<Paciente> execute() {
        return pacienteService.findAllPacientes();
    }
}
