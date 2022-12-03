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
        List<MUser> model_user = new ArrayList<>();
        for (User entity_user : usuario) {
            model_user.add(new MUser(entity_user));
        }
        return model_user;
    }

    public MUser converterEntityToModel(User usuario){
        MUser model_user = new MUser(usuario);
        return model_user;
    }
    
    public User converterModelToEntity(MUser usuaro){
        User entity_user = new User(usuaro);
        return entity_user;
    }
    
    
}
