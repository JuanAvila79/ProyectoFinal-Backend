/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Juan Carlos Avila Meza / Luz Daleth Lopez Jimenez
 */
@Entity
@Table(name = "tb_detalle_notificacion", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleNotificacion.findAll", query = "SELECT d FROM DetalleNotificacion d"),
    @NamedQuery(name = "DetalleNotificacion.findByIdDetalleNotificacion", query = "SELECT d FROM DetalleNotificacion d WHERE d.idDetalleNotificacion = :idDetalleNotificacion"),
    @NamedQuery(name = "DetalleNotificacion.findByFecha", query = "SELECT d FROM DetalleNotificacion d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DetalleNotificacion.findByNotificacionId", query = "SELECT d FROM DetalleNotificacion d WHERE d.notificacionId = :notificacionId")})
public class DetalleNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_notificacion", nullable = false)
    private Long idDetalleNotificacion;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 2147483647)
    private String contenido;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "notificacion_id", nullable = false)
    private int notificacionId;

    public DetalleNotificacion() {
    }

    public DetalleNotificacion(Long idDetalleNotificacion) {
        this.idDetalleNotificacion = idDetalleNotificacion;
    }

    public DetalleNotificacion(Long idDetalleNotificacion, String contenido, Date fecha, int notificacionId) {
        this.idDetalleNotificacion = idDetalleNotificacion;
        this.contenido = contenido;
        this.fecha = fecha;
        this.notificacionId = notificacionId;
    }

    public Long getIdDetalleNotificacion() {
        return idDetalleNotificacion;
    }

    public void setIdDetalleNotificacion(Long idDetalleNotificacion) {
        this.idDetalleNotificacion = idDetalleNotificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(int notificacionId) {
        this.notificacionId = notificacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleNotificacion != null ? idDetalleNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleNotificacion)) {
            return false;
        }
        DetalleNotificacion other = (DetalleNotificacion) object;
        if ((this.idDetalleNotificacion == null && other.idDetalleNotificacion != null) || (this.idDetalleNotificacion != null && !this.idDetalleNotificacion.equals(other.idDetalleNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.DetalleNotificacion[ idDetalleNotificacion=" + idDetalleNotificacion + " ]";
    }
    
}
