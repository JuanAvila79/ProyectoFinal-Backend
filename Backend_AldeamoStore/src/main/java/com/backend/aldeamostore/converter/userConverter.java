/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.converter;

import com.backend.aldeamostore.entity.User;
import com.backend.aldeamostore.model.MUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Component("UserConverter")
public class userConverter {

    public List<MUser> converterList(List<User> usuario) {
        List<MUser> modelUser = new ArrayList<>();
        for (User entityUser : usuario) {
            modelUser.add(new MUser(entityUser));
        }
        return modelUser;
    }

    public MUser converterEntityToModel(User usuario){
        MUser modelUser = new MUser(usuario);
        return modelUser;
    }
    
    public User converterModelToEntity(MUser usuaro){
        User entityUser = new User(usuaro);
        return entityUser;
    }
    
    
}
