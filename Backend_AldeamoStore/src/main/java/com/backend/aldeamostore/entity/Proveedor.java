/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MProveedor;
import java.io.Serializable;
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
@Setter
@Getter

@Entity
@Table(name = "tb_proveedor", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p"),
    @NamedQuery(name = "Proveedor.findByProveedorId", query = "SELECT p FROM Proveedor p WHERE p.proveedorId = :proveedorId"),
    @NamedQuery(name = "Proveedor.findByCelular", query = "SELECT p FROM Proveedor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT p FROM Proveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedor.findByRut", query = "SELECT p FROM Proveedor p WHERE p.rut = :rut"),
    @NamedQuery(name = "Proveedor.findByStatus", query = "SELECT p FROM Proveedor p WHERE p.status = :status"),
    @NamedQuery(name = "Proveedor.findByWeb", query = "SELECT p FROM Proveedor p WHERE p.web = :web")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proveedor_id", nullable = false)
    private Long proveedorId;

    @Basic(optional = false)
    @Column(nullable = false)
    private long celular;

    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String direccion;

    @Basic(optional = false)
    @Column(nullable = false, length = 70)
    private String nombre;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String rut;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    @Column(length = 250)
    private String web;

    public Proveedor() {
    }

    public Proveedor(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Proveedor(Long proveedorId, long celular, String direccion, String nombre, String rut, boolean status) {
        this.proveedorId = proveedorId;
        this.celular = celular;
        this.direccion = direccion;
        this.nombre = nombre;
        this.rut = rut;
        this.status = status;
    }

    public Proveedor(MProveedor proveedor) {
        this.proveedorId = proveedor.getProveedorId();
        this.celular = proveedor.getCelular();
        this.direccion = proveedor.getDireccion();
        this.nombre = proveedor.getNombre();
        this.rut = proveedor.getRut();
        this.web = proveedor.getWeb();
        this.status = proveedor.isStatus();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorId != null ? proveedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.proveedorId == null && other.proveedorId != null) || (this.proveedorId != null && !this.proveedorId.equals(other.proveedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Proveedor[ proveedorId=" + proveedorId + " ]";
    }

}
