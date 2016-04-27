package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Usuario;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Usuario entity.
 */

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
