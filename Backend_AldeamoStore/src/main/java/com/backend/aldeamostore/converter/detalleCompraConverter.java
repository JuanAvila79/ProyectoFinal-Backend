/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.DetalleCompra;
import com.backend.aldeamostore.model.MDetalleCompra;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Avila Meza
 */
@Component("DetalleCompraConverter")
public class detalleCompraConverter {

    public List<MDetalleCompra> converterList(List<DetalleCompra> detalleCompra) {
        List<MDetalleCompra> model_deteallecompra = new ArrayList<>();
        for (DetalleCompra entity_detallecompra : detalleCompra) {
            model_deteallecompra.add(new MDetalleCompra(entity_detallecompra));
        }
        return model_deteallecompra;
    }

    public MDetalleCompra converterEntityToModel(DetalleCompra detalleCompra) {
        MDetalleCompra model_deteallecompra = new MDetalleCompra(detalleCompra);
        return model_deteallecompra;
    }

    public DetalleCompra converterModelToEntity(MDetalleCompra compra) {
        DetalleCompra entity_detallecompra = new DetalleCompra(compra);
//        entitycompra.setCompraId(compra.getCompraId());
//        entitycompra.setProductoId(compra.getProductoId());
//        entitycompra.setCantidad(compra.getCantidad());
//        entitycompra.setMonto(compra.getMonto());
//        entitycompra.setIva(compra.getIva());
//        entitycompra.setDescuento(compra.getDescuento());
//        entitycompra.setTotal(compra.getTotal());
        return entity_detallecompra;
    }
}
