/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

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

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Entity
@Table(name = "tb_canal", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canal.findAll", query = "SELECT c FROM Canal c"),
    @NamedQuery(name = "Canal.findByCanalId", query = "SELECT c FROM Canal c WHERE c.canalId = :canalId"),
    @NamedQuery(name = "Canal.findByDescripcion", query = "SELECT c FROM Canal c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Canal.findByStatus", query = "SELECT c FROM Canal c WHERE c.status = :status")})
public class Canal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "canal_id", nullable = false)
    private Integer canalId;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Canal() {
    }

    public Canal(Integer canalId) {
        this.canalId = canalId;
    }

    public Canal(Integer canalId, String descripcion, boolean status) {
        this.canalId = canalId;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Integer getCanalId() {
        return canalId;
    }

    public void setCanalId(Integer canalId) {
        this.canalId = canalId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canalId != null ? canalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canal)) {
            return false;
        }
        Canal other = (Canal) object;
        if ((this.canalId == null && other.canalId != null) || (this.canalId != null && !this.canalId.equals(other.canalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Canal[ canalId=" + canalId + " ]";
    }
    
}
