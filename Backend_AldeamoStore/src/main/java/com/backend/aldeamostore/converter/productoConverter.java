/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Producto;
import com.backend.aldeamostore.model.MProducto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Component("ProductoConverter")
public class productoConverter {

    public List<MProducto> converterList(List<Producto> product) {
        List<MProducto> model_product = new ArrayList<>();
        for (Producto entity_product : product) {
            model_product.add(new MProducto(entity_product));
        }
        return model_product;
    }

    public MProducto converterEntityToModel(Producto producto) {
        MProducto model_product = new MProducto(producto);
        return model_product;
    }

    public Producto converterModelToEntity(MProducto producto) {
        Producto entity_product = new Producto(producto);
//        entityProduct.setProductoId(model_product.getProductoId());
//        entityProduct.setCategoriaId(model_product.getCategoriaId());
//        entityProduct.setProveedorId(model_product.getProveedorId());
//        entityProduct.setTitulo(model_product.getTitulo());
//        entityProduct.setNombre(model_product.getNombre());
//        entityProduct.setDescripcion(model_product.getDescripcion());
//        entityProduct.setMarca(model_product.getMarca());
//        entityProduct.setModelo(model_product.getModelo());
//        entityProduct.setPrecio(model_product.getPrecio());
//        entityProduct.setCantidad(model_product.getCantidad());
//        entityProduct.setDescuento(model_product.getDescuento());
//        entityProduct.setStatus(model_product.isStatus());
        return entity_product;
    }

}
