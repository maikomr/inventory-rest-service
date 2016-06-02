package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Permiso;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Permiso entity.
 */
public interface PermisoRepository extends JpaRepository<Permiso,Long> {
}
