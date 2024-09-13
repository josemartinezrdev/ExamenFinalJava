package com.examenfinal.pacientes.application;

import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

public class CreatePacienteUseCase {
    private final PacienteService pacienteService;

    public CreatePacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public void execute(Paciente paciente) {
        pacienteService.createPaciente(paciente);
    }
}
