/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Categoria;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Data
@Getter
@Setter

public class MCategoria {
    private Long categoriaId;
    private String nombre;
    private boolean status;

    public MCategoria() {
    }

    public MCategoria(Long categoriaId, String nombre, boolean status) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.status = status;
    }

    public MCategoria(Categoria categoria) {
        this.categoriaId = categoria.getCategoriaId();
        this.nombre = categoria.getNombre();
        this.status = categoria.isStatus();
    }

}
