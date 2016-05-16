package org.gerald.suarez.service;

import org.gerald.suarez.domain.EntidadPublica;
import org.gerald.suarez.domain.Proyecto;
import org.gerald.suarez.repository.EntidadPublicaRepository;
import org.gerald.suarez.repository.ProyectoRepository;
import org.gerald.suarez.web.rest.dto.ProyectoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class ProyectoService {

    @Inject
    private ProyectoRepository proyectoRepository;

    @Inject
    private EntidadPublicaRepository entidadPublicaRepository;

    public Proyecto createProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setNoControl(proyectoDTO.getNoControl());
        proyecto.setModalidad(proyectoDTO.getModalidad());

        EntidadPublica entidadPublica = entidadPublicaRepository.findOne(proyectoDTO.getEntidadPublicaId());
        proyecto.setEntidadPublica(entidadPublica);
        return proyectoRepository.save(proyecto);
    }
}
