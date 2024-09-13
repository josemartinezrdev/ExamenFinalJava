package com.examenfinal.especialidades.application;

import com.examenfinal.especialidades.domain.entity.Especialidad;
import com.examenfinal.especialidades.domain.service.EspecialidadService;

public class FindByIdEspecialidadUseCase {
    private final EspecialidadService especialidadService;

    public FindByIdEspecialidadUseCase(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public Especialidad execute(int id) {
        return especialidadService.findByIdEspecialidad(id);
    }
}
