/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.backend.aldeamostore.repository;

import com.backend.aldeamostore.entity.Canal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Repository("CanalRepository")
public interface canalRepository extends JpaRepository<Canal, Long> {
    
}
