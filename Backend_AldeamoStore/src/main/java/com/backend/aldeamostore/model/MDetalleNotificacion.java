/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.DetalleNotificacion;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Data
@Getter
@Setter

public class MDetalleNotificacion {

    private Long idDetalleNotificacion;
    private String contenido;
    private Date fecha;
    private int notificacionId;

    public MDetalleNotificacion() {
    }
    
    public MDetalleNotificacion(Long idDetalleNotificacion, String contenido, Date fecha, int notificacionId) {
        this.idDetalleNotificacion = idDetalleNotificacion;
        this.notificacionId = notificacionId;
        this.fecha = fecha;
        this.contenido = contenido;

    }

    public MDetalleNotificacion(DetalleNotificacion detalle_notificacion) {
        this.idDetalleNotificacion = detalle_notificacion.getIdDetalleNotificacion();
        this.notificacionId = detalle_notificacion.getNotificacionId();
        this.fecha = detalle_notificacion.getFecha();
        this.contenido = detalle_notificacion.getContenido();

    }

}
