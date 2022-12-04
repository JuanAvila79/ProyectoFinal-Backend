/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.Proveedor;
import com.backend.aldeamostore.model.MProveedor;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Avila Meza
 */
@Component("ProveedorConverter")
public class proveedorConverter {

    public List<MProveedor> converterList(List<Proveedor> proveedor) {
        List<MProveedor> model_proveedor = new ArrayList<>();
        for (Proveedor entity_proveedor : proveedor) {
            model_proveedor.add(new MProveedor(entity_proveedor));
        }
        return model_proveedor;
    }

    public MProveedor converterEntityToModel(Proveedor proveedor) {
        MProveedor model_proveedor = new MProveedor(proveedor);
        return model_proveedor;
    }

    public Proveedor converterModelToEntity(MProveedor proveedor) {
        Proveedor entity_proveedor = new Proveedor(proveedor);
        return entity_proveedor;
    }

}
