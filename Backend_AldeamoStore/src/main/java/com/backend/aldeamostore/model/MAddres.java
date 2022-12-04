/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.model;

import com.backend.aldeamostore.entity.Addres;
import java.math.BigInteger;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juan Carlos Avila Meza
 */
@Data
@Getter
@Setter

public class MAddres {
    private Long direccionId;
    private BigInteger userId;
    private String apartamento;
    private String casa;
    private String ciudad;
    private String departamento;
    private String direccion;
    private String municipio;
    private String pais;

    public MAddres() {
    }

    public MAddres(Long direccionId, BigInteger userId, String apartamento, String casa, String ciudad, String departamento, String direccion, String municipio, String pais) {
        this.direccionId = direccionId;
        this.userId = userId;
        this.apartamento = apartamento;
        this.casa = casa;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.direccion = direccion;
        this.municipio = municipio;
        this.pais = pais;
    }

    public MAddres(Addres addres) {
        this.direccionId = addres.getDireccionId();
        this.userId = addres.getUserId();
        this.apartamento = addres.getApartamento();
        this.casa = addres.getCasa();
        this.ciudad = addres.getCiudad();
        this.departamento = addres.getApartamento();
        this.direccion = addres.getDireccion();
        this.municipio = addres.getMunicipio();
        this.pais = addres.getPais();
    }
}
