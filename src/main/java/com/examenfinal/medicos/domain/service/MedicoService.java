package com.examenfinal.medicos.domain.service;

import com.examenfinal.medicos.domain.entity.Medico;

public interface MedicoService {
    public void createMedico(Medico medico);

    public void updateMedico(Medico medico);

    public void deleteMedico(int id);

    public Medico findByIdMedico(int id);
}
