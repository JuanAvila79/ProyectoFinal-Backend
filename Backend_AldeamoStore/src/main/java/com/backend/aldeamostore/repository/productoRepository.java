/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.repository;

import com.backend.aldeamostore.entity.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Repository("ProductoRepository")
public interface productoRepository extends JpaRepository<Producto, Long> {

    @Override
    public abstract Optional<Producto> findById(Long Id);
      
    public abstract boolean  existsByCategoriaId(Long categoriaId);
    
    public abstract boolean existsByProveedorId(int proveedorId);
}
