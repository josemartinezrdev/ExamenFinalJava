package com.examenfinal.medicos.application;

import com.examenfinal.medicos.domain.entity.Medico;
import com.examenfinal.medicos.domain.service.MedicoService;

public class UpdateMedicoUseCase {
    private final MedicoService medicoService;

    public UpdateMedicoUseCase(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public void execute(Medico medico) {
        medicoService.updateMedico(medico);
    }
}
