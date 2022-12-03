/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.backend.aldeamostore.repository;

import com.backend.aldeamostore.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Repository("RolRepository")
public interface rolRepository extends JpaRepository<Rol, Long> {

    public abstract Rol findByDescripcion(String descripcion);

    public abstract Rol findByStatus(boolean status);

    public abstract boolean existsByDescripcion(String descripcion);

}
