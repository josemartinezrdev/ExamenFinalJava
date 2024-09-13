package com.examenfinal.medicos.application;

import com.examenfinal.medicos.domain.entity.Medico;
import com.examenfinal.medicos.domain.service.MedicoService;

public class FindByIdMedicoUseCase {
    private final MedicoService medicoService;

    public FindByIdMedicoUseCase(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public Medico execute(int id) {
        return medicoService.findByIdMedico(id);
    }
}
