package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Formulario;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Formulario entity.
 */
public interface FormularioRepository extends JpaRepository<Formulario,Long> {

}
