package com.examenfinal.medicos.application;

import com.examenfinal.medicos.domain.service.MedicoService;

public class DeleteMedicoUseCase {
    private final MedicoService medicoService;

    public DeleteMedicoUseCase(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public void execute(int id) {
        medicoService.deleteMedico(id);
    }

}
