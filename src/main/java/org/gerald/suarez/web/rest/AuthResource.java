package org.gerald.suarez.web.rest;

import org.gerald.suarez.domain.Usuario;
import org.gerald.suarez.repository.UsuarioRepository;
import org.gerald.suarez.web.rest.dto.CredentialsDTO;
import org.gerald.suarez.web.rest.dto.UsuarioDTO;
import org.gerald.suarez.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * REST controller for managing login and logout.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthResource {

    private final Logger log = LoggerFactory.getLogger(AuthResource.class);

    @Inject
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> login(@RequestBody CredentialsDTO credentials) throws URISyntaxException {
        Optional<Usuario> existingUsuario = usuarioRepository.findOneByLogin(credentials.getLogin());
        if (existingUsuario.isPresent()) {
            if (existingUsuario.get().getPassword().equals(credentials.getPassword())) {
                return new ResponseEntity<>(existingUsuario.get(),
                        HeaderUtil.createAlert("Authentication success", "authsucceed"),
                        HttpStatus.OK);
            } else {
                return ResponseEntity.badRequest()
                        .headers(HeaderUtil.createFailureAlert("AuthManagement", "invalidpassword", "Invalid Password"))
                        .body(null);
            }
        } else {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert("AuthManagement", "invalidlogin", "Invalid Login"))
                    .body(null);
        }
    }
}
