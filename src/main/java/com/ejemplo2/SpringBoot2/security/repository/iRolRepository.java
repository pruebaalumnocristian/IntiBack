package com.ejemplo2.SpringBoot2.security.repository;

import com.ejemplo2.SpringBoot2.security.entity.Rol;
import com.ejemplo2.SpringBoot2.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
