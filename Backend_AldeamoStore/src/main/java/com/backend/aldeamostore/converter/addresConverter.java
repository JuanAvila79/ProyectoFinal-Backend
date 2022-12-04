/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Addres;
import com.backend.aldeamostore.model.MAddres;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Component("AddresConverter")
public class addresConverter {
    
    public List<MAddres> converterList(List<Addres> addres) {
        List<MAddres> model_addres = new ArrayList<>();
        for (Addres entiry_addres : addres) {
            model_addres.add(new MAddres(entiry_addres));
        }
        return model_addres;
    }

    public MAddres converterEntityToModel(Addres addres) {
        MAddres model_addres = new MAddres(addres);
        return model_addres;
    }

    public Addres converterModelToEntity(MAddres addres) {
        Addres entity_addres = new Addres(addres);
//        entityAddresl.setDireccionId(addres.getDireccionId());
//        entityAddresl.setUserId(addres.getUserId());
//        entityAddresl.setPais(addres.getPais());
//        entityAddresl.setCiudad(addres.getCasa());
//        entityAddresl.setDepartamento(addres.getDepartamento());
//        entityAddresl.setMunicipio(addres.getMunicipio());
//        entityAddresl.setDireccion(addres.getDireccion());
//        entityAddresl.setCasa(addres.getCasa());
//        entityAddresl.setApartamento(addres.getApartamento());
        return entity_addres;
    }
    
}
