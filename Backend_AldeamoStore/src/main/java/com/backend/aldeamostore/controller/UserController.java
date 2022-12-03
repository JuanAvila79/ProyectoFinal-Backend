/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.controller;

import com.backend.aldeamostore.model.MUser;
import com.backend.aldeamostore.model.Message;
import com.backend.aldeamostore.service.userService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@RestController
@RequestMapping("/aldeamostore/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    @Autowired
    @Qualifier("UserService")
    private userService usuarioService;

    // Metodo para Listar todos los usuarios
    @GetMapping("/user/listAll")
    public ResponseEntity< List<MUser>> listAll() {
        List<MUser> listUsers = usuarioService.listAll();
        ResponseEntity<List<MUser>> reponseEntity = new ResponseEntity<>(listUsers, HttpStatus.OK);
        return reponseEntity;
    }

    // Metodo para buscar un usuario en particular
    @GetMapping("user/findByEmail/{correo}")
    public ResponseEntity< MUser> findByEmail(@PathVariable("correo") String correo) {
        if (!usuarioService.existEmail(correo)) {
            return new ResponseEntity(new Message("El usuario " + correo + ", no existe en la Base de datos..."), HttpStatus.NOT_FOUND);
        } else {
            MUser user = usuarioService.findByEmail(correo);
            return new ResponseEntity<MUser>(user, HttpStatus.OK);
        }
    }

    // Metodo para eliminar un usuario en particular
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity< MUser> deleteUser(@PathVariable("id") Long id) {
        if (!usuarioService.existById(id)) {
            return new ResponseEntity(new Message("Este Id no existe en la base de datos...."), HttpStatus.NOT_FOUND);
        } else {
            usuarioService.delete(id);
            return new ResponseEntity(new Message("Usuario Eliminado con exito.."), HttpStatus.OK);
        }
    }

    // Metodo para crear un usuario
    @PostMapping("/user/create")
    public ResponseEntity createUser(@RequestBody MUser user) {
        if (StringUtils.isBlank(user.getNombres())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Campo Nombres no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(user.getApellidos())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Campo Apellidos no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(user.getEmail())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Campo Email no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.existEmail(user.getEmail())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <--  El email " + user.getEmail() + " ya se ecuentra registrado."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(user.getCountryCode())) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Codigo del Pais no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(user.getCelular()) || user.getCelular().length() < 9) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Campo Celular no puede ser null o estar Vacio, y debe tener minimo 9 digitos.."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(user.getPasswords()) || (user.getPasswords().length() < 5) || (user.getPasswords().length() > 15)) {
            return new ResponseEntity(new Message("Error --> " + HttpStatus.BAD_REQUEST + " <-- el Passwords no puede estar Vacio y debe contener entre 5 y 15 caracteres.."), HttpStatus.BAD_REQUEST);
        }
        if (usuarioService.create(user)) {
            return new ResponseEntity(new Message("Usuario Creado Exitosamente"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(new Message("Usuario No Creado"), HttpStatus.CONFLICT);
        }

    }

    // Metodo para actualizar un usuario
    @PutMapping("/user/update/")
    public ResponseEntity<?> updateUser(@RequestBody MUser user) {
        if (!usuarioService.existEmail(user.getEmail())) {
            return new ResponseEntity(new Message("El usuario "+user.getEmail() +" ya no existe en la base de datos..."), HttpStatus.BAD_REQUEST);
        } else {
           MUser request_update =  usuarioService.update(user);
            return new ResponseEntity<MUser>(request_update, HttpStatus.OK);
        }
    }
}
