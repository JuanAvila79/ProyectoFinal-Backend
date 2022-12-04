/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Proveedor;
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

public class MProveedor {

    private Long proveedorId;
    private long celular;
    private String direccion;
    private String nombre;
    private String rut;
    private boolean status;
    private String web;

    public MProveedor() {
    }

    public MProveedor(Long proveedorId, long celular, String direccion, String nombre, String rut, boolean status, String web) {
        this.proveedorId = proveedorId;
        this.celular = celular;
        this.direccion = direccion;
        this.nombre = nombre;
        this.rut = rut;
        this.status = status;
        this.web = web;
    }

    public MProveedor(Proveedor proveedor) {
        this.proveedorId = proveedor.getProveedorId();
        this.celular = proveedor.getCelular();
        this.direccion = proveedor.getDireccion();
        this.nombre = proveedor.getNombre();
        this.rut = proveedor.getRut();
        this.web = proveedor.getWeb();
        this.status = proveedor.isStatus();
    }

}
