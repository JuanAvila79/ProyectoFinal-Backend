/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Notificacion;
import com.backend.aldeamostore.model.MNotificacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Component("NotificacionConverter")
public class notificacionConverter {

    public List<MNotificacion> converterList(List<Notificacion> notificacion) {
        List<MNotificacion> model_notificacion= new ArrayList<>();
        for (Notificacion entity_notificacion : notificacion) {
            model_notificacion.add(new MNotificacion(entity_notificacion));
        }
        return model_notificacion;
    }

    public MNotificacion converterEntityToModel(Notificacion notificacion) {
        MNotificacion model_notificacion = new MNotificacion(notificacion);
        return model_notificacion;
    }

    public Notificacion converterModelToEntity(MNotificacion notificacion) {
        Notificacion entity_notificacion = new Notificacion(notificacion);
//        entitycompra.setCompraId(compra.getCompraId());
//        entitycompra.setProductoId(compra.getProductoId());
//        entitycompra.setCantidad(compra.getCantidad());
//        entitycompra.setMonto(compra.getMonto());
//        entitycompra.setIva(compra.getIva());
//        entitycompra.setDescuento(compra.getDescuento());
//        entitycompra.setTotal(compra.getTotal());
        return entity_notificacion;
    }

}
