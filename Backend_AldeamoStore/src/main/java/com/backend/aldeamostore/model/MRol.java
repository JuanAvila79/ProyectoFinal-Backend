/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Rol;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
public class MRol {

    private Long rolId;
    private String descripcion;
    private boolean status;

    public MRol(Long rolId, String descripcion, boolean status) {
        this.rolId = rolId;
        this.descripcion = descripcion;
        this.status = status;
    }

    public MRol() {
    }

    public MRol(Rol rol) {
        this.rolId = rol.getRolId();
       this.descripcion = rol.getDescripcion();
        this.status = rol.isStatus();
    }


    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
