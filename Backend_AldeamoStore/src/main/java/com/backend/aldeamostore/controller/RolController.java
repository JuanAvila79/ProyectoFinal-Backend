/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MRol;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.rolService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@RestController
@RequestMapping("/aldeamostore/v1")
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:8080")
public class RolController {

    @Autowired
    @Qualifier("RolService")
    private rolService rol_Service;

    // Metodo para Listar todos los roles
    @GetMapping("/rol/list")
    public ResponseEntity< List<MRol>> list() {
        List<MRol> listRol = rol_Service.listAll();
        ResponseEntity<List<MRol>> reponseEntity = new ResponseEntity<>(listRol, HttpStatus.OK);
        return reponseEntity;
    }

    // Metodo para crear un rol  
    @PostMapping("/rol/create")
    public ResponseEntity create(@RequestBody MRol rol) {
        if (StringUtils.isBlank(rol.getDescripcion())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Campo Descripcion no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        if (rol_Service.crear(rol)) {
            return new ResponseEntity(new Message("Rol "+ rol.getDescripcion() +"creado exitosamente..."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("Rol no creado, el rol " + rol.getDescripcion() + " ya existe..."), HttpStatus.CONFLICT);
        }
    }

    // Metodo para actualizar un rol
    @PutMapping("/rol/update/")
    public ResponseEntity<MRol> update(@RequestBody MRol rol) {
        if (!rol_Service.findByID(rol.getRolId())) {
            return new ResponseEntity(new Message("El ID No. < " + rol.getRolId() + " > no existe en la base de datos..."), HttpStatus.BAD_REQUEST);
        } else {
            if ((rol.isStatus() != true) && (rol.isStatus() != false)){
                rol.setStatus(true);
            }
            if (rol_Service.update(rol)) {
                return new ResponseEntity(new Message("Rol actualizado exitosamente..."), HttpStatus.CREATED);
            } else {
                return new ResponseEntity(new Message("ha ocurrido un error interno, rol no actualizado.."), HttpStatus.CONFLICT);
            }
        }
    }

    // Metodo para eliminar un usuario en particular
    @DeleteMapping("/rol/delete/{id}")
    public ResponseEntity< MRol> delete(@PathVariable("id") Long id) {
        if (!rol_Service.findByID(id)) {
            return new ResponseEntity(new Message("Este Id no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            rol_Service.delete(id);
            return new ResponseEntity(new Message("Usuario Eliminado con exito.."), HttpStatus.OK);
        }
    }
}
