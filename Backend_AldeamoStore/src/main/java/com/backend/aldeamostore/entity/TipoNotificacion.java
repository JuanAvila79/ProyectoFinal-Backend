/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MTipoNotificacion;
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
@Table(name = "tb_tipo_notificacion", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNotificacion.findAll", query = "SELECT t FROM TipoNotificacion t"),
    @NamedQuery(name = "TipoNotificacion.findByTipoNotificacionId", query = "SELECT t FROM TipoNotificacion t WHERE t.tipoNotificacionId = :tipoNotificacionId"),
    @NamedQuery(name = "TipoNotificacion.findByDescripcion", query = "SELECT t FROM TipoNotificacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoNotificacion.findByStatus", query = "SELECT t FROM TipoNotificacion t WHERE t.status = :status")})
public class TipoNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_notificacion_id", nullable = false)
    private Long tipoNotificacionId;

    @Basic(optional = false)
    @Column(nullable = false, length = 70)
    private String descripcion;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public TipoNotificacion() {
    }

    public TipoNotificacion(Long tipoNotificacionId) {
        this.tipoNotificacionId = tipoNotificacionId;
    }

    public TipoNotificacion(Long tipoNotificacionId, String descripcion, boolean status) {
        this.tipoNotificacionId = tipoNotificacionId;
        this.descripcion = descripcion;
        this.status = status;
    }

    public TipoNotificacion(MTipoNotificacion tipo_notificacion) {
        this.tipoNotificacionId = tipo_notificacion.getTipoNotificacionId();
        this.descripcion = tipo_notificacion.getDescripcion();
        this.status = tipo_notificacion.isStatus();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoNotificacionId != null ? tipoNotificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNotificacion)) {
            return false;
        }
        TipoNotificacion other = (TipoNotificacion) object;
        if ((this.tipoNotificacionId == null && other.tipoNotificacionId != null) || (this.tipoNotificacionId != null && !this.tipoNotificacionId.equals(other.tipoNotificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.TipoNotificacion[ tipoNotificacionId=" + tipoNotificacionId + " ]";
    }

}
