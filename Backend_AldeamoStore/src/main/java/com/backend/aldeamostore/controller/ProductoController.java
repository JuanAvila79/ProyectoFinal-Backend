/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.service.productoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductoController {

    @Autowired
    @Qualifier("ProductoService")
    private productoService productService;

    // Metodo para Listar todos los usuarios
    @GetMapping("/product/listAll")
    public ResponseEntity< List<MProducto>> listAll() {
        List<MProducto> listProduct = productService.listAll();
        ResponseEntity<List<MProducto>> reponseEntity = new ResponseEntity<>(listProduct, HttpStatus.OK);
        return reponseEntity;
    }

}
