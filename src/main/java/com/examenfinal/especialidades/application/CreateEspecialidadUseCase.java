package com.examenfinal.especialidades.application;

import com.examenfinal.especialidades.domain.entity.Especialidad;
import com.examenfinal.especialidades.domain.service.EspecialidadService;

public class CreateEspecialidadUseCase {
    private final EspecialidadService especialidadService;

    public CreateEspecialidadUseCase(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(Especialidad especialidad) {
        especialidadService.createEspecialidad(especialidad);
    }
}
