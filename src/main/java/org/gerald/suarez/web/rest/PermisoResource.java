package org.gerald.suarez.web.rest;

import org.gerald.suarez.domain.Permiso;
import org.gerald.suarez.repository.PermisoRepository;
import org.gerald.suarez.service.PermisoService;
import org.gerald.suarez.web.rest.dto.PermisoDTO;
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
 * REST controller for managing Permiso.
 */
@RestController
@RequestMapping("/api")
public class PermisoResource {

    private final Logger log = LoggerFactory.getLogger(PermisoResource.class);

    @Inject
    private PermisoRepository permisoRepository;

    @Inject
    private PermisoService permisoService;

    /**
     * POST  /permisos : Create a new permiso.
     *
     * @param permisoDTO the permiso to create
     * @return the ResponseEntity with status 201 (Created) and with body the new permiso, or with status 400 (Bad Request) if the permiso has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/permisos",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Permiso> createPermiso(@RequestBody PermisoDTO permisoDTO) throws URISyntaxException {
        log.debug("REST request to save Permiso : {}", this);
        Permiso permiso = permisoService.createPermiso(permisoDTO);
        if (permiso != null) {
            return ResponseEntity.created(new URI("/api/permisos/" + permiso.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert("permiso", permiso.getId().toString()))
                    .body(permiso);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * PUT  /permisos : Updates an existing permiso.
     *
     * @param permiso the permiso to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated permiso,
     * or with status 400 (Bad Request) if the permiso is not valid,
     * or with status 500 (Internal Server Error) if the permiso couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
//    @RequestMapping(value = "/permisos",
//        method = RequestMethod.PUT,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Permiso> updatePermiso(@RequestBody PermisoDTO permisoDTO) throws URISyntaxException {
//        log.debug("REST request to update Permiso : {}", permisoDTO);
//        if (permiso.getId() == null) {
//            return createPermiso(permisoDTO);
//        }
//        Permiso result = permisoRepository.save(permiso);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert("permiso", permisoDTO.getId().toString()))
//            .body(result);
//    }

    /**
     * GET  /permisos : get all the permisos.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of permisos in body
     */
    @RequestMapping(value = "/permisos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Permiso> getAllPermisos() {
        log.debug("REST request to get all Permisos");
        List<Permiso> permisos = permisoRepository.findAll();
        return permisos;
    }

    /**
     * GET  /permisos/:id : get the "id" permiso.
     *
     * @param id the id of the permiso to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the permiso, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/permisos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Permiso> getPermiso(@PathVariable Long id) {
        log.debug("REST request to get Permiso : {}", id);
        Permiso permiso = permisoRepository.findOne(id);
        return Optional.ofNullable(permiso)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /permisos/:id : delete the "id" permiso.
     *
     * @param id the id of the permiso to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/permisos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePermiso(@PathVariable Long id) {
        log.debug("REST request to delete Permiso : {}", id);
        permisoRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("permiso", id.toString())).build();
    }

}
