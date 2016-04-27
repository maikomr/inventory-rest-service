package org.gerald.suarez.repository;

import org.gerald.suarez.domain.LinPedido;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the LinPedido entity.
 */
public interface LinPedidoRepository extends JpaRepository<LinPedido,Long> {

}
