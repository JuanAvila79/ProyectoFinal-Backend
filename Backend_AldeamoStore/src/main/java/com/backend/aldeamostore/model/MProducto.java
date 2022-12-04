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

    private Long Id;
    private Long categoriaId;
    private Long proveedorId;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
    private String images;
    private int count;
    private float rate;
    private Float descuento;
    private boolean status;

    public MProducto() {
    }

    public MProducto(Long Id, Long categoriaId, Long proveedorId, String title, float price, String description, String category, String image, String images, int count, float rate, Float descuento, boolean status) {
        this.Id = Id;
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.images = images;
        this.count = count;
        this.rate = rate;
        this.descuento = descuento;
        this.status = status;
    }

    public MProducto(Producto entity_product) {
        this.Id = entity_product.getId();
        this.categoriaId = entity_product.getCategoriaId();
        this.proveedorId = entity_product.getProveedorId();
        this.title = entity_product.getTitle();
        this.price = entity_product.getPrice();
        this.description = entity_product.getDescription();
        this.category = entity_product.getCategory();
        this.image = entity_product.getImage();
        this.images = entity_product.getImages();
        this.count = entity_product.getCount();
        this.rate = entity_product.getRate();
        this.descuento = entity_product.getDescuento();
        this.status = entity_product.isStatus();
    }

}
