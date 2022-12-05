/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Canal;
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

public class MCanal {

    private Integer canalId;
    private String descripcion;
    private boolean status;

    public MCanal() {
    }

    public MCanal(Integer canalId, String descripcion, boolean status) {
        this.canalId = canalId;
        this.descripcion = descripcion;
        this.status = status;
    }

    public MCanal(Canal canal) {
        this.canalId = canal.getCanalId();
        this.descripcion = canal.getDescripcion();
        this.status = canal.isStatus();
    }

}
