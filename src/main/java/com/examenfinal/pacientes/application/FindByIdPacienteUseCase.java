package com.examenfinal.pacientes.application;

import com.examenfinal.pacientes.domain.entity.Paciente;
import com.examenfinal.pacientes.domain.service.PacienteService;

public class FindByIdPacienteUseCase {
    private final PacienteService pacienteService;

    public FindByIdPacienteUseCase(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public Paciente execute(int id) {
        return pacienteService.findByIdPaciente(id);
    }
}
