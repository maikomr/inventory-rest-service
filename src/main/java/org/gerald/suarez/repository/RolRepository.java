package org.gerald.suarez.repository;

import org.gerald.suarez.domain.Rol;

import org.springframework.data.jpa.repository.*;

import java.util.List;


public interface RolRepository extends JpaRepository<Rol,Long> {

}
