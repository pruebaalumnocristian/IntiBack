package com.ejemplo2.SpringBoot2.repository;

import com.ejemplo2.SpringBoot2.entity.Acercademi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercademi extends JpaRepository<Acercademi, Integer>{
    
    public Optional<Acercademi> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);

    
    
}
