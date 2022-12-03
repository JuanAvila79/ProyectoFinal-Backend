/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.backend.aldeamostore.service;

import com.backend.aldeamostore.converter.userConverter;
import com.backend.aldeamostore.entity.User;
import com.backend.aldeamostore.model.MUser;
import com.backend.aldeamostore.repository.userRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Service("UserService")
public class userService {

    @Autowired
    @Qualifier("UserRepository")
    private userRepository usuarioRepository;

    @Autowired
    @Qualifier("UserConverter")
    private userConverter usuarioConverter;

    public boolean create(MUser user) {
        try {
            usuarioRepository.save(usuarioConverter.converterModelToEntity(user));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public MUser update(MUser user) {
        try {
            if (usuarioRepository.existsByEmail(user.getEmail())) {
                User update_User = usuarioRepository.findByEmail(user.getEmail());
                //update_User.setUserId(user.getUserId());
                update_User.setNombres(user.getNombres());
                update_User.setApellidos(user.getApellidos());
                update_User.setCelular(user.getCelular());
                update_User.setCountryCode(user.getCountryCode());
                update_User.setPasswords(user.getPasswords());
                update_User.setStatus(user.isStatus());
                usuarioRepository.save(update_User);
                user = usuarioConverter.converterEntityToModel(update_User);
                return user;
            } else {
                return   usuarioConverter.converterEntityToModel( usuarioRepository.findByEmail(user.getEmail())) ;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return user;
    }

    public boolean delete(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<MUser> listAll() {
        return usuarioConverter.converterList(usuarioRepository.findAll());
    }

    public boolean existEmail(String email) {
        try {
            return usuarioRepository.existsByEmail(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public MUser findByEmail(String correo) {
        return usuarioConverter.converterEntityToModel(usuarioRepository.findByEmail(correo));
    }

    public boolean existById(Long id) {
        try {
            usuarioRepository.findById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
