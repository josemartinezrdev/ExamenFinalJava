package com.examenfinal.especialidades.application;

import com.examenfinal.especialidades.domain.entity.Especialidad;
import com.examenfinal.especialidades.domain.service.EspecialidadService;

public class UpdateEspecialidadUseCase {
    private final EspecialidadService especialidadService;

    public UpdateEspecialidadUseCase(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(Especialidad especialidad) {
        especialidadService.updateEspecialidad(especialidad);
    }
}
