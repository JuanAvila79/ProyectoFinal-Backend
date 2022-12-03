/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Compra;
import com.backend.aldeamostore.model.MCompra;
import com.backend.aldeamostore.repository.compraRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Component("CompraConverter")
public class compraConverter {

    @Autowired
    @Qualifier("CompraRepository")
    private compraRepository compraRepository;

    public List<MCompra> converterList(List<Compra> compra) {
        List<MCompra> model_compra = new ArrayList<>();
        for (Compra entity_compra : compra) {
            model_compra.add(new MCompra(entity_compra));
        }
        return model_compra;
    }

    public MCompra converterEntityToModel(Compra compra) {
        MCompra model_compra = new MCompra(compra);
        return model_compra;
    }

    public Compra converterModelToEntity(MCompra compra) {
        Compra entity_compra = new Compra(compra);
//        entitycompra.setCompraId(compra.getCompraId());
//        entitycompra.setUserId(compra.getUserId());
//        entitycompra.setFecha(compra.getFecha());
//        entitycompra.setTotal(entitycompra.getTotal());
//        entitycompra.setStatus(compra.isStatus());
        return entity_compra;
    }
}
