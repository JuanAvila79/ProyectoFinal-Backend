/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.rolConverter;
import com.backend.aldeamostore.entity.Rol;
import com.backend.aldeamostore.model.MRol;
import com.backend.aldeamostore.repository.rolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Service("RolService")
public class rolService {
//    private static final Logger logger = Logger.getLogger(rolService.class);

    @Autowired
    @Qualifier("RolRepository")
    private rolRepository rolRepository;

    @Autowired
    @Qualifier("RolConverter")
    private rolConverter rol_Converter;

    public List<MRol> listAll() {
        return rol_Converter.converterList(rolRepository.findAll());
    }

    public boolean crear(MRol rol) {
        try {
            rolRepository.save(rol_Converter.converterModelToEntity(rol));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean existsRol(MRol rol) {
        try {
            if (rolRepository.findByDescripcion(rol.getDescripcion()).getStatus() == true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public MRol update(MRol rol) {
        try {
            Long id = rol.getRolId();
            if (rolRepository.existsById(rol.getRolId())) {
                Rol model_rol = rolRepository.getReferenceById(id);
                model_rol.setDescripcion(rol.getDescripcion());
                model_rol.setStatus(rol.isStatus());
                rolRepository.save(model_rol);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(rol);
        return rol;
    }

    public boolean findByID(Long rol) {
        if (!rolRepository.findById(rol).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long rol) {
        rolRepository.deleteById(rol);
        return true;
    }

}
