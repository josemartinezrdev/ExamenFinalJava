package com.examenfinal.especialidades.application;

import com.examenfinal.especialidades.domain.service.EspecialidadService;

public class DeleteEspecialidadUseCase {
    private final EspecialidadService especialidadService;

    public DeleteEspecialidadUseCase(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(int id) {
        especialidadService.deleteEspecialidad(id);
    }
}
