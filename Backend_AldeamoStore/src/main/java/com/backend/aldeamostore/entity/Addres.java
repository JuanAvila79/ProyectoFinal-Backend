/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MAddres;
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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Data
@Getter
@Setter

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

    @Column(name = "user_id")
    private BigInteger userId;

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

    public Addres() {
    }

    public Addres(Long direccionId) {
        this.direccionId = direccionId;
    }

    public Addres(Long direccionId, BigInteger userId, String apartamento, String casa, String ciudad, String departamento, String direccion, String municipio, String pais) {
        this.direccionId = direccionId;
        this.apartamento = apartamento;
        this.casa = casa;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.direccion = direccion;
        this.municipio = municipio;
        this.pais = pais;
        this.userId = userId;
    }

    public Addres(MAddres addres) {
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
