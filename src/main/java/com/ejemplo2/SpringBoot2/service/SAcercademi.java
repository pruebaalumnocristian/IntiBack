package com.ejemplo2.SpringBoot2.service;

import com.ejemplo2.SpringBoot2.entity.Acercademi;
import com.ejemplo2.SpringBoot2.repository.RAcercademi;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercademi {

    @Autowired
    RAcercademi rAcercademi;

    public List<Acercademi> list() {
        return rAcercademi.findAll();
    }

    public Optional<Acercademi> getOne(int id) {
        return rAcercademi.findById(id);
    }

    public Optional<Acercademi> getByNombreE(String nombreE) {
        return rAcercademi.findByNombreE(nombreE);
    }

    public void save(Acercademi acercademi) {
        rAcercademi.save(acercademi);
    }

    public void delete(int id) {
        rAcercademi.deleteById(id);
    }

    public boolean existsById(int id) {
        return rAcercademi.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {
        return rAcercademi.existsByNombreE(nombreE);
    }
}
