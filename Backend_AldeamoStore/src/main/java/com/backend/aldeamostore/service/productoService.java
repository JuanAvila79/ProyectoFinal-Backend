/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.productoConverter;
import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.repository.productoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Service("ProductoService")
public class productoService {
    
        @Autowired
    @Qualifier("ProductoRepository")
    private productoRepository productRepository;

    @Autowired
    @Qualifier("ProductoConverter")
    private productoConverter productConverter;
    
    
    
        public List<MProducto> listAll() {
        return productConverter.converterList(productRepository.findAll());
    }
    
}
