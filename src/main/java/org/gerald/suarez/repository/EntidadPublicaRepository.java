package org.gerald.suarez.repository;

import org.gerald.suarez.domain.EntidadPublica;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the EntidadPublica entity.
 */
public interface EntidadPublicaRepository extends JpaRepository<EntidadPublica,Long> {

}
