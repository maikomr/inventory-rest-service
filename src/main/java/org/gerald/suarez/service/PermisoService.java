package org.gerald.suarez.service;

import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.domain.Usuario;
import org.gerald.suarez.repository.FormularioRepository;
import org.gerald.suarez.repository.PermisoRepository;
import org.gerald.suarez.repository.UsuarioRepository;
import org.gerald.suarez.web.rest.dto.PermisoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
@Transactional
public class PermisoService {

    @Inject
    private PermisoRepository permisoRepository;
    @Inject
    private FormularioRepository formularioRepository;
    @Inject
    private UsuarioRepository usuarioRepository;

    public Permiso createPermiso(PermisoDTO permisoDTO) {
        Permiso permiso = new Permiso();
        permiso.setVer(permisoDTO.getVer());
        permiso.setCrear(permisoDTO.getCrear());
        permiso.setModificar(permisoDTO.getModificar());
        permiso.setAutorizar(permisoDTO.getAutorizar());
        permiso.setFormulario(formularioRepository.findOne(permisoDTO.getFormularioId()));
        permiso.setUsuario(usuarioRepository.findOne(permisoDTO.getUsuarioId()));
        permiso = permisoRepository.save(permiso);
        return permiso;
    }
}
