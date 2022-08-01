package com.ejemplo2.SpringBoot2.controller;
import com.ejemplo2.SpringBoot2.dto.dtoAcercademi;
import com.ejemplo2.SpringBoot2.entity.Acercademi;
import com.ejemplo2.SpringBoot2.security.controller.Mensaje;
import com.ejemplo2.SpringBoot2.service.SAcercademi;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercademi")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcercademi {
    @Autowired
    SAcercademi sAcercademi;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Acercademi>> list(){
        List<Acercademi> list = sAcercademi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Acercademi> getById(@PathVariable("id") int id){
        if(!sAcercademi.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Acercademi acercademi = sAcercademi.getOne(id).get();
        return new ResponseEntity(acercademi, HttpStatus.OK);
    }
            
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercademi.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercademi.delete(id);
        return new ResponseEntity(new Mensaje("No existe ADM"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercademi dtoacercademi){
        if(StringUtils.isBlank(dtoacercademi.getNombreE())){
            return new ResponseEntity(new Mensaje("No se agrego descripcion"), HttpStatus.BAD_REQUEST);
       }
       //if(sAcercademi.existsByNombreE(dtoacercademi.getNombreE())){
       //   return new ResponseEntity(new Mensaje("Ya existe descripcion"), HttpStatus.BAD_REQUEST);
       //}
        
        Acercademi acercademi = new Acercademi(dtoacercademi.getNombreE(), dtoacercademi.getDescripcionE());

        sAcercademi.save(acercademi);
     
        return new ResponseEntity(new Mensaje("Descripcion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercademi dtoacercademi){
        //if(!sAcercademi.existsById(id)){
        //    return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        //}
        //if(sAcercademi.existsByNombreE(dtoacercademi.getNombreE()) && sAcercademi.getByNombreE(dtoacercademi.getNombreE()).get().getId() != id){
        //    return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);            
        //}
        if(StringUtils.isBlank(dtoacercademi.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo esta vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Acercademi acercademi = sAcercademi.getOne(id).get();
        
        acercademi.setNombreE(dtoacercademi.getNombreE());
        acercademi.setDescripcionE(dtoacercademi.getDescripcionE());
        
        sAcercademi.save(acercademi);
        
        return new ResponseEntity(new Mensaje("Descripcion actualizada"), HttpStatus.OK);
    }
}
