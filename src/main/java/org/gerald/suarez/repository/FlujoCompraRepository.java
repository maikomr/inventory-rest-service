package org.gerald.suarez.repository;

import org.gerald.suarez.domain.FlujoCompra;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the FlujoCompra entity.
 */
public interface FlujoCompraRepository extends JpaRepository<FlujoCompra,Long> {

}
