/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MNotificacion;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.notificacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8080")
public class NotificacionController {
    
    @Autowired
    @Qualifier("NotificacionService")
    private notificacionService productService;

    /**
     * método List en la Clase ProductController.Este método expone una Api de
     * tipo Get, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/list/, esta URL retorna una
     * lista de arreglos JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images)
     * de todos los productos existentes en la base de datos
     *
     * @return
     */
    @GetMapping("/notificacion/list")
    public ResponseEntity< List<MNotificacion>> list() {
        List<MNotificacion> listProduct = productService.listAll();
        ResponseEntity<List<MNotificacion>> reponseEntity = new ResponseEntity<>(listProduct, HttpStatus.OK);
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
     * @param notificacion
     * @return
     */
    @PostMapping("/notificacion/create")
    public ResponseEntity create(@RequestBody MNotificacion notificacion) {
        
        if (!productService.existsTipoNotificacion(notificacion.getTipoNotificacionId()  )) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  el tipo de notificacion con el codigo ( " + notificacion.getTipoNotificacionId() + " ), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }
        
        if (!productService.existsTipoNotificacion(notificacion.getCanalId() )) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  el canal de notificación con el codigo ( " + notificacion.getCanalId() + " ), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }
        
        if (!productService.existsUser(notificacion.getUserId() )) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  el usuario con el codigo ( " + notificacion.getUserId() + " ), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }
        
        if ( productService.create(notificacion) ) {
            return new ResponseEntity(new Message("El Producto fue creado exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("El Producto no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}
