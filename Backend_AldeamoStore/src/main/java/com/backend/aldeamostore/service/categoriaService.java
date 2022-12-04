/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.categoriaConverter;
import com.backend.aldeamostore.model.MCategoria;
import com.backend.aldeamostore.repository.categotiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("CategoriaService")
public class categoriaService {

    @Autowired
    @Qualifier("CategoriaRepository")
    private categotiaRepository categotiaRepository;

    @Autowired
    @Qualifier("CategoriaConverter")
    private categoriaConverter categoriaConverter;

    public boolean create(MCategoria categoria) {
        try {
            categotiaRepository.save(categoriaConverter.converterModelToEntity(categoria));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /** 
     * @return 
     * 
     * Metodo listAll en la clase Services
     *
     * Este Metodo retorna un listado de todos los productos existentes en la
     * base de datos, este metodo se apoya en la clase ConverterList, la cual
     * recibe una lista de tipo Entidad y la Convierte a un Modelo lista de tipo
     * MProduct
     */
    public List<MCategoria> list() {
        return categoriaConverter.converterList(categotiaRepository.findAll());
    }

    public boolean delete(long categoria_id) {
        try {
            if (categotiaRepository.existsById(categoria_id)) {
                categotiaRepository.deleteById(categoria_id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean findCategoriaByName(String categoria_name) {
        return categotiaRepository.existsByNombre(categoria_name);
    }
    
    public boolean existCategoria(long categoria_id){
        return categotiaRepository.existsById(categoria_id);
    }
}
