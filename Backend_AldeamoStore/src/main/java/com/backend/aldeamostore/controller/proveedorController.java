/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MProveedor;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.proveedorService;
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
 * Clase ProveedorController, es esta clase se exponen los metodos necesarios
 * para realizar un CRUD de los Proveedores en la base de datos.
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8080")
public class proveedorController {

    @Autowired
    @Qualifier("ProveedorService")
    private proveedorService proveedorService;

    /**
     * Método Create en la Clase ProductController.Este método expone una Api de
     * tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones.se procede con la creación del producto.
     *
     * @param proveedor
     * @return
     */
    @PostMapping("/proveedor/create")
    public ResponseEntity create(@RequestBody MProveedor proveedor) {

        if (proveedor.getCelular() <= 0) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar un numero de Celular.."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (StringUtils.isAllBlank(proveedor.getDireccion())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar una Direccion para este proveedor."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (StringUtils.isAllBlank(proveedor.getNombre())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar el Nombre del proveedor."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (StringUtils.isAllBlank(proveedor.getRut())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar el Rut del proveedor."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (!proveedor.isStatus()) {
            proveedor.setStatus(true);
        }

        if (proveedorService.create(proveedor)) {
            return new ResponseEntity(new Message("El Proveedor fue creado exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("El Proveedor no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * método List en la Clase ProductController. Este método expone una Api de
     * tipo Get, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/proveedor/list/ esta URL retorna
     * una lista de arreglos JSON con los parámetros
     * (proveedorId,celular,direccion,nombre,rut,status,web) de todos los
     * proveedores existentes en la base de datos
     *
     * @return
     */
    @GetMapping("/proveedor/list")
    public ResponseEntity< List<MProveedor>> list() {
        List<MProveedor> listProduct = proveedorService.list();
        ResponseEntity<List<MProveedor>> reponseEntity = new ResponseEntity<>(listProduct, HttpStatus.OK);
        return reponseEntity;
    }

    /**
     * Método Create en la Clase ProductController.Este método expone una Api de
     * tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones.se procede con la creación del producto.
     *
     * @param proveedor
     * @return
     */
    @PutMapping("/proveedor/update")
    public ResponseEntity update(@RequestBody MProveedor proveedor) {

        if (!proveedorService.existProveedor(proveedor.getProveedorId())) {
            return new ResponseEntity(new Message("El codigo del Proveedor <== " + proveedor.getProveedorId() + " ==> no se encontro en la base de datos..."), HttpStatus.NOT_FOUND);
        } else {

            if (proveedor.getCelular() <= 0) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar un numero de Celular.."), HttpStatus.NOT_ACCEPTABLE);
            }

            if (StringUtils.isAllBlank(proveedor.getDireccion())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar una Direccion para este proveedor."), HttpStatus.NOT_ACCEPTABLE);
            }

            if (StringUtils.isAllBlank(proveedor.getNombre())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar el Nombre del proveedor."), HttpStatus.NOT_ACCEPTABLE);
            }

            if (StringUtils.isAllBlank(proveedor.getRut())) {
                return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  debe ingresar el Rut del proveedor."), HttpStatus.NOT_ACCEPTABLE);
            }

            if (proveedorService.update(proveedor)) {
                return new ResponseEntity(new Message("El Proveedor fue actualizado exitosamente.."), HttpStatus.CREATED);
            } else {
                return new ResponseEntity(new Message("El Proveedor no fue actualizado."), HttpStatus.INTERNAL_SERVER_ERROR);
            }
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
    @DeleteMapping("/proveedor/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!proveedorService.existProveedor(id)) {
            return new ResponseEntity(new Message("El Id del Proveedor no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            proveedorService.delete(id);
            return new ResponseEntity(new Message("Proveedor eliminado con exito.."), HttpStatus.OK);
        }
    }

}
