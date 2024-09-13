package com.examenfinal.pacientes.application;

import com.examenfinal.pacientes.domain.service.PacienteService;

public class DeletePacienteUseCase {
    private final PacienteService pacienteService;

    public DeletePacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public void execute(int id) {
        pacienteService.deletePaciente(id);
    }
}
