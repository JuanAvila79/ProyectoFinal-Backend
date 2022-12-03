/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.User;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Data
@Getter
@Setter

public class MUser {

    private Long userId;
    private Long rolId;
    private String nombres;
    private String apellidos;
    private String celular;
    private String countryCode;
    private Date dateCreate;
    private int edad;
    private String email;
    private String passwords;
    private String photourl;
    private boolean status;
    

    public MUser() {
    }

    public MUser(Long userId, String nombres, String apellidos, String celular, String countryCode, Date dateCreate, int edad, String email, String passwords, String photourl, boolean status, Long rolId) {
        this.userId = userId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.countryCode = countryCode;
        this.dateCreate = dateCreate;
        this.edad = edad;
        this.email = email;
        this.passwords = passwords;
        this.photourl = photourl;
        this.status = status;
        this.rolId = rolId;
    }

    public MUser(User usuario) {
        this.userId = usuario.getUserId();
        this.nombres = usuario.getNombres();
        this.apellidos = usuario.getApellidos();
        this.celular = usuario.getCelular();
        this.countryCode = usuario.getCountryCode();
        this.dateCreate = usuario.getDateCreate();
        this.edad = usuario.getEdad();
        this.email = usuario.getEmail();
        this.passwords = usuario.getPasswords();
        this.photourl = usuario.getPhotourl();
        this.status = usuario.isStatus();
        this.rolId = usuario.getRolId();
    }

}
