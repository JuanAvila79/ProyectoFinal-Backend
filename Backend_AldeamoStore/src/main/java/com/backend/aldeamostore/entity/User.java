/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MUser;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
@Table(name = "tb_user", catalog = "db_semillero", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByApellidos", query = "SELECT u FROM User u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "User.findByCelular", query = "SELECT u FROM User u WHERE u.celular = :celular"),
    @NamedQuery(name = "User.findByCountryCode", query = "SELECT u FROM User u WHERE u.countryCode = :countryCode"),
    @NamedQuery(name = "User.findByDateCreate", query = "SELECT u FROM User u WHERE u.dateCreate = :dateCreate"),
    @NamedQuery(name = "User.findByEdad", query = "SELECT u FROM User u WHERE u.edad = :edad"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByNombres", query = "SELECT u FROM User u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "User.findByPasswords", query = "SELECT u FROM User u WHERE u.passwords = :passwords"),
    @NamedQuery(name = "User.findByPhotourl", query = "SELECT u FROM User u WHERE u.photourl = :photourl"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByRolId", query = "SELECT u FROM User u WHERE u.rolId = :rolId")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic(optional = false)
    @Column(nullable = false, length = 70)
    private String nombres;

    @Basic(optional = false)
    @Column(nullable = false, length = 70)
    private String apellidos;

    @Basic(optional = false)
    @Column(nullable = false, length = 12)
    private String celular;

    @Basic(optional = false)
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;

    @Basic(optional = false)
    @Column(name = "date_create",nullable = false, columnDefinition = " TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Basic(optional = false)
    @Column(nullable = false)
    private int edad;

    @Basic(optional = false)
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String passwords;

    @Column(length = 300)
    private String photourl;

    @Basic(optional = false)
    @Column(nullable = false, columnDefinition = "BIT DEFAULT 0 ")
    private boolean status;

    @Column(name = "rol_id")
    private Long rolId;

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String nombres, String apellidos, String celular, String countryCode, Date dateCreate, int edad, String email, String passwords, String photourl, boolean status, Long rolId) {
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

    public User(MUser usuario) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.User[ userId=" + userId + " ]";
    }

}
