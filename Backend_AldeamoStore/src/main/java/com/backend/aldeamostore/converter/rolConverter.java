/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Rol;
import com.backend.aldeamostore.model.MRol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Component("RolConverter")
public class rolConverter {

    public List<MRol> converterList(List<Rol> rol) {
        List<MRol> modelRol = new ArrayList<>();
        for (Rol entityRol : rol) {
            modelRol.add(new MRol(entityRol));
        }
        return modelRol;
    }

    public MRol converterEntityToModel(Rol rol) {
        MRol modelRol = new MRol(rol);
        return modelRol;
    }

    public Rol converterModelToEntity(MRol rol) {
        Rol entityRol = new Rol(rol);
        entityRol.setDescripcion(rol.getDescripcion());
        entityRol.setStatus(rol.isStatus());
        return entityRol;
    }

}
