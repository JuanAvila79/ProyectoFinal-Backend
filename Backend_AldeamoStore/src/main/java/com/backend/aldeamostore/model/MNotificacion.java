/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Notificacion;
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

public class MNotificacion {

    private Long notificacionId;
    private Long tipoNotificacionId;
    private Long canalId;
    private Long userId;
    private String asunto;
    private boolean status;

    public MNotificacion() {
    }

    public MNotificacion(Long notificacionId, Long tipoNotificacionId, Long canalId, Long userId, String asunto, boolean status) {
        this.notificacionId = notificacionId;
        this.tipoNotificacionId = tipoNotificacionId;
        this.canalId = canalId;
        this.userId = userId;
        this.asunto = asunto;
        this.status = status;
    }
    
    public MNotificacion(Notificacion entity_notificacion) {
        this.notificacionId = entity_notificacion.getNotificacionId();
        this.tipoNotificacionId = entity_notificacion.getTipoNotificacionId();
        this.canalId = entity_notificacion.getCanalId();
        this.userId = entity_notificacion.getUserId();
        this.asunto = entity_notificacion.getAsunto();
        this.status = entity_notificacion.isStatus();
    }

}
