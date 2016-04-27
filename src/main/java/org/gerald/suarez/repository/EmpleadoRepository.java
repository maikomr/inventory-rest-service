package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Empleado;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Empleado entity.
 */
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

}
