/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.detalleCompraConverter;
import com.backend.aldeamostore.model.MDetalleCompra;
import com.backend.aldeamostore.repository.detalleCompraRepository;
import com.backend.aldeamostore.repository.productoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Service("DetalleCompraService")
public class detalleCompraService {

    @Autowired
    @Qualifier("DetalleCompraRepository")
    private detalleCompraRepository detallecompraRepository;

    @Autowired
    @Qualifier("CompraService")
    private compraService compraService;

    @Autowired
    @Qualifier("ProductoRepository")
    private productoRepository productoRepository;

    @Autowired
    @Qualifier("DetalleCompraConverter")
    private detalleCompraConverter detallecompraConverter;

    public boolean create(MDetalleCompra detalleCompra) {
        try {
            detallecompraRepository.save(detallecompraConverter.converterModelToEntity(detalleCompra));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<MDetalleCompra> getList() {
        return detallecompraConverter.converterList(detallecompraRepository.findAll());
    }

    public boolean update(MDetalleCompra detalleCompra) {
        return true;
    }

    public boolean delete(Long id) {
        try {
            if (detallecompraRepository.existsById(id)) {
                detallecompraRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean existsCompra(long compra_id) {
        return compraService.existById(compra_id);
    }

    public boolean existsProduct(long producto_id) {
        return productoRepository.existsById(producto_id);
    }

    public boolean existsDetalleCompra(long detalleCompra_id) {
        System.out.println(detalleCompra_id);
        return detallecompraRepository.existsById(detalleCompra_id);
    }

}
