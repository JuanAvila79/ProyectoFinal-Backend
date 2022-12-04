/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.proveedorConverter;
import com.backend.aldeamostore.model.MProveedor;
import com.backend.aldeamostore.repository.proveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("ProveedorService")
public class proveedorService {

    @Autowired
    @Qualifier("ProveedorRepository")
    private proveedorRepository proveedorRepository;

    @Autowired
    @Qualifier("ProveedorConverter")
    private proveedorConverter proveedorConverter;

    public boolean create(MProveedor proveedor) {
        try {
            proveedorRepository.save(proveedorConverter.converterModelToEntity(proveedor));
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
    public List<MProveedor> list() {
        return proveedorConverter.converterList(proveedorRepository.findAll());
    }

    public boolean update(MProveedor proveedor) {
        try {
            if(proveedorRepository.existsById(proveedor.getProveedorId())){
               proveedorRepository.save(proveedorConverter.converterModelToEntity(proveedor));
               return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(long proveedor_id) {
        try {
            if (proveedorRepository.existsById(proveedor_id)) {
                proveedorRepository.deleteById(proveedor_id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean findByName(String proveedor_name) {
        return proveedorRepository.existsByNombre(proveedor_name);
    }

    public boolean existProveedor(long proveedor_id) {
        return proveedorRepository.existsById(proveedor_id);
    }

}
