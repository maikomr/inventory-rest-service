package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Proyecto;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Proyecto entity.
 */
public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {

}
