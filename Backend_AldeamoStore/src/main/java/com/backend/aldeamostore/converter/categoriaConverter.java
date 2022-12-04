/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Categoria;
import com.backend.aldeamostore.model.MCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Component("CategoriaConverter")
public class categoriaConverter {

    public List<MCategoria> converterList(List<Categoria> categoria) {
        List<MCategoria> model_categoria = new ArrayList<>();
        for (Categoria entity_categoria : categoria) {
            model_categoria.add(new MCategoria(entity_categoria));
        }
        return model_categoria;
    }

    public MCategoria converterEntityToModel(Categoria categoria) {
        MCategoria model_categoria = new MCategoria(categoria);
        return model_categoria;
    }

    public Categoria converterModelToEntity(MCategoria categoria) {
        Categoria entity_categoria = new Categoria(categoria);
        return entity_categoria;
    }

}
