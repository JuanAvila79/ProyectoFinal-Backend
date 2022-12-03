/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.compraConverter;
import com.backend.aldeamostore.entity.Compra;
import com.backend.aldeamostore.model.MCompra;
import com.backend.aldeamostore.repository.compraRepository;
import com.backend.aldeamostore.repository.userRepository;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("CompraService")
public class compraService {

    @Autowired
    @Qualifier("CompraRepository")
    private compraRepository compraRepository;

    @Autowired
    @Qualifier("UserRepository")
    private userRepository userRepository;

    @Autowired
    @Qualifier("CompraConverter")
    private compraConverter compraConverter;

    public List<MCompra> getList() {
        return compraConverter.converterList(compraRepository.findAll());
    }

    public boolean existById(Long id) {
        try {
            return compraRepository.existsById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Long id) {
        try {
            compraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean update(MCompra compra) {
        try {
            if (!compraRepository.findById(compra.getCompraId()).isEmpty()) {
                Compra entity_compra = compraRepository.findById(compra.getCompraId()).get();
                entity_compra.setUserId(compra.getUserId());
                entity_compra.setTotal(compra.getTotal());
                entity_compra.setStatus(compra.isStatus());
                compraRepository.save(entity_compra);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean create(MCompra compra) {
        try {
            java.util.Calendar calendarHoy = Calendar.getInstance();
            java.util.Date hoy = calendarHoy.getTime();
            Timestamp hoySql = new Timestamp(hoy.getTime());
            compra.setFecha(hoySql);
            compra.setStatus(true);
            compraRepository.save(compraConverter.converterModelToEntity(compra));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean existUser(MCompra compra){
        return !userRepository.findById(compra.getUserId()).isEmpty();
        
    }

}
