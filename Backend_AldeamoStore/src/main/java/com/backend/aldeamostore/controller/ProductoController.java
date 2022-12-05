/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.productoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 *
 * Clase ProductController, es esta clase se exponen los metodos necesarios para
 * realizar un crud de los productos en la base de datos.
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:8080")
public class ProductoController {

    @Autowired
    @Qualifier("ProductoService")
    private productoService productService;

    /**
     * método List en la Clase ProductController.
     *
     * Este método expone una Api de tipo Get, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/list/, esta URL retorna una
     * lista de arreglos JSON con los parámetros
     * (productoId, categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images)
     * de todos los productos existentes en la base de datos
     */
    @GetMapping("/product/list")
    public ResponseEntity< List<MProducto>> list() {
        List<MProducto> listProduct = productService.listAll();
        ResponseEntity<List<MProducto>> reponseEntity = new ResponseEntity<>(listProduct, HttpStatus.OK);
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
    @PostMapping("/product/create")
    public ResponseEntity create(@RequestBody MProducto product) {
        if (!productService.findCategoria(product)) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  la categoria con codigo (" + product.getCategoriaId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }
        if (!productService.findProveedor(product)) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  el proveedor con codigo (" + product.getProveedorId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isAllBlank(product.getTitle()) || StringUtils.isAllEmpty(product.getTitle())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Titulo, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (StringUtils.isAllBlank(product.getImage()) || StringUtils.isAllEmpty(product.getImage())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Image, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (StringUtils.isAllBlank(product.getImages()) || StringUtils.isAllEmpty(product.getImages())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Imagenes, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (StringUtils.isAllBlank(product.getDescription()) || StringUtils.isAllEmpty(product.getDescription())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Descripcion, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (product.getCount()<= 0) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  el stock inicial del producto no puede ser cero.."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (product.getPrice()<= 0) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar almenos una precio.."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (product.getDescuento() < 0 || product.getDescuento().toString().isBlank()) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  ingrese un valor de cero(0) en la propiedad descuento, si el producto no tiene un descuento."), HttpStatus.NOT_ACCEPTABLE);
        }
        if (!product.isStatus()) {
            product.setStatus(true);
        }

        if (productService.create(product)) {
            return new ResponseEntity(new Message("El Producto fue creado exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("El Producto no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Metodo Update en la Clase ProductController.
     *
     * Este Metodo expone una Api de tipo Put, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/update/, esta URL recibe
     * como parametro un JSON con los parametros
     * (productoId,categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones. se procede con la actualizacion del producto
     */
    @PutMapping("/product/update/")
    public ResponseEntity<?> update(@RequestBody MProducto producto) {
        if (!productService.findProducto(producto.getId())) {
            return new ResponseEntity(new Message("El codigo del producto <== " + producto.getId() + " ==> no se encontro en la base de datos..."), HttpStatus.NOT_FOUND);
        } else {
            if (!productService.findCategoria(producto)) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  la categoria con codigo <== " + producto.getCategoriaId() + " ==>, no se encontro en la base de datos.."), HttpStatus.NOT_FOUND);
            }
            if (!productService.findProveedor(producto)) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  el proveedor con codigo <==" + producto.getProveedorId() + " ==>, no se encontro en la base de datos.."), HttpStatus.NOT_FOUND);
            }
            if (StringUtils.isAllBlank(producto.getCategory()) || StringUtils.isAllEmpty(producto.getCategory())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Nombre, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (StringUtils.isAllBlank(producto.getTitle()) || StringUtils.isAllEmpty(producto.getTitle())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Titulo, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (StringUtils.isAllBlank(producto.getImage()) || StringUtils.isAllEmpty(producto.getImage())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Image, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (StringUtils.isAllBlank(producto.getImages()) || StringUtils.isAllEmpty(producto.getImages())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Imagenes, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (StringUtils.isAllBlank(producto.getDescription()) || StringUtils.isAllEmpty(producto.getDescription())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  la propiedad Descripcion, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (producto.getCount()<= 0) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  el stock inicial del producto no puede ser cero.."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (producto.getPrice()<= 0) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar almenos una precio.."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (producto.getDescuento() < 0 || producto.getDescuento().toString().isBlank()) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  ingrese un valor de cero(0) en la propiedad descuento, si el producto no tiene un descuento."), HttpStatus.NOT_ACCEPTABLE);
            }
            if (!producto.isStatus()) {
                producto.setStatus(true);
            }
            MProducto request_update = productService.update(producto);
            return new ResponseEntity<MProducto>(request_update, HttpStatus.OK);
        }
    }

    /**
     * método Delete en la Clase ProductController.
     *
     * Este método expone una Api de tipo Delete, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/delete/{id}, esta URL
     * recibe como parámetro el ID del producto a eliminar, luego verifica si
     * este ID existe en la base de datos apoyándose en el método findProducto()
     * de la clase productService, si el resultado de esta validación es true
     * (existe), se procede a la eliminación del producto usando el método
     * delete() de la clase productService
     */
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!productService.findProducto(id)) {
            return new ResponseEntity(new Message("Este Id no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            productService.delete(id);
            return new ResponseEntity(new Message("Usuario Eliminado con exito.."), HttpStatus.OK);
        }
    }

}
