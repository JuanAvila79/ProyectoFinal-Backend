/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MCompra;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.compraService;
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
public class CompraController {

    @Autowired
    @Qualifier("CompraService")
    private compraService compraService;

    // Metodo para Listar todos los usuarios
    @GetMapping("/compras/list")
    public ResponseEntity< List<MCompra>> list() {
        List<MCompra> list_compras = compraService.getList();
        ResponseEntity<List<MCompra>> reponseEntity = new ResponseEntity<>(list_compras, HttpStatus.OK);
        return reponseEntity;
    }

    // Metodo para eliminar un usuario en particular
    @DeleteMapping("/compras/delete/{id}")
    public ResponseEntity< MCompra> delete(@PathVariable("id") Long id) {
        if (!compraService.existById(id)) {
            return new ResponseEntity(new Message("El codigo de la compra no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            compraService.delete(id);
            return new ResponseEntity(new Message("compra eliminada con exito.."), HttpStatus.OK);
        }
    }

    // Metodo para crear un usuario
    @PostMapping("/compras/create")
    public ResponseEntity create(@RequestBody MCompra compra) {
        if (!compraService.existUser(compra)) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el codigo del usuario no existe, verifique los datos ingresados.."), HttpStatus.BAD_REQUEST);
        }
        if (compra.getTotal().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  debe ingresar el valor de la compra.."), HttpStatus.BAD_REQUEST);
        }
        if (compraService.create(compra)) {
            return new ResponseEntity(new Message("Compra registrada con exito.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("Compra no registrada, se ha presentado un error."), HttpStatus.CONFLICT);
        }

    }

    // Metodo para crear un usuario
    @PutMapping("/compras/update")
    public ResponseEntity update(@RequestBody MCompra compra) {
        if (!compraService.existById(compra.getCompraId())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el codigo de la compra no existe, verifique los datos ingresados.."), HttpStatus.BAD_REQUEST);
        }
        if (!compraService.existUser(compra)) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el codigo del usuario no existe, verifique los datos ingresados.."), HttpStatus.BAD_REQUEST);
        }
        if (compra.getTotal().intValue() <= 0) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  debe ingresar el valor de la compra.."), HttpStatus.BAD_REQUEST);
        }
        if (compraService.update(compra)) {
            return new ResponseEntity(new Message("Compra actualizada exitosamente"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("Compra No actualizada"), HttpStatus.CONFLICT);
        }

    }

}
