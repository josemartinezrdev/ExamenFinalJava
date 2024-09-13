package com.examenfinal.pacientes.application;

import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

public class UpdatePacienteUseCase {
    private final PacienteService pacienteService;

    public UpdatePacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public void execute(Paciente paciente) {
        pacienteService.updatePaciente(paciente);
    }
}
