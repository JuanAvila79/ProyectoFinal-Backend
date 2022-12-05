/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.TipoNotificacion;
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

public class MTipoNotificacion {

    private Long tipoNotificacionId;
    private String descripcion;
    private boolean status;

    public MTipoNotificacion() {
    }

    public MTipoNotificacion(Long tipoNotificacionId, String descripcion, boolean status) {
        this.tipoNotificacionId = tipoNotificacionId;
        this.descripcion = descripcion;
        this.status = status;
    }

    public MTipoNotificacion(TipoNotificacion tipo_notificacion) {
        this.tipoNotificacionId = tipo_notificacion.getTipoNotificacionId();
        this.descripcion = tipo_notificacion.getDescripcion();
        this.status = tipo_notificacion.isStatus();
    }

}
