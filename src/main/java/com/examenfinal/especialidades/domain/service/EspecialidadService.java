package com.examenfinal.especialidades.domain.service;

import com.examenfinal.especialidades.domain.entity.Especialidad;

public interface EspecialidadService {
    public void createEspecialidad(Especialidad especialidad);

    public void updateEspecialidad(Especialidad especialidad);

    public void deleteEspecialidad(int id);

    public Especialidad findByIdEspecialidad(int id);
}
