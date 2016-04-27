package org.gerald.suarez.repositories;

import java.util.List;
import org.gerald.suarez.domain.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    List<Usuario> findByLogin(@Param("login") String login);
}
