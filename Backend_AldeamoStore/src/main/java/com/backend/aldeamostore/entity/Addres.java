/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Entity
@Table(name = "tb_addres", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addres.findAll", query = "SELECT a FROM Addres a"),
    @NamedQuery(name = "Addres.findByDireccionId", query = "SELECT a FROM Addres a WHERE a.direccionId = :direccionId"),
    @NamedQuery(name = "Addres.findByApartamento", query = "SELECT a FROM Addres a WHERE a.apartamento = :apartamento"),
    @NamedQuery(name = "Addres.findByCasa", query = "SELECT a FROM Addres a WHERE a.casa = :casa"),
    @NamedQuery(name = "Addres.findByCiudad", query = "SELECT a FROM Addres a WHERE a.ciudad = :ciudad"),
    @NamedQuery(name = "Addres.findByDepartamento", query = "SELECT a FROM Addres a WHERE a.departamento = :departamento"),
    @NamedQuery(name = "Addres.findByDireccion", query = "SELECT a FROM Addres a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Addres.findByMunicipio", query = "SELECT a FROM Addres a WHERE a.municipio = :municipio"),
    @NamedQuery(name = "Addres.findByPais", query = "SELECT a FROM Addres a WHERE a.pais = :pais"),
    @NamedQuery(name = "Addres.findByUserId", query = "SELECT a FROM Addres a WHERE a.userId = :userId")})
public class Addres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "direccion_id", nullable = false)
    private Long direccionId;
    @Column(length = 100)
    private String apartamento;
    @Column(length = 100)
    private String casa;
    @Column(length = 100)
    private String ciudad;
    @Column(length = 100)
    private String departamento;
    @Column(length = 200)
    private String direccion;
    @Column(length = 100)
    private String municipio;
    @Column(length = 100)
    private String pais;
    @Column(name = "user_id")
    private BigInteger userId;

    public Addres() {
    }

    public Addres(Long direccionId) {
        this.direccionId = direccionId;
    }

    public Long getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(Long direccionId) {
        this.direccionId = direccionId;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (direccionId != null ? direccionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addres)) {
            return false;
        }
        Addres other = (Addres) object;
        if ((this.direccionId == null && other.direccionId != null) || (this.direccionId != null && !this.direccionId.equals(other.direccionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Addres[ direccionId=" + direccionId + " ]";
    }
    
}
