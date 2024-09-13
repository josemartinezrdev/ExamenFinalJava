package com.examenfinal.medicos.application;

import com.examenfinal.medicos.domain.entity.Medico;
import com.examenfinal.medicos.domain.service.MedicoService;

public class CreateMedicoUseCase {
    private final MedicoService medicoService;

    public CreateMedicoUseCase(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public void execute(Medico medico) {
        medicoService.createMedico(medico);
    }
}
