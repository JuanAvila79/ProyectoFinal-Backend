/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.aldeamostore.entity;

import com.backend.aldeamostore.model.MNotificacion;
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
@Table(name = "tb_notificacion", catalog = "db_semillero", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n"),
    @NamedQuery(name = "Notificacion.findByNotificacionId", query = "SELECT n FROM Notificacion n WHERE n.notificacionId = :notificacionId"),
    @NamedQuery(name = "Notificacion.findByAsunto", query = "SELECT n FROM Notificacion n WHERE n.asunto = :asunto"),
    @NamedQuery(name = "Notificacion.findByStatus", query = "SELECT n FROM Notificacion n WHERE n.status = :status"),
    @NamedQuery(name = "Notificacion.findByCanalId", query = "SELECT n FROM Notificacion n WHERE n.canalId = :canalId"),
    @NamedQuery(name = "Notificacion.findByTipoNotificacionId", query = "SELECT n FROM Notificacion n WHERE n.tipoNotificacionId = :tipoNotificacionId"),
    @NamedQuery(name = "Notificacion.findByUserId", query = "SELECT n FROM Notificacion n WHERE n.userId = :userId")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notificacion_id", nullable = false)
    private Long notificacionId;

    @Basic(optional = false)
    @Column(name = "tipo_notificacion_id", nullable = false)
    private Long tipoNotificacionId;

    @Basic(optional = false)
    @Column(name = "canal_id", nullable = false)
    private Long canalId;

    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String asunto;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;

    public Notificacion() {
    }

    public Notificacion(long notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Notificacion(Long notificacionId, Long tipoNotificacionId, Long canalId, Long userId, String asunto, boolean status) {
        this.notificacionId = notificacionId;
        this.asunto = asunto;
        this.status = status;
        this.canalId = canalId;
        this.tipoNotificacionId = tipoNotificacionId;
        this.userId = userId;
    }

    public Notificacion(MNotificacion notificacion) {
        this.notificacionId = notificacion.getNotificacionId();
        this.tipoNotificacionId = notificacion.getTipoNotificacionId();
        this.canalId = notificacion.getCanalId();
        this.userId = notificacion.getUserId();
        this.asunto = notificacion.getAsunto();
        this.status = notificacion.isStatus();
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificacionId != null ? notificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.notificacionId == null && other.notificacionId != null) || (this.notificacionId != null && !this.notificacionId.equals(other.notificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.backend.aldeamostore.entity.Notificacion[ notificacionId=" + notificacionId + " ]";
    }

}
