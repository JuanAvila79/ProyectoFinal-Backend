/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MCategoria;
import com.backend.aldeamostore.model.MProducto;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.categoriaService;
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
 *
 * @author Juan Carlos Avila Meza
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8080")
public class CategoriaController {

    @Autowired
    @Qualifier("CategoriaService")
    private categoriaService categoriaService;

    /**
     * @param categoria
     * @param product
     * @return
     *
     * Método Create en la Clase ProductController.
     *
     * Este método expone una Api de tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones.se procede con la creación del producto.
     */
    @PostMapping("/categoria/create")
    @SuppressWarnings("unchecked")
    public ResponseEntity create(@RequestBody MCategoria categoria) {
        if (StringUtils.isAllBlank(categoria.getNombre())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  El nombre de la categoria, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (categoriaService.findCategoriaByName(categoria.getNombre())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  El nombre de la categoria ya existe"), HttpStatus.NOT_ACCEPTABLE);
        }

        if (!categoria.isStatus()) {
            categoria.setStatus(true);
        }

        if (categoriaService.create(categoria)) {
            return new ResponseEntity(new Message("La Categoria fue creada exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("La Categoria no fue creado exitosamente.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return
     *
     * Método List en la Clase CategoriaController.
     *
     * Este método expone una Api de tipo Get, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/categoria/list/, esta URL retorna
     * una lista de arreglos JSON con los parámetros (categoriaId,nombre,status)
     * de todas las Categorias que existentes en la base de datos
     */
    @GetMapping("/categoria/list")
    public ResponseEntity< List<MCategoria>> list() {
        List<MCategoria> listProduct = categoriaService.list();
        ResponseEntity<List<MCategoria>> reponseEntity = new ResponseEntity<>(listProduct, HttpStatus.OK);
        return reponseEntity;
    }

    /**
     * @param categoria
     * @param product
     * @return
     *
     * Método Create en la Clase ProductController.
     *
     * Este método expone una Api de tipo Post, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/product/create/, esta URL recibe
     * como parámetro un JSON con los parámetros (productoId,
     * categoriaId,proveedorId,cantidad,descripcion,descuento,marca,modelo,nombre,precio,status,titulo,image,images),
     * luego valida cada uno de estos parametros y si pasan el filtro de
     * validaciones.se procede con la creación del producto.
     */
    @PutMapping("/categoria/update")
    @SuppressWarnings("unchecked")
    public ResponseEntity update(@RequestBody MCategoria categoria) {
        if (!categoriaService.existCategoria(categoria.getCategoriaId())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_FOUND + " ==>  la categoria con codigo (" + categoria.getCategoriaId() + "), no se econtro en la base d datos.."), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isAllBlank(categoria.getNombre())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  El nombre de la categoria, no puede estas vacia."), HttpStatus.NOT_ACCEPTABLE);
        }

        if (categoriaService.findCategoriaByName(categoria.getNombre())) {
            return new ResponseEntity(new Message("Error <== " + HttpStatus.NOT_ACCEPTABLE + " ==>  El nombre de la categoria ya existe"), HttpStatus.NOT_ACCEPTABLE);
        }

        if (!categoria.isStatus()) {
            categoria.setStatus(true);
        }

        if (categoriaService.create(categoria)) {
            return new ResponseEntity(new Message("La Categoria fue actualizada exitosamente.."), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("La Categoria no fue actualizada.."), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @return
     *
     * Método Delete en la Clase CategoriaController.
     *
     * Este método expone una Api de tipo Delete, por medio de la URL
     * http://localhost:8080/aldeamostore/v1/categoria/delete/{id}, esta URL
     * recibe como parámetro el ID de la categoria a eliminar, luego verifica si
     * este ID existe en la base de datos apoyándose en el método
     * findCategoria() de la clase categoriaService, si el resultado de esta
     * validación es true (existe), se procede a la eliminación del producto
     * usando el método delete() de la clase categoriaService
     */
    @DeleteMapping("/categoria/delete/{id}")
    @SuppressWarnings("unchecked")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!categoriaService.existCategoria(id)) {
            return new ResponseEntity(new Message("el Id de la categoria no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            categoriaService.delete(id);
            return new ResponseEntity(new Message("Categoria eliminado con exito.."), HttpStatus.OK);
        }
    }

}
