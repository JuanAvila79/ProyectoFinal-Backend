/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.backend.aldeamostore.repository;

import com.backend.aldeamostore.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Repository("UserRepository")
public interface userRepository extends JpaRepository<User, Long> {

    @Override
    public abstract Optional<User> findById(Long userId);

    public abstract boolean existsByEmail(String Email);

    public abstract User findByEmail(String email);

    public abstract User findByNombres(String nombres);

    public abstract User findByApellidos(String apellidos);

    public abstract User findByCelular(String celular);

    public abstract User findByStatus(boolean status);
}
