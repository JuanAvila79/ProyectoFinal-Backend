/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.addresConverter;
import com.backend.aldeamostore.entity.Addres;
import com.backend.aldeamostore.model.MAddres;
import com.backend.aldeamostore.repository.addresRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("AddresService")
public class addresService {

    @Autowired
    @Qualifier("AddresRepository")
    private addresRepository addresRepository;

    @Autowired
    @Qualifier("AddresConverter")
    private addresConverter addresConverter;

    public MAddres findAddres(MAddres addres) {
        MAddres model_addres = addresConverter.converterEntityToModel(addresRepository.findByUserId(addres.getUserId()));
        return model_addres;
    }

    public boolean create(MAddres addres) {
        try {
            addresRepository.save(addresConverter.converterModelToEntity(addres));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(MAddres addres) {
        try {
            if(addresRepository.existsByUserId(addres.getUserId())){
                Addres entity_addres = addresRepository.findByUserId(addres.getUserId());
                entity_addres.setUserId(addres.getUserId());
                entity_addres.setPais(addres.getPais());
                entity_addres.setCiudad(addres.getCiudad());
                entity_addres.setDepartamento(addres.getDepartamento());
                entity_addres.setMunicipio(addres.getMunicipio());
                entity_addres.setDireccion(addres.getDireccion());
                entity_addres.setCasa(addres.getCasa());
                entity_addres.setApartamento(addres.getApartamento());
                addresRepository.save(entity_addres);
                return true;
            }else{
                return false;
            }         
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean delete(MAddres addres){
        try {
            if(addresRepository.existsByUserId(addres.getUserId())){
                Addres entity_addres = addresRepository.findByUserId(addres.getUserId());
                addresRepository.deleteById(entity_addres.getDireccionId());
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
