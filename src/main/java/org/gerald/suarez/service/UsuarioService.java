package org.gerald.suarez.service;

import org.gerald.suarez.domain.Empleado;
import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.domain.Rol;
import org.gerald.suarez.domain.Usuario;
import org.gerald.suarez.repository.EmpleadoRepository;
import org.gerald.suarez.repository.PermisoRepository;
import org.gerald.suarez.repository.RolRepository;
import org.gerald.suarez.repository.UsuarioRepository;
import org.gerald.suarez.web.rest.dto.ManagedUsuarioDTO;
import org.gerald.suarez.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    private final Logger log = LoggerFactory.getLogger(UsuarioService.class);

//    @Inject
//    private PasswordEncoder passwordEncoder;

    @Inject
    private UsuarioRepository userRepository;

    @Inject
    private EmpleadoRepository empleadoRepository;

    @Inject
    private RolRepository rolRepository;

    @Inject
    private PermisoRepository permisoRepository;

    public Usuario createUser(ManagedUsuarioDTO managedUserDTO) {
        Usuario usuario = new Usuario();
        usuario.setLogin(managedUserDTO.getLogin());
        usuario.setPassword(managedUserDTO.getPassword());

        Rol rol = rolRepository.findOne(managedUserDTO.getRolId());
        usuario.setRol(rol);

        Empleado empleado = new Empleado();
        empleado.setNombre(managedUserDTO.getNombre());
        empleado.setApellidoPaterno(managedUserDTO.getApellidoPaterno());
        empleado.setApellidoMaterno(managedUserDTO.getApellidoMaterno());
        empleado.setSexo(managedUserDTO.getSexo());
        empleado.setNacionalidad(managedUserDTO.getNacionalidad());
        empleado.setProfesion(managedUserDTO.getProfesion());
        empleado.setFechaAlta(LocalDate.parse(managedUserDTO.getFechaAlta().toString(), DateTimeFormatter.ISO_DATE));
        empleado.setCi(managedUserDTO.getCi());

        empleadoRepository.save(empleado);

        usuario.setEmpleado(empleado);
//        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
//        user.setPassword(encryptedPassword);

        return userRepository.save(usuario);
    }
}
