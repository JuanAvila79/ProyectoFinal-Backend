/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MCompra;
import com.backend.aldeamostore.model.MDetalleCompra;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.detalleCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:8080")
public class DetalleCompraController {

    @Autowired
    @Qualifier("DetalleCompraService")
    private detalleCompraService detallecompraService;

    /**
     * Método Create en la Clase ProductController.
     *
     * Este método expone una Api de tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones. se procede con la creación del producto.
     */
    @PostMapping("/detallecompra/create")
    public ResponseEntity create(@RequestBody MDetalleCompra detalle_compra) {

        if (!detallecompraService.existsCompra(detalle_compra.getCompraId())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  La compra con codigo (" + detalle_compra.getCompraId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (!detallecompraService.existsProduct(detalle_compra.getProductoId())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  El producto con codigo (" + detalle_compra.getProductoId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (detalle_compra.getCantidad() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  La cantidad es un dato entero y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getMonto().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El monto es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getIva().intValue() < 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El iva es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getTotal().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El Total es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detallecompraService.create(detalle_compra)) {
            return new ResponseEntity(new Message("El Producto fue creado exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("El Producto no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Método List en la Clase detalleCompraService.
     *
     * Este método expone una Api de tipo Get, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/detallecompra/list, esta URL
     * retorna una lista de arreglos JSON con los parámetros (idDetalleCompra,
     * compraId,productoId,cantidad,monto,iva,descuento,total) de todos los
     * detalles de las compras existentes en la base de datos
     */
    @GetMapping("/detallecompra/list")
    public ResponseEntity< List<MDetalleCompra>> list() {
        List<MDetalleCompra> list_compras = detallecompraService.getList();
        ResponseEntity<List<MDetalleCompra>> reponseEntity = new ResponseEntity<>(list_compras, HttpStatus.OK);
        return reponseEntity;
    }

    /**
     * Método Create en la Clase ProductController.
     *
     * Este método expone una Api de tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones. se procede con la creación del producto.
     */
    @PutMapping("/detallecompra/update")
    public ResponseEntity update(@RequestBody MDetalleCompra detalle_compra) {

        if (!detallecompraService.existsDetalleCompra(detalle_compra.getIdDetalleCompra())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  El Detalle de la compra con codigo (" + detalle_compra.getIdDetalleCompra() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (!detallecompraService.existsCompra(detalle_compra.getCompraId())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  La compra con codigo (" + detalle_compra.getCompraId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (!detallecompraService.existsProduct(detalle_compra.getProductoId())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  El producto con codigo (" + detalle_compra.getProductoId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (detalle_compra.getCantidad() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  La cantidad es un dato entero y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getMonto().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El monto es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getIva().intValue() < 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El iva es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detalle_compra.getTotal().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El Total es un dato decimal y este debe ser mayor a cero (0)."), HttpStatus.BAD_REQUEST);
        }

        if (detallecompraService.create(detalle_compra)) {
            return new ResponseEntity(new Message("El Producto fue creado exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("El Producto no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    /**
     * Método Delete en la Clase ProductController.
     *
     * Este método expone una Api de tipo Delete, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/delete/, esta URL recibe
     * como parámetro un JSON con el parámetro (Id),
     * luego valida si este Id existe, para proceder con la eliminacion de los datos.
     */
    @DeleteMapping("/detallecompra/delete/{id}")
    public ResponseEntity< MCompra> delete(@PathVariable("id") Long id) {
        if (!detallecompraService.existsDetalleCompra(id)) {
            return new ResponseEntity(new Message("El codigo para el detalle de la compra no se encontro en la base de datos.."), HttpStatus.NOT_FOUND);
        } else {
            detallecompraService.delete(id);
            return new ResponseEntity(new Message("detall de compra eliminada con exito.."), HttpStatus.OK);
        }
    }

}
