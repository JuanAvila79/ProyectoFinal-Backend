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
            if (rolRepository.findByDescripcion(rol.getDescripcion()) == null) {
                rol.setStatus(true);
                rolRepository.save(rol_Converter.converterModelToEntity(rol));
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean existsRol(MRol rol) {
        try {
            return rolRepository.findByDescripcion(rol.getDescripcion()).isStatus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(MRol rol) {
        try {
            if (rolRepository.existsById(rol.getRolId())) {
                Rol model_rol = rolRepository.getReferenceById(rol.getRolId());
                model_rol.setDescripcion(rol.getDescripcion());
                model_rol.setStatus(rol.isStatus());
                rolRepository.save(model_rol);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
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
