package org.gerald.suarez.web.rest;

import org.gerald.suarez.domain.Usuario;
import org.gerald.suarez.repository.PermisoRepository;
import org.gerald.suarez.repository.RolRepository;
import org.gerald.suarez.repository.UsuarioRepository;
import org.gerald.suarez.service.UsuarioService;
import org.gerald.suarez.web.rest.dto.ManagedUsuarioDTO;
import org.gerald.suarez.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Usuario.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioResource {

    private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private UsuarioService usuarioService;

    @Inject
    private PermisoRepository permisoRepository;

    @Inject
    private RolRepository rolRepository;

    /**
     * POST  /usuarios : Create a new usuario.
     *
     * @param managedUsuarioDTO the usuario to create
     * @return the ResponseEntity with status 201 (Created) and with body the new usuario, or with status 400 (Bad Request) if the usuario has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/usuarios",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> createUsuario(@RequestBody ManagedUsuarioDTO managedUsuarioDTO) throws URISyntaxException {
        log.debug("REST request to save Usuario : {}", managedUsuarioDTO);
        if (usuarioRepository.findOneByLogin(managedUsuarioDTO.getLogin()).isPresent()) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert("userManagement", "userexists", "Login already in use"))
                    .body(null);
        }
        Usuario usuario = usuarioService.createUser(managedUsuarioDTO);
        return ResponseEntity.created(new URI("/api/usuarios/" + usuario.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("usuario", usuario.getId().toString()))
                .body(usuario);
    }

    /**
     * PUT  /usuarios : Updates an existing usuario.
     *
     * @param managedUsuarioDTO the usuario to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated usuario,
     * or with status 400 (Bad Request) if the usuario is not valid,
     * or with status 500 (Internal Server Error) if the usuario couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
//    @RequestMapping(value = "/usuarios",
//            method = RequestMethod.PUT,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Usuario> updateUsuario(@RequestBody ManagedUsuarioDTO managedUsuarioDTO) throws URISyntaxException {
//        log.debug("REST request to update Usuario : {}", managedUsuarioDTO);
//
//        Optional<Usuario> existingUser = usuarioRepository.findOneByLogin(managedUsuarioDTO.getLogin());
//        if (existingUser.isPresent() && (!existingUser.get().getId().equals(managedUsuarioDTO.getId()))) {
//            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("userManagement", "emailexists", "E-mail already in use")).body(null);
//        }
//        existingUser = usuarioRepository.findOneByLogin(managedUsuarioDTO.getLogin());
//        if (existingUser.isPresent() && (!existingUser.get().getId().equals(managedUsuarioDTO.getId()))) {
//            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("userManagement", "userexists", "Login already in use")).body(null);
//        }
//
//        return usuarioRepository
//                .findOneById(managedUsuarioDTO.getId())
//                .map(usuario -> {
//                    Empleado empleado = new Empleado();
//                    empleado.setNombre(managedUsuarioDTO.getNombre());
//                    empleado.setApellidoPaterno(managedUsuarioDTO.getApellidoPaterno());
//                    empleado.setApellidoMaterno(managedUsuarioDTO.getApellidoMaterno());
//                    empleado.setSexo(managedUsuarioDTO.getSexo());
//                    empleado.setNacionalidad(managedUsuarioDTO.getNacionalidad());
//                    empleado.setProfesion(managedUsuarioDTO.getProfesion());
//                    empleado.setFechaAlta(LocalDate.parse(managedUsuarioDTO.getFechaAlta().toString(), DateTimeFormatter.ISO_DATE));
//                    empleado.setCi(managedUsuarioDTO.getCi());
//
//                    usuario.setEmpleado(empleado);
//
//                    usuario.setLogin(managedUsuarioDTO.getLogin());
//                    usuario.setPassword(managedUsuarioDTO.getPassword());
//
//                    Rol rol = rolRepository.findOne(managedUsuarioDTO.getRolId());
//                    usuario.setRol(rol);
//                    return ResponseEntity.ok()
//                            .headers(HeaderUtil.createAlert("A user is updated with identifier " + managedUsuarioDTO.getLogin(), managedUsuarioDTO.getLogin()))
//                            .body(usuarioRepository.findOne(managedUsuarioDTO.getId()));
//                })
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
//
//    }

    /**
     * GET  /usuarios : get all the usuarios.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of usuarios in body
     */
    @RequestMapping(value = "/usuarios",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getAllUsuarios() {
        log.debug("REST request to get all Usuarios");
        return usuarioRepository.findAll();
    }

    /**
     * GET  /usuarios/:id : get the "id" usuario.
     *
     * @param id the id of the usuario to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the usuario, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/usuarios/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        log.debug("REST request to get Usuario : {}", id);
        Usuario usuario = usuarioRepository.findOne(id);
        return Optional.ofNullable(usuario)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /usuarios/:id : delete the "id" usuario.
     *
     * @param id the id of the usuario to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/usuarios/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        log.debug("REST request to delete Usuario : {}", id);
        usuarioRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("usuario", id.toString())).build();
    }

}
