/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Producto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Data
@Getter
@Setter
public class MProducto {

    private Long productoId;
    private int cantidad;
    private String descripcion;
    private Float descuento;
    private String marca;
    private String modelo;
    private String nombre;
    private Float precio;
    private boolean status;
    private String titulo;
    private long categoriaId;
    private int proveedorId;

    public MProducto() {
    }

    public MProducto(Producto producto) {
        this.productoId = producto.getProductoId();
        this.cantidad = producto.getCantidad();
        this.descripcion = producto.getDescripcion();
        this.descuento = producto.getDescuento();
        this.marca = producto.getMarca();
        this.modelo = producto.getModelo();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.status = producto.isStatus();
        this.titulo = producto.getTitulo();
        this.categoriaId = producto.getCategoriaId();
        this.proveedorId = producto.getProveedorId();
    }

    public MProducto(Long productoId, int cantidad, String descripcion, Float descuento, String marca, String modelo, String nombre, Float precio, boolean status, String titulo, long categoriaId, int proveedorId) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.precio = precio;
        this.status = status;
        this.titulo = titulo;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
    }

}
